package com.DDinside.dao;

import java.sql.*;

import com.DDinside.dto.MemberVO;

import utils.DBManager;

public class LoginDAO {
	private LoginDAO() {}
	private static LoginDAO instance = new LoginDAO();
	public static LoginDAO getInstane() {
		return instance;
	}
	
	public int MemberLogin(String id, String pass) {
		String sql ="select pass from memberlist1 where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pass").equals(pass)) {
					result = 1; //비밀번호가 맞을경우
				} else {
					result = 0; //비밀번호가 맞지 않을 경우
				}
			} else {
				result = -1; //아예 없을 경우
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public int AdminLogin(String id, String pass) {
		String sql ="select pass from adminlist1 where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pass").equals(pass)) {
					result = 1; //비밀번호가 맞을경우
				} else {
					result = 0; //비밀번호가 맞지 않을 경우
				}
			} else {
				result = -1; //아예 없을 경우
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	
	public MemberVO getMember(String id) {
		String sql = "select * from memberlist1 where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO memberVO = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberVO = new MemberVO();
				memberVO.setNum(rs.getInt("num"));
				memberVO.setId(rs.getString("id"));
				memberVO.setPass(rs.getString("pass"));
				memberVO.setName(rs.getString("name"));
				memberVO.setJoindate(rs.getTimestamp("joindate"));
				memberVO.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return memberVO;
		
	}
	
	public MemberVO getAdmin(String id) {
		String sql = "select * from adminlist1 where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO memberVO = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPass(rs.getString("pass"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return memberVO;
		
	}
}
