package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.mysql.cj.xdevapi.PreparableStatement;

import utill.DBManager;

public class UserDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private UserResponseDto result;
	private ArrayList<UserResponseDto> list;
	
	// GoF 디자인 패턴 중 > 생성 패턴 중 하나인 > Singleton Pattern
	
	private UserDao() {
	}
	private static UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	
	//DB 연동
	
	
	// 1) Create
	public int createUser(String username, String password, String name, String email, String phone, String country, String birth, String gender) {
		conn = DBManager.getConnection();
		
		if(conn != null) {
			String sql = "INSERT INTO `user` (id, username, password, name, email, phone, country, birth, gender)"
					+ "VALUES ((SELECT IFNULL(MAX(id), 0)+1 FROM user B), ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				pstmt.setString(3, name);
				pstmt.setString(4, email);
				pstmt.setString(5, phone);
				pstmt.setString(6, country);
				pstmt.setString(7, birth);
				pstmt.setString(8, gender);
				
				int result = pstmt.executeUpdate();
				if(result == 1) {
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
	
	// 2) Read
	public UserResponseDto findById(int id) {
		conn = DBManager.getConnection();
		
		if(conn != null) {
			String sql = "SELECT * FROM `user` WHERE id=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String username = rs.getString(2);
					String password = rs.getString(3);
					String name = rs.getString(4);
					String email = rs.getString(5);
					String phone = rs.getString(6);
					String country = rs.getString(7);
					String birth = rs.getString(8); //date
					int gender = rs.getInt(9); //int
					
					String genderStr = "";
					if(gender == 1) genderStr = "male";
					else if(gender == 1) genderStr = "female";
					else genderStr = "other";
					
					result = new UserResponseDto(new User(id, username, password, name, email, phone, country, birth, genderStr));
					System.out.println("result: " + result);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		
		return result;
	}
	
	public UserResponseDto findByUsername(String username) {
		conn = DBManager.getConnection();
		
		if(conn != null) {
			String sql = "SELECT * FROM user WHERE username=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int id = rs.getInt(1);
					String password = rs.getString(3);
					String name = rs.getString(4);
					String email = rs.getString(5);
					String phone = rs.getString(6);
					String country = rs.getString(7);
					String birth = rs.getString(8); //date
					int gender = rs.getInt(9); //int
					
					String genderStr = "";
					if(gender == 1) genderStr = "male";
					else if(gender == 1) genderStr = "female";
					else genderStr = "other";
					
					result = new UserResponseDto(new User(id, username, password, name, email, phone, country, birth, genderStr));
					System.out.println("result: " + result);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		
		
		return result;
	}
	
	public ArrayList<UserResponseDto> findAll() {
		conn = DBManager.getConnection();
		
		if(conn != null) {
			String sql = "SELECT * FROM user";
			
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				list = new ArrayList<>();
				
				while(rs.next()) {
					if(rs != null) {
						int id = rs.getInt(1);
						String username = rs.getString(2);
						String password = rs.getString(3);
						String name = rs.getString(4);
						String email = rs.getString(5);
						String phone = rs.getString(6);
						String country = rs.getString(7);
						String birth = rs.getString(8);
						int gender = rs.getInt(9);
						
						String genderStr = "";
						if(gender == 1) genderStr = "male";
						else if(gender == 1) genderStr = "female";
						else genderStr = "other";
						
						list.add(new UserResponseDto(new User(id, username, password, name, email, phone, country, birth, genderStr)));
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		
		return list;
	}
	
//	// 3) Update (password)
//	public boolean setUser(UserRequestDto user, String username, String password, String name, String email, String phone, String country, String birth, String gender) {
//		User target = getUser(user);
//		System.out.println("target: "+target);
//		
//		if(target == null)
//			return false;
//		
//		target.setUsername(username);
//		target.setPassword(password);
//		target.setEmail(email);
//		target.setName(name);
//		target.setBirth(birth);
//		target.setGender(gender);
//		target.setCountry(country);
//		target.setPhone(phone);
//		
//		return true;
//	}
//	
	// 4) Delete
	public int deleteUser(String username) {
		conn = DBManager.getConnection();
		
		if(conn != null) {
			String sql = "DELETE FROM user WHERE username=?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				
				int res = pstmt.executeUpdate();
				if(res > 0) {
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

}
