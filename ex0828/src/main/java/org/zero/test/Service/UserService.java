package org.zero.test.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zero.test.Model.DAO.UserDAO;
import org.zero.test.Model.DTO.UserDTO;


@Service
public class UserService implements UserServiceImpl {
	
	
	
	@Inject
	UserDAO userDAO;
	
	@Override
	public int userRegi(UserDTO dto)throws Exception {
		// TODO Auto-generated method stub
		return userDAO.userRegi(dto);
	}

	@Override
	public UserDTO userLogin(UserDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.userLogin(dto);
	}

}
