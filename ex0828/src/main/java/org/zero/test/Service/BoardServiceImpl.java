package org.zero.test.Service;

import java.util.List;

import org.zero.test.Model.DTO.BoardDTO;
import org.zero.test.Model.DTO.PageCriteria;
import org.zero.test.Model.DTO.SearchCriteria;

public interface BoardServiceImpl {
	public int createBoard(BoardDTO dto) throws Exception;
	public int nowBoard(BoardDTO dto)throws Exception;

//	public int addAttach(String fullName)throws Exception;
	
	public List<BoardDTO> listBoard() throws Exception;
	public BoardDTO readBoard(BoardDTO dto) throws Exception;
	public int modifyBoard(BoardDTO dto) throws Exception;
	public int delectBoard(int bno) throws Exception;
	
	//페이징처리2
	public List<BoardDTO> listPageCriteria(PageCriteria cri)throws Exception;
	
	//페이징처리3
	public int countPagin(PageCriteria cri)throws Exception;
	
	//
	public int reBoardCreat(BoardDTO dto)throws Exception;
}
