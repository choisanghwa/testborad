package org.zero.test.Model.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zero.test.Model.DTO.BoardDTO;
import org.zero.test.Model.DTO.PageCriteria;
import org.zero.test.Model.DTO.SearchCriteria;


@Repository
public class BoardDAO implements BoardDAOImpl {

	
	@Inject
	private SqlSession sqlSession;
	
	private static String namespace ="boardMapper";
	
	@Override
	public int createBoard(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
	
		
		return sqlSession.insert(namespace+".createBoard",dto);
	}
	
	

	
	  @Override
	  public int nowBoard(BoardDTO dto) throws Exception { 
	  // TODO Auto-generated method stub 
		  return sqlSession.selectOne(namespace+".nowBoard",dto); 
	  }
	  
	  //test
	  //lastInset_id error instead
		@Override
		public int nowBoardId(BoardDTO dto) throws Exception {
			// TODO Auto-generated method stub
			return sqlSession.selectOne(namespace+".nowBoardId",dto);
		}
	  
//  lastInset_id error instead
	@Override
	public int addAttachO(String fullName) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("fullNameDAO : " +fullName);
	    	return sqlSession.insert(namespace+".addAttachO",fullName);
	}
	  
		@Override
		public int addAttach(BoardDTO vo) throws Exception {
			// TODO Auto-generated method stub
		    	return sqlSession.insert(namespace+".addAttach",vo);
		}  
	  
	  
	
	@Override
	public List<BoardDTO> listBoard() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".listBoard");
	}

	@Override
	public BoardDTO readBoard(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".readBoard",dto);
	}

	@Override
	public int modifyBoard(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace+".modifyBoard",dto);
	}

	@Override
	public int delectBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+".delectBoard",bno);
	}

	//페이징 처리
	@Override
	public List<BoardDTO> listPage(int page) throws Exception {
		if(page <= 0 ) {
			page = 1;
		}
		
		page = (page -1) * 10;
		return sqlSession.selectList(namespace+".listPage",page);
	}

	//페이징 처리2
	@Override
	public List<BoardDTO> listPageCriteria(PageCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".listPageCriteria",cri);
	}

	@Override
	public int countPagin(PageCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".countPagin",cri);
	}





	//
	@Override
	public int reBoardCreat(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".reBoardCreat",dto);
	}











}
