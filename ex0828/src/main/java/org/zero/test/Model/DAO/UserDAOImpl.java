package org.zero.test.Model.DAO;

import org.zero.test.Model.DTO.UserDTO;

public interface UserDAOImpl {
	public int userRegi(UserDTO dto) throws Exception;
	public UserDTO userLogin(UserDTO dto) throws Exception;
}
