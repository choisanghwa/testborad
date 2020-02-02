package org.zero.test.Controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.eclipse.core.internal.runtime.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.zero.test.Model.DTO.BoardDTO;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
/* @RequestMapping("/uploads") */
public class UploadController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	
	@RequestMapping(value = "/uploadTest", method = RequestMethod.POST)
	public String uploadForm(@RequestParam("file") MultipartFile[] file, Model model,BoardDTO dto, HttpSession session) throws Exception{

		
		String originalFilename = "";
		String fileMultName= "";
		
		for(int i = 0; i<file.length;i++) {
			originalFilename = file[i].getOriginalFilename();
			logger.info("orginalName : "+originalFilename);
			SimpleDateFormat format = new SimpleDateFormat("YYYYMMDD_HHMMSS_"+i);
			Calendar now = Calendar.getInstance();
			
			//확장자명
			String extension = originalFilename.split("\\.")[i];
			
			//originalFilename에 날짜 +.+확장자명으로 저장시킴
			originalFilename = format.format(now.getTime())+"."+extension;
			logger.info("변경된 이름: "+originalFilename);
			
			
			File f = new File(uploadPath+"\\"+originalFilename);
			file[i].transferTo(f);
			if(i==0) {
				fileMultName+=originalFilename;
			}
			else {
				fileMultName+=","+originalFilename;
			}
			
			
		}
		
		logger.info("확인: "+fileMultName);
	//	dto.setFileOne(fileMultName);
		
		return "redirect:listPage";
	}


}
