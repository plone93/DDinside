package com.DDinside.dao;

import java.sql.*;
import java.util.*;

import com.DDinside.dto.BoardVO;
import com.DDinside.dto.CommentVO;
import com.DDinside.dto.CountVO;
import com.DDinside.dto.MemberVO;
import com.DDinside.dto.SearchVO;

import utils.DBManager;


public class Suv_DDinsideDAO {
	private Suv_DDinsideDAO() {} 
	private static Suv_DDinsideDAO instance = new Suv_DDinsideDAO();
	public static Suv_DDinsideDAO getInstance() {return instance;}
	
	public List<BoardVO> selectAllBoards(String board_id){
		String sql = "select * from DDinside where order by num desc";

		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO boardVO = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_id);
			
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				boardVO = new BoardVO();
				
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setName(rs.getString("name"));			
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(boardVO); //Vo 객체의 모든 멤버필드 값을  리스트(첫번째(두번째,세번째..) 배열에)에 넣음
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	//글에 저장된 아이디를 가져오는 작업
	public String selectUserId(String num, String board_id) {
		String sql = "select userid from DDinside where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String writer = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				/*
				 * boardVO = new BoardVO(); boardVO.setUserid("userid");
				 */
				writer = rs.getString("userid");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return writer;
	}
	
	
	public BoardVO BoardView(String num, String board_id) {
		String sql = "select * from DDinside where num = ?";
		BoardVO boardVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next() ) {
				boardVO = new BoardVO();
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return boardVO;
	}
	
