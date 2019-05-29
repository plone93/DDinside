package com.DDinside.dto;

import java.sql.Timestamp;

public class CommentVO {
	private String board_id;
	private int num;
	private int board_num;
	private String board_title;
	private String writer_id;
	private String writer_name;
	private String content;
	private Timestamp writedate;
	
	public CommentVO() {}
	
	public CommentVO(String board_id, int num, int board_num, String board_title, String writer_id, String writer_name,
			String content, Timestamp writedate) {
		super();
		this.board_id = board_id;
		this.num = num;
		this.board_num = board_num;
		this.board_title = board_title;
		this.writer_id = writer_id;
		this.writer_name = writer_name;
		this.content = content;
		this.writedate = writedate;
	}
	public String getBoard_id() {
		return board_id;
	}
	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getWriter_id() {
		return writer_id;
	}
	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}
	public String getWriter_name() {
		return writer_name;
	}
	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getWritedate() {
		return writedate;
	}
	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}
	@Override
	public String toString() {
		return "CommentVO [board_id=" + board_id + ", num=" + num + ", board_num=" + board_num + ", board_title="
				+ board_title + ", writer_id=" + writer_id + ", writer_name=" + writer_name + ", content=" + content
				+ ", writedate=" + writedate + "]";
	}
	
	
	
	

}
