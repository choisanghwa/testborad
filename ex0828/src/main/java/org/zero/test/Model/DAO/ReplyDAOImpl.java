package org.zero.test.Model.DAO;

import java.util.List;

import org.zero.test.Model.DTO.BoardDTO;
import org.zero.test.Model.DTO.ReplyDTO;

public interface ReplyDAOImpl {
	public int createReply(ReplyDTO dto) throws Exception;
	public List<ReplyDTO> list(Integer bno) throws Exception;
	public int remove(Integer rno)throws Exception;
	public int upload(ReplyDTO dto) throws Exception;
	
	
	
}
