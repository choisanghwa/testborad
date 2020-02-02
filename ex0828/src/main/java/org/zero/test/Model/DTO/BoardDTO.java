package org.zero.test.Model.DTO;

import java.util.Date;

public class BoardDTO {
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewcount;
	private String id;
	private int boardpw;
	private int tbl_level;
	private String[] files; 
	private String fileOne; 
	private Integer rebno;
	private Integer sqnbno;
	
	
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBoardpw() {
		return boardpw;
	}
	public void setBoardpw(int boardpw) {
		this.boardpw = boardpw;
	}
	public int getTbl_level() {
		return tbl_level;
	}
	public void setTbl_level(int tbl_level) {
		this.tbl_level = tbl_level;
	}
	
	
	  public String[] getFiles() { 
		  return files; 
		  }
	  
	  public void setFiles(String[] files) { 
		  this.files = files; 
		  }
	 
	public String getFileOne() {
		return fileOne;
	}
	public void setFileOne(String fileOne) {
		this.fileOne = fileOne;
	}
	
	
	//
	public Integer getRebno() {
		return rebno;
	}
	public void setRebno(Integer rebno) {
		this.rebno = rebno;
	}
	public Integer getSqnbno() {
		return sqnbno;
	}
	public void setSqnbno(Integer sqnbno) {
		this.sqnbno = sqnbno;
	}
	
	
	
	
	
	
	
}