	public void updateReadCount(String num, String board_id) {
		String sql ="update DDinside set readcount=readcount+1 where num=? and board_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.setString(2, board_id);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void postUpCount(String num, String board_id) {
		String sql ="update DDinside set up=up+1 where num=?";
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
	public void postDownCount(String num, String board_id) {
		String sql ="update DDinside set down=down+1 where num=?";
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
	
	public void postAhoCount(String num, String board_id) {
		String sql ="update DDinside set aho=aho+1 where num=?";
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
	
	public void postReport(String num, String board_id) {
		String sql ="update DDinside set report=report+1 where num=?";
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
	
	
	public int getReadCount(String num, String board_id) {
		String sql ="select readcount from DDinside where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int readcount = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				readcount = rs.getInt("readcount");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		System.out.println(readcount);
		return readcount;
	}
	
	public CountVO getPostCount(String num, String board_id) {
		String sql ="select up, down, aho from DDinside where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CountVO countVO = new CountVO();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				countVO = new CountVO();
				countVO.setUp(rs.getInt("up"));
				countVO.setDown(rs.getInt("down"));
				countVO.setAho(rs.getInt("aho"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return countVO;
	}
	
	
	
	public void boardDelete(String num, String board_id) {
		String sql ="delete from DDinside where num = ?";
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
	
	
	public List<BoardVO> selectAllBoard(int page, String board_id){
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		BoardVO boardVO = null;
		String sql = "Select * from (SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T) WHERE RNUM BETWEEN ? AND ?) where up >= 5";
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setUp(rs.getInt("up"));
				boardVO.setDown(rs.getInt("down"));
				boardVO.setAho(rs.getInt("aho"));
				boardVO.setReport(rs.getInt("report"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(boardVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<BoardVO> selectAllBoard(int page, String board_id, String word, String hotcount){
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		BoardVO boardVO = null;
		String sql = "Select * from (SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T) WHERE RNUM BETWEEN ? AND ?) where "+word+">="+hotcount;
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setUp(rs.getInt("up"));
				boardVO.setDown(rs.getInt("down"));
				boardVO.setAho(rs.getInt("aho"));
				boardVO.setReport(rs.getInt("report"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(boardVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<BoardVO> selectAllBoard_suv(int page, String board_id, String word, String hotcount){
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		BoardVO boardVO = null;
		String sql ="SELECT * from(SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T where "+word+" >= "+hotcount+") WHERE RNUM BETWEEN ? AND ?";
		//String sql = "Select * from (SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T) WHERE RNUM BETWEEN ? AND ?) where "+word+" >= "+hotcount;
					//SELECT * FROM SELECT * from(SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T where board_id = ?) where "+word+" >= "+hotcount) WHERE RNUM BETWEEN ? AND ?";
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	startNum);
			pstmt.setInt(2, endNum);
	
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setUp(rs.getInt("up"));
				boardVO.setDown(rs.getInt("down"));
				boardVO.setAho(rs.getInt("aho"));
				boardVO.setReport(rs.getInt("report"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				int count = rs.getInt("num");
			
				String sql2 = "select count(*) from DDinside_comment where board_num = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, count);
	
				rs2 = pstmt.executeQuery();				
				if(rs2.next()) {
					boardVO.setCommentcount(rs2.getInt(1));
				}

				list.add(boardVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	

	public List<BoardVO> selectAllBoardTotal(int page, String board_id){
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		BoardVO boardVO = null;
	//	String sql = "Select * from (SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T) WHERE RNUM BETWEEN ? AND ?)";
		String sql ="SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T ) WHERE RNUM BETWEEN ? AND ?";
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setUp(rs.getInt("up"));
				boardVO.setDown(rs.getInt("down"));
				boardVO.setAho(rs.getInt("aho"));
				boardVO.setReport(rs.getInt("report"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				int count = rs.getInt("num");
			
				String sql2 = "select count(*) from DDinside_comment where board_num = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, count);
	
				rs2 = pstmt.executeQuery();				
				if(rs2.next()) {
					boardVO.setCommentcount(rs2.getInt(1));
				}

				list.add(boardVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<BoardVO> selectAllBoardReport(int page, String board_id, String word){
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		BoardVO boardVO = null;
		//String sql = "Select * from (SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T) WHERE RNUM BETWEEN ? AND ?) where "+word+" >= 1";
		String sql ="SELECT * from(SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T where "+word+" >= 1) WHERE RNUM BETWEEN ? AND ?";
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setUp(rs.getInt("up"));
				boardVO.setDown(rs.getInt("down"));
				boardVO.setAho(rs.getInt("aho"));
				boardVO.setReport(rs.getInt("report"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				int count = rs.getInt("num");
			
				String sql2 = "select count(*) from DDinside_comment where board_num = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, count);
	
				rs2 = pstmt.executeQuery();				
				if(rs2.next()) {
					boardVO.setCommentcount(rs2.getInt(1));
				}

				list.add(boardVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<BoardVO> selectAllBoardNotice(int page, String board_id){
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		BoardVO boardVO = null;
		String sql = "Select * from (SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T) WHERE RNUM BETWEEN ? AND ?) where board_id = ?";
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	startNum);
			pstmt.setInt(2, endNum);
			pstmt.setString(3, board_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setUp(rs.getInt("up"));
				boardVO.setDown(rs.getInt("down"));
				boardVO.setAho(rs.getInt("aho"));
				boardVO.setReport(rs.getInt("report"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				int count = rs.getInt("num");
			
				String sql2 = "select count(*) from DDinside_comment where board_num = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, count);
	
				rs2 = pstmt.executeQuery();				
				if(rs2.next()) {
					boardVO.setCommentcount(rs2.getInt(1));
				}

				list.add(boardVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<MemberVO> selectAllAccount(int page){
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		MemberVO memberVO = null;
		String sql = "Select * from (SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY joindate) AS RNUM FROM memberlist1 T) WHERE RNUM BETWEEN ? AND ?)";
		//SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T where board_id = ?) WHERE RNUM BETWEEN ? AND ?";
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				memberVO = new MemberVO();
				memberVO.setNum(rs.getInt("num"));
				memberVO.setId(rs.getString("id"));
				memberVO.setPass(rs.getString("pass"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoindate(rs.getTimestamp("joindate"));
				
				list.add(memberVO);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int tableCount(String board_id, String hotcount) {
		String sql ="select COUNT(*) from DDinside where up >="+hotcount;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;	
	}
	
	
	public int tableCountTotal(String board_id) {
		String sql ="select COUNT(*) from DDinside";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;	
	}
	
	public int memberCountTotal() {
		String sql ="select COUNT(*) from memberlist1";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;	
	}
	
	public int tableCountReport(String board_id, String word) {
		String sql ="select COUNT(*) from DDinside where "+word+" >= 1";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;	
	}
	
	public int tableCountNotice(String board_id) {
		String sql ="select COUNT(*) from DDinside where board_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;	
	}
	
	public int tableCountView(String board_id) {
		String sql ="select COUNT(*) from DDinside where board_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;	
	}
	
	public int searchTableCount(SearchVO searchVO, String board_id) {
		String sql ="select COUNT(*) from (select * from DDinside where title LIKE '%'||?||'%' or content  LIKE '%'||?||'%') where board_id =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setString(2, searchVO.getKeyWord());
			pstmt.setString(3, board_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public int searchTableCount(SearchVO searchVO, String board_id, String word, String hotcount) {
		String sql ="select COUNT(*) from (select * from DDinside where title LIKE '%'||?||'%' or content  LIKE '%'||?||'%') where "+word+" >= "+hotcount;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setString(2, searchVO.getKeyWord());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public int searchTableCountReport(SearchVO searchVO, String board_id, String word, String hotcount) {
		String sql ="select COUNT(*) from (select * from DDinside where title LIKE '%'||?||'%' or content  LIKE '%'||?||'%') where "+word+" >= 1";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setString(2, searchVO.getKeyWord());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public int searchTableCountDown(SearchVO searchVO, String board_id) {
		String sql ="select COUNT(*) from (select * from DDinside where title LIKE '%'||?||'%' or content  LIKE '%'||?||'%') where board_id =? and down >= 5 ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setString(2, searchVO.getKeyWord());
			pstmt.setString(3, board_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public int searchTableCountAho(SearchVO searchVO, String board_id) {
		String sql ="select COUNT(*) from (select * from DDinside where title LIKE '%'||?||'%' or content  LIKE '%'||?||'%') where board_id =? and aho >= 5 ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setString(2, searchVO.getKeyWord());
			pstmt.setString(3, board_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	public int searchTableCountTotal(SearchVO searchVO, String board_id) {
		String sql ="select COUNT(*) from (select * from DDinside where title LIKE '%'||?||'%' or content  LIKE '%'||?||'%')";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setString(2, searchVO.getKeyWord());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	public int searchMemberCount(SearchVO searchVO) {
		String sql ="select COUNT(*) from (select * from DDinside where title LIKE '%'||?||'%' or content  LIKE '%'||?||'%')";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setString(2, searchVO.getKeyWord());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	
	public List<BoardVO> selectNotice() {
		int startNum = 1;
		int endNum = 3;
		BoardVO boardVO = null;
		String sql = "SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM Noticeboard1 T) WHERE RNUM BETWEEN ? AND ?";
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setUp(rs.getInt("up"));
				boardVO.setDown(rs.getInt("down"));
				boardVO.setAho(rs.getInt("aho"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(boardVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public void insertComment(CommentVO commentVO, String board_id) {
		String sql = "insert into DDinside_comment(board_id, num, board_num, board_title, writer_id, writer_name, content) values(?, DDinside_comment_seq.nextval, ?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board_id);
			pstmt.setInt(2, commentVO.getBoard_num());
			pstmt.setString(3, commentVO.getBoard_title());
			pstmt.setString(4, commentVO.getWriter_id());
			pstmt.setString(5, commentVO.getWriter_name());
			pstmt.setString(6, commentVO.getContent());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public List<CommentVO> selectComment(String num, String board_id) {
		String sql = "select * from (select * from DDinside_comment order by writedate asc) where board_num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommentVO commentVO = null;
		List<CommentVO> list = new ArrayList<CommentVO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);

			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				commentVO = new CommentVO();
				commentVO.setBoard_id(rs.getString("board_id"));
				commentVO.setNum(rs.getInt("num"));
				commentVO.setBoard_num(rs.getInt("board_num"));
				commentVO.setWriter_id(rs.getString("writer_id"));
				commentVO.setWriter_name(rs.getString("writer_name"));
				commentVO.setContent(rs.getString("content"));
				commentVO.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(commentVO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return list;
	}


	
	public List<BoardVO> search(int page, SearchVO searchVO, String board_id, String word, String hotcount) {
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		//String sql = "Select * from (Select * from (SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T) WHERE RNUM BETWEEN ? AND ?) where "+word+" >= "+hotcount+")where title LIKE '%'||?||'%' or content  LIKE '%'||?||'%'";
		String sql ="SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T where "+word+" >= "+hotcount+" and (title LIKE '%'||?||'%' or content  LIKE '%'||?||'%')) WHERE RNUM BETWEEN ? AND ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		BoardVO boardVO;
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setString(2, searchVO.getKeyWord());
			pstmt.setInt(3, startNum);
			pstmt.setInt(4, endNum);

			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setUp(rs.getInt("up"));
				boardVO.setDown(rs.getInt("down"));
				boardVO.setAho(rs.getInt("aho"));
				boardVO.setReport(rs.getInt("report"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				int count = rs.getInt("num");
			
				String sql2 = "select count(*) from DDinside_comment where board_num = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, count);
			
				rs2 = pstmt.executeQuery();				
				if(rs2.next()) {
					boardVO.setCommentcount(rs2.getInt(1));
				}

				list.add(boardVO);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<BoardVO> searchReport(int page, SearchVO searchVO, String board_id, String word, String hotcount) {
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		//String sql = "Select * from (Select * from (SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T) WHERE RNUM BETWEEN ? AND ?) where "+word+" >= 1 )where title LIKE '%'||?||'%' or content  LIKE '%'||?||'%'";
		String sql ="SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T where "+word+" >= 1 and (title LIKE '%'||?||'%' or content  LIKE '%'||?||'%')) WHERE RNUM BETWEEN ? AND ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		BoardVO boardVO;
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setString(2, searchVO.getKeyWord());
			pstmt.setInt(3, startNum);
			pstmt.setInt(4, endNum);

			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setUp(rs.getInt("up"));
				boardVO.setDown(rs.getInt("down"));
				boardVO.setAho(rs.getInt("aho"));
				boardVO.setReport(rs.getInt("report"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				int count = rs.getInt("num");
			
				String sql2 = "select count(*) from DDinside_comment where board_num = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, count);
			
				rs2 = pstmt.executeQuery();				
				if(rs2.next()) {
					boardVO.setCommentcount(rs2.getInt(1));
				}

				list.add(boardVO);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<BoardVO> searchDown(SearchVO searchVO, String board_id) {
		String sql = "select * from (select * from DDinside where title LIKE '%'||?||'%' or content  LIKE '%'||?||'%') where board_id = ? and down >= 5  order by writedate desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		BoardVO boardVO;
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setString(2, searchVO.getKeyWord());
			pstmt.setString(3, board_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setUp(rs.getInt("up"));
				boardVO.setDown(rs.getInt("down"));
				boardVO.setAho(rs.getInt("aho"));
				boardVO.setReport(rs.getInt("report"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				int count = rs.getInt("num");
			
				String sql2 = "select count(*) from DDinside_comment where board_num = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, count);
			
				rs2 = pstmt.executeQuery();				
				if(rs2.next()) {
					boardVO.setCommentcount(rs2.getInt(1));
				}

				list.add(boardVO);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<BoardVO> searchAho(SearchVO searchVO, String board_id) {
		String sql = "select * from (select * from DDinside where title LIKE '%'||?||'%'  or content  LIKE '%'||?||'%') where board_id = ? and aho >= 5  order by writedate desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		BoardVO boardVO;
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setString(2, searchVO.getKeyWord());
			pstmt.setString(3, board_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setUp(rs.getInt("up"));
				boardVO.setDown(rs.getInt("down"));
				boardVO.setAho(rs.getInt("aho"));
				boardVO.setReport(rs.getInt("report"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				int count = rs.getInt("num");
			
				String sql2 = "select count(*) from DDinside_comment where board_num = ? and board_id = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, count);
				pstmt.setString(2, board_id);
				rs2 = pstmt.executeQuery();				
				if(rs2.next()) {
					boardVO.setCommentcount(rs2.getInt(1));
				}

				list.add(boardVO);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<BoardVO> searchTotal(int page, SearchVO searchVO, String board_id) {
		int startNum = (page-1)*10+1;
		int endNum = page*10;
		
	//	String sql = "Select * from (SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T) WHERE RNUM BETWEEN ? AND ?)where title LIKE '%'||?||'%' or content LIKE '%'||?||'%'";
		String sql ="SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY writedate DESC) AS RNUM FROM DDinside T where title LIKE '%'||?||'%' or content  LIKE '%'||?||'%') WHERE RNUM BETWEEN ? AND ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		BoardVO boardVO;
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setString(2, searchVO.getKeyWord());
			pstmt.setInt(3, startNum);
			pstmt.setInt(4, endNum);

			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setUp(rs.getInt("up"));
				boardVO.setDown(rs.getInt("down"));
				boardVO.setAho(rs.getInt("aho"));
				boardVO.setReport(rs.getInt("report"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				int count = rs.getInt("num");
			
				String sql2 = "select count(*) from DDinside_comment where board_num = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, count);
			
				rs2 = pstmt.executeQuery();				
				if(rs2.next()) {
					boardVO.setCommentcount(rs2.getInt(1));
				}

				list.add(boardVO);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<BoardVO> searchAccount(SearchVO searchVO) {
		String sql = "Select * from (SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER(ORDER BY joindate DESC) AS RNUM FROM memberlist1 T) WHERE RNUM BETWEEN ? AND ?)where id LIKE '%'||?||'%' or name LIKE '%'||?||'%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		BoardVO boardVO;
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVO.getKeyWord());
			pstmt.setString(2, searchVO.getKeyWord());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardVO = new BoardVO();
				boardVO.setBoard_id(rs.getString("board_id"));
				boardVO.setNum(rs.getInt("num"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPass(rs.getString("pass"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setUserid(rs.getString("userid"));
				boardVO.setItem(rs.getString("item"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setUp(rs.getInt("up"));
				boardVO.setDown(rs.getInt("down"));
				boardVO.setAho(rs.getInt("aho"));
				boardVO.setReport(rs.getInt("report"));
				boardVO.setWritedate(rs.getTimestamp("writedate"));
				
				int count = rs.getInt("num");
			
				String sql2 = "select count(*) from DDinside_comment where board_num = ?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, count);
			
				rs2 = pstmt.executeQuery();				
				if(rs2.next()) {
					boardVO.setCommentcount(rs2.getInt(1));
				}

				list.add(boardVO);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public CommentVO commentView(String num, String board_id) {
		String sql = "select * from DDinside_comment where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommentVO commentVO = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				commentVO = new CommentVO();
				commentVO.setBoard_id(rs.getString("board_id"));
				commentVO.setNum(rs.getInt("num"));
				commentVO.setBoard_num(rs.getInt("board_num"));
				commentVO.setWriter_id(rs.getString("writer_id"));
				commentVO.setWriter_name(rs.getString("writer_name"));
				commentVO.setContent(rs.getString("content"));
				commentVO.setWritedate(rs.getTimestamp("writedate"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return commentVO;
	}

	public void updateComment(CommentVO commentVO, String board_id) {
		String sql = "update DDinside_comment set content = ? where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commentVO.getContent());
			pstmt.setInt(2, commentVO.getNum());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	public void commentDelete(String comment_num, String board_id) {
		String sql ="delete from DDinside_comment where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment_num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	public void insertBoard(BoardVO boardVO, String board_id) {
		String sql = "insert into DDinside(board_id, num, name, title, content, userid, item) values(?, DDinside_seq.nextval, ?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board_id);
			pstmt.setString(2, boardVO.getName());
			pstmt.setString(3, boardVO.getTitle());
			pstmt.setString(4, boardVO.getContent());
			pstmt.setString(5, boardVO.getUserid());
			pstmt.setString(6, boardVO.getItem());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateBoard(BoardVO boardVO, String board_id) {
		String sql = "update DDinside set title=?, pass=?, content=?, item=? where num =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getPass());
			pstmt.setString(3, boardVO.getContent());
			pstmt.setString(4, boardVO.getItem());
			pstmt.setInt(5, boardVO.getNum());
			
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
}
	
