package org.zero.test.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zero.test.Model.DAO.ReplyDAO;
import org.zero.test.Model.DTO.BoardDTO;
import org.zero.test.Model.DTO.ReplyDTO;


@Service
public class ReplyService implements ReplyServiceImpl {

	
	
	@Inject
	ReplyDAO ReplyDAO;
	
	@Override
	public int createReply(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return ReplyDAO.createReply(dto);
	}

	@Override
	public List<ReplyDTO> list(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return ReplyDAO.list(bno);
	}

	@Override
	public int remove(Integer rno) throws Exception {
		return ReplyDAO.remove(rno);
		// TODO Auto-generated method stub
	}

	@Override
	public int upload(ReplyDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return ReplyDAO.upload(dto);
	}



}
