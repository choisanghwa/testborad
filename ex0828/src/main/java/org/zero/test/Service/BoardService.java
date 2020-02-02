package org.zero.test.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
import org.zero.test.Model.DAO.BoardDAO;
import org.zero.test.Model.DTO.BoardDTO;
import org.zero.test.Model.DTO.PageCriteria;
import org.zero.test.Model.DTO.SearchCriteria;


@Service
public class BoardService implements BoardServiceImpl {

	
	@Inject
	BoardDAO boardDAO;
	
	@Override
	public int createBoard(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
		BoardDTO vo = new BoardDTO();
		int i = 0;
		String[] files = dto.getFiles();
		i = boardDAO.createBoard(dto);
		if(files != null) {
			//lastInset_id error instead
			
			System.out.println("여긴 됨"+dto.getContent());
			 int bno = boardDAO.nowBoardId(dto); 
			System.out.println("last :" + bno);
			vo.setBno(bno);
			 for(String fullName : files) {
				//lastInset_id error instead
				 	vo.setFileOne(fullName);
//				 System.out.println("fullName : " +fullName);
//					boardDAO.addAttachO(fullName);
//					System.out.println("확인바람");
				 	boardDAO.addAttach(vo);
					 
				 
			 }
			
		}
	
		
		//return boardDAO.createBoard(dto);
		return i;
	}

	@Override
	public int nowBoard(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.nowBoard(dto);
	}

	
	
	

	@Override
	public List<BoardDTO> listBoard() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.listBoard();
	}

	@Override
	public BoardDTO readBoard(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.readBoard(dto);
	}

	@Override
	public int modifyBoard(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.modifyBoard(dto);
	}

	@Override
	public int delectBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.delectBoard(bno);
	}

	//페이징처리2
	@Override
	public List<BoardDTO> listPageCriteria(PageCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.listPageCriteria(cri);
	}

	
	//페이징처리3
	@Override
	public int countPagin(PageCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.countPagin(cri);
	}



	@Override
	public int reBoardCreat(BoardDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.reBoardCreat(dto);
	}
	

}
