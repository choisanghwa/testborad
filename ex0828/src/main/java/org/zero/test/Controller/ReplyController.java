package org.zero.test.Controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zero.test.Model.DTO.ReplyDTO;
import org.zero.test.Service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Inject
	private ReplyService service;

	// @RequestBody ReplyDTO dto
	@ResponseBody
	@RequestMapping(value = "/re", method = RequestMethod.POST)
	public ResponseEntity<String> register(@ModelAttribute("dto") ReplyDTO dto) {

		ResponseEntity<String> entity = null;

		try {
			service.createReply(dto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@ResponseBody
	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyDTO>> list(@PathVariable("bno") Integer bno) {

		ResponseEntity<List<ReplyDTO>> entity = null;

		try {
			/*
			 * List<ReplyDTO> ll = service.list(bno); System.out.println("size : "
			 * +ll.size());
			 */
			entity = new ResponseEntity<List<ReplyDTO>>(service.list(bno), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyDTO>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@ResponseBody
	@RequestMapping(value = "/remove/{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno") Integer rno) {

		ResponseEntity<String> entity = null;

		try {
			/*
			 * List<ReplyDTO> ll = service.list(bno); System.out.println("size : "
			 * +ll.size());
			 */

			service.remove(rno);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	// {RequestMethod.PUT ,RequestMethod.PATCH}

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/upload/{rno}",method = RequestMethod.PUT ) public
	 * ResponseEntity<String> upload(@PathVariable("rno") Integer rno,@RequestBody
	 * ReplyDTO dto){ System.out.println("오긴했냐"); ResponseEntity<String> entity =
	 * null;
	 * 
	 * try {
	 * 
	 * List<ReplyDTO> ll = service.list(bno); System.out.println("size : "
	 * +ll.size());
	 * 
	 * dto.setRno(rno); service.upload(dto); entity = new
	 * ResponseEntity<String>("SUCCESS",HttpStatus.OK); }catch (Exception e) {
	 * e.printStackTrace(); entity = new
	 * ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST); }
	 * 
	 * 
	 * 
	 * return entity; }
	 */
	
	
	@ResponseBody
	@RequestMapping(value = "/upload",method = RequestMethod.POST )
	public ResponseEntity<String> upload(ReplyDTO dto,HttpServletRequest req){
		//System.out.println("오긴했냐"+req.getParameter("replaytext"));
		ResponseEntity<String> entity = null;
		dto.setReplaytext(req.getParameter("replaytext"));
		dto.setRno(Integer.parseInt(req.getParameter("rno")));
		
		 try { 
			 		service.upload(dto);
			 		entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK); 
		 }catch (Exception e) {
			 		e.printStackTrace(); 
			 		entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST); 
		 }
		 
		
		
		
		return entity;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/listReBoard", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyDTO>> boardList() {

		ResponseEntity<List<ReplyDTO>> entity = null;

		try {
			/*
			 * List<ReplyDTO> ll = service.list(bno); System.out.println("size : "
			 * +ll.size());
			 */
	//		entity = new ResponseEntity<List<ReplyDTO>>(service.reBoardlist(), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ReplyDTO>>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	
	
	
}
