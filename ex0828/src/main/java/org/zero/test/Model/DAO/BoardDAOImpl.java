package org.zero.test.Model.DAO;

import java.util.List;

import org.zero.test.Model.DTO.BoardDTO;
import org.zero.test.Model.DTO.PageCriteria;
import org.zero.test.Model.DTO.SearchCriteria;

public interface BoardDAOImpl {
	public int createBoard(BoardDTO dto) throws Exception;
	public int nowBoard(BoardDTO dto)throws Exception;
	public int nowBoardId(BoardDTO dto)throws Exception;
	public int addAttachO(String fullName)throws Exception;
	public int addAttach(BoardDTO vo)throws Exception;
	
	
	public List<BoardDTO> listBoard() throws Exception;
	public BoardDTO readBoard(BoardDTO dto) throws Exception;
	public int modifyBoard(BoardDTO dto) throws Exception;
	public int delectBoard(int bno) throws Exception;
	
	//페이징 처리
	public List<BoardDTO> listPage(int page)throws Exception;
	
	//페이징처리2
	public List<BoardDTO> listPageCriteria(PageCriteria cri)throws Exception;
	
	//페이징처리3
	public int countPagin(PageCriteria cri)throws Exception;
	
	
	public int reBoardCreat(BoardDTO dto) throws Exception;
	
}
