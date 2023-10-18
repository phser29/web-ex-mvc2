package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.util.DBManager;


public class BoardDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Board vo;
	
	private BoardDao() {}
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	
	//1. 글추가
	public int insert(String auther, String title, String content) {
		conn = DBManager.getConnection();
		
		if(conn != null) {
			String sql = "INSERT INTO board (id, auther, title, content)"
					+ "VALUES ((SELECT IFNULL(MAX(id),0)+1 FROM board B), ?, ?, ?)";
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, Integer.parseInt(auther));
				pstmt.setString(2, title);
				pstmt.setString(3, content);
				
				int result = pstmt.executeUpdate();
				System.out.println(result);
				if(result != 0) {
					return 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
		}
		
		return -1;
	}
	
	//2. 목록보기
	public ArrayList<Board> list() {
		conn = DBManager.getConnection();
		
		if(conn != null) {
			String sql = "SELECT * FROM board";
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				ArrayList<Board> list = new ArrayList<Board>();
				while(rs.next()) {
					if(rs != null) {
						int id = rs.getInt(1);
						int anther = rs.getInt(2);
						String title = rs.getString(3);
						String content = rs.getString(4);
						Timestamp reg_date = rs.getTimestamp(5);
						Timestamp mog_date = rs.getTimestamp(6);
						
						list.add(new Board(id, anther, title, content, reg_date, mog_date));
					}
				}
				
				if(list != null) {
					return list;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	
	//3. 상세조회
	public Board get(int auther) {
		conn = DBManager.getConnection();
		
		if(conn != null) {
			String sql = "SELECT * FROM board WHERE auther=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, auther);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					int id = rs.getInt(1); 
					String title = rs.getString(3);
					String content = rs.getString(4);
					Timestamp reg_date = rs.getTimestamp(5);
					Timestamp mog_date = rs.getTimestamp(6);
					
					vo = new Board(id, auther, title, content, reg_date, mog_date);
				}
				
				if(vo != null) {
					return vo;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	
	//4. 글수정
	public int update() {
		conn = DBManager.getConnection();
		
		if(conn!=null) {
			String sql = "UPDATE board SET title=?, content=? WHERE auther=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return -1;
	}
	
	//5. 글삭제
	public int delete() {
conn = DBManager.getConnection();
		
		if(conn!=null) {
			String sql = "DELETE FROM board WHERE auther=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return -1;
	}

}
