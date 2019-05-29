package com.DDinside.dto;

import java.sql.Timestamp;

public class MemberVO {
	private int num;
	private String id;
	private String pass;
	private String name;
	private String email;
	private Timestamp joindate;
	
	public MemberVO() {}

	public MemberVO(int num, String id, String pass, String name, String email, Timestamp joindate) {
		super();
		this.num = num;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.joindate = joindate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getJoindate() {
		return joindate;
	}

	public void setJoindate(Timestamp joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pass=" + pass + ", name=" + name + ", email=" + email
				+ ", joindate=" + joindate + "]";
	}

	
	

	
	
}
