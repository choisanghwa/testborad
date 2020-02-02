package org.zero.test.Model.DAO;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zero.test.Model.DTO.UserDTO;


@Repository
public class UserDAO implements UserDAOImpl {
	
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace ="userMapper";
	
	@Override
	public int userRegi(UserDTO dto) throws Exception {
		
		return sqlSession.insert(namespace+".userRegi",dto);
	}

	@Override
	public UserDTO userLogin(UserDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".userLogin",dto);
	}

}
