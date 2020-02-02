package org.zero.test.Service;

import org.zero.test.Model.DTO.UserDTO;

public interface UserServiceImpl {
	public int userRegi(UserDTO dto) throws Exception;
	public UserDTO userLogin(UserDTO dto) throws Exception;
}
