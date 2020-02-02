package org.zero.test.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zero.test.Model.DTO.UserDTO;
import org.zero.test.Service.UserService;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class UserController {

	
	@Inject
	UserService service;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpSession session) {
		
		return "login";
	}
	
	
	@RequestMapping(value = "/loginout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model,HttpSession session) {
		session.invalidate();
		return "redirect:/listPage";
	}
	
	
	@RequestMapping (value = "/loginGo", method = { RequestMethod.GET,RequestMethod.POST})
	public String insertMembers(@RequestParam(value="member",defaultValue="0")int member,UserDTO dto, Model model,HttpSession session) throws Exception{
		
		if (member == 0) {
			UserDTO success = new UserDTO();
			
			if(service.userLogin(dto) == null) {
				logger.info("Login 확인  :"  );
				return "login";
			}else {
			 success = service.userLogin(dto); 
			
			
			  session.setAttribute("id", success.getId()); session.setAttribute("name",success.getUsername()); 
			  session.setAttribute("level",success.getUserLevel());
			 
			}
		}else if(member == 1) {
			
		}
		return "redirect:/listPage";
	}
	
}
