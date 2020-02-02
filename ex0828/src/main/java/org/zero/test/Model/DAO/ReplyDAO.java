package org.zero.test.Model.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zero.test.Model.DTO.BoardDTO;
import org.zero.test.Model.DTO.ReplyDTO;


@Repository
public class ReplyDAO implements ReplyDAOImpl {
	
	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace ="replyMapper";
	
	@Override
	public int createReply(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".createReply",dto);
	}

	@Override
	public List<ReplyDTO> list(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".list",bno);
	}

	@Override
	public int remove(Integer rno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+".remove",rno);
	}

	@Override
	public int upload(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".upload",dto);
	}





}
