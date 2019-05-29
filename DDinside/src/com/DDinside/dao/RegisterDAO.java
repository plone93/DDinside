package com.DDinside.dao;

import java.sql.*;

import com.DDinside.dto.MemberVO;

import utils.DBManager;

public class RegisterDAO {
	private RegisterDAO() {}
	private static RegisterDAO instance = new RegisterDAO();
	public static RegisterDAO getInstane() {
		return instance;
	}


	public void insertMember(MemberVO memberVO) {
		String sql = "insert into memberlist1(num, id, pass, name, email) values(memberlist1_seq.nextval,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println(memberVO);
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPass());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getEmail());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
}
