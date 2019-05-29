package com.DDinside.dto;

import java.sql.Timestamp;

public class BoardVO {
	private String board_id;
	private int num;
	private String name;
	private String pass;
	private String title;
	private String content;
	private String userid;
	private String item;
	private int readcount;
	private int commentcount;
	private int up;
	private int down;
	private int aho;
	private int report;
	private Timestamp writedate;
	
	
	public BoardVO() {}


	public BoardVO(String board_id, int num, String name, String pass, String title, String content, String userid,
			String item, int readcount, int commentcount, int up, int down, int aho, int report, Timestamp writedate) {
		super();
		this.board_id = board_id;
		this.num = num;
		this.name = name;
		this.pass = pass;
		this.title = title;
		this.content = content;
		this.userid = userid;
		this.item = item;
		this.readcount = readcount;
		this.commentcount = commentcount;
		this.up = up;
		this.down = down;
		this.aho = aho;
		this.report = report;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
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


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


	public int getReadcount() {
		return readcount;
	}


	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}


	public int getCommentcount() {
		return commentcount;
	}


	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}


	public int getUp() {
		return up;
	}


	public void setUp(int up) {
		this.up = up;
	}


	public int getDown() {
		return down;
	}


	public void setDown(int down) {
		this.down = down;
	}


	public int getAho() {
		return aho;
	}


	public void setAho(int aho) {
		this.aho = aho;
	}


	public int getReport() {
		return report;
	}


	public void setReport(int report) {
		this.report = report;
	}


	public Timestamp getWritedate() {
		return writedate;
	}


	public void setWritedate(Timestamp writedate) {
		this.writedate = writedate;
	}


	@Override
	public String toString() {
		return "BoardVO [board_id=" + board_id + ", num=" + num + ", name=" + name + ", pass=" + pass + ", title="
				+ title + ", content=" + content + ", userid=" + userid + ", item=" + item + ", readcount=" + readcount
				+ ", commentcount=" + commentcount + ", up=" + up + ", down=" + down + ", aho=" + aho + ", report="
				+ report + ", writedate=" + writedate + "]";
	}





	
}
