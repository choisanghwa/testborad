package org.zero.test.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zero.test.Model.DTO.BoardDTO;
import org.zero.test.Model.DTO.PageCriteria;
import org.zero.test.Model.DTO.PageMaker;
import org.zero.test.Model.DTO.SearchCriteria;
import org.zero.test.Service.BoardService;
import org.zero.test.util.MediaUtils;
import org.zero.test.util.UploadFileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Resource(name = "uploadPath")
	private String uploadPath;

	@Inject
	BoardService service;

	/*
	 * serch make befor
	 * 
	 * @RequestMapping(value = "/listPage", method = RequestMethod.GET) public
	 * String home(@ModelAttribute("cri")PageCriteria cri,BoardDTO dto, Model
	 * model)throws Exception { System.out.println("size" +
	 * service.listBoard().size());
	 * model.addAttribute("listBoard",service.listBoard());
	 * 
	 * 
	 * //페이징 처리 model.addAttribute("listBoard",service.listPageCriteria(cri));
	 * 
	 * PageMaker pageMaker = new PageMaker(); pageMaker.setCri(cri);
	 * //pageMaker.setTotalCount(131);
	 * pageMaker.setTotalCount(service.countPagin(cri));
	 * 
	 * model.addAttribute("pageMaker",pageMaker);
	 * 
	 * return "listPage"; }
	 */

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public String home(

			@ModelAttribute("cri") PageCriteria cri, BoardDTO dto, Model model) throws Exception {

		/* model.addAttribute("listBoard",service.listBoard()); */

		// 페이징 처리
		model.addAttribute("listBoard", service.listPageCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		// pageMaker.setTotalCount(131);

		pageMaker.setTotalCount(service.countPagin(cri));

		model.addAttribute("pageMaker", pageMaker);
		// ?page=1&perPageNum=10&searchType=null&keyword=1
		return "listPage";
	}

	@RequestMapping(value = "/registBoard", method = RequestMethod.GET)
	public String registBoard(@RequestParam(value = "bno" ,required =false, defaultValue= "-1") int bno,BoardDTO dto, Model model, HttpSession session) throws Exception {
		
		model.addAttribute("bno", bno);
		return "registBoard";

	}

	@RequestMapping(value = "/createBoard", method = RequestMethod.POST)
	public String createBoard(@RequestParam("") MultipartFile[] file, BoardDTO dto, Model model, HttpSession session) throws Exception {

//		logger.info("orginalName: " + file.getOriginalFilename());
//		logger.info("size: " + file.getSize());
//		logger.info("contentType: " + file.getContentType());
//		logger.info("id: " + (String) session.getAttribute("id"));
		logger.info("확인dd  file.length :" + file[0].getOriginalFilename() );
		// file upload
		// One file upload
		String saveNameOr[] = new String[file.length];
		if (file[0].getOriginalFilename() != "") {
			for(int i = 0;i<file.length;i++) {
			String savedName = uploadFile(file[i].getOriginalFilename(), file[i].getBytes());
			saveNameOr[i] = savedName;
//			model.addAttribute("savedName", savedName);
			logger.info("saveNameOr: " + saveNameOr[i]);
			}
			dto.setFiles(saveNameOr);
//			String a[] = dto.getFiles();
//			for(String fileName : a) {
//				logger.info("확인  dto :" + fileName );
//			}
		}

		int success=0;
		
		if(dto.getBno() != null) {
			
			dto.setTitle("re: "+dto.getTitle());
			success = service.reBoardCreat(dto);
			
			
		}else {
			success = service.createBoard(dto);
			
		}
		
		if (success == 1) {
			dto.setId((String) session.getAttribute("id"));
			int i = service.nowBoard(dto);

			//return "redirect:readBoard?bno=" + i;
			 return "redirect:listPage";
		} else {
			System.out.println("실패");
			return "registBoard2";
		}
	}

	
	// one file upload
	// file upload
	private String uploadFile(String originalFilename, byte[] fileData) throws Exception {

		UUID uid = UUID.randomUUID();

		String savedName = uid.toString() + "_" + originalFilename;

		File target = new File(uploadPath, savedName);

		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	
	////
	///
	//
	@RequestMapping(value = "/readBoard", method = RequestMethod.GET)
	public String readBoard(@RequestParam(value = "bno") int bno, @ModelAttribute("cri") PageCriteria cri, BoardDTO dto,
			Model model, HttpSession session) throws Exception {
		dto.setBno(bno);

		model.addAttribute("boardData", service.readBoard(dto));
		return "readBoard";

	}

	// file upload read
	// file upload orgin
	// 2019-09-05
	// ver.1
	@ResponseBody
	@RequestMapping("displayOneFile")
	public ResponseEntity<byte[]> displayOrFile(String fileName) throws Exception {
		ResponseEntity<byte[]> entity = null;
		String fileNames = "\\" + fileName;
		String ext = fileNames.substring(fileNames.lastIndexOf(".") + 1);

		MediaType mediaType = MediaUtils.getMediaType(ext);

		InputStream in = null;

		logger.info("File Name: " + fileNames);

		HttpHeaders headers = new HttpHeaders();
		// uploadPath : resources/upload
		// fileName : /2017/05/18/ThumbNail_rose_XXXXX.jpg
		try {
			in = new FileInputStream(uploadPath + fileNames);
			if (mediaType != null) {
				headers.setContentType(mediaType);
			} else {
				fileNames = fileNames.substring(fileNames.indexOf("_") + 1);

				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				String fN = new String(fileNames.getBytes("UTF-8"), "ISO-8859-1");
				headers.add("Content-Disposition", "attachment; filename=\"" + fN + "\"");
			}
			byte[] data = IOUtils.toByteArray(in);
			entity = new ResponseEntity<byte[]>(data, headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}

		return entity;
	}


	@RequestMapping("download")
	@ResponseBody
	public byte[] downProcess(HttpServletResponse response, @RequestParam String fileName) throws IOException {
		// File file = new File("C:\\Users\\seedplus\\Desktop\\etst\\" + fileName);
		File file = new File(uploadPath + "\\" + fileName);
		byte[] bytes = FileCopyUtils.copyToByteArray(file);

		String fn = new String(file.getName().getBytes(), "iso_8859_1");

		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
		response.setContentLength(bytes.length);
		return bytes;
	}

	// 수정
	@RequestMapping(value = "/modifyBoard", method = RequestMethod.GET)
	public void modifyget(int bno, BoardDTO dto, Model model, HttpSession session) throws Exception {
		dto.setBno(bno);

		model.addAttribute("boardData", service.readBoard(dto));
	}

	@RequestMapping(value = "/modifyBoard", method = RequestMethod.POST)
	public String modifypost(BoardDTO dto, Model model, HttpSession session) throws Exception {
		service.modifyBoard(dto);
		return "redirect:readBoard?bno=" + dto.getBno();
	}

	// 삭제
	@RequestMapping(value = "/delectBoard", method = RequestMethod.POST)
	public String delectBoard(int bno) throws Exception {
		service.delectBoard(bno);
		return "redirect:/listPage";
	}

}
