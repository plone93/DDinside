package com.DDinside.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DDinside.dto.MemberVO;

import utils.DBManager;

public class MemberDAO {
	//싱글톤
	private MemberDAO() {}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	//회원정보 수정
	public MemberVO getMember(String num) {
		String sql = "select * from memberlist1 where num =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO memberVO = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
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
	
	public String getMemberPass(String num) {
		String sql = "select * from memberlist1 where num =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pass = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pass = rs.getString("pass");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}	
		return pass;
	}
	
	public int updateMember(MemberVO memberVO) {
		int result = -1;
		String sql = "update memberlist1 set pass=?, name=?, email=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getPass());
			pstmt.setString(2, memberVO.getName());
			pstmt.setString(3, memberVO.getEmail());
			pstmt.setString(4, memberVO.getId());
			
			result = pstmt.executeUpdate();
		}catch(Exception e) { 
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	public void memberDelete(String num) {
		String sql = "delete from memberlist1 where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	public int idCheck(String id) {
		String sql = "select id from memberlist1 where id = ?";
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
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
}
