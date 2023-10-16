package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import utill.DBManager;

public class UserDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private UserResponseDto result;
	
	// GoF 디자인 패턴 중 > 생성 패턴 중 하나인 > Singleton Pattern
	
	private UserDao() {
	}
	private static UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	
	//DB 연동
	
	
	// 1) Create
//	public boolean createUser(UserRequestDto user) {
//		if(isDuplicatedUser(user)) 
//			return false;
//		
//		User newUser = new User(user);
//		newUser.setId(generateId());
//		list.add(newUser);
//		
//		return true;
//	}
//	
//	public boolean isDuplicatedUser(UserRequestDto user) {
//		
//		for(int i=0; i<list.size(); i++) {
//			if(user.getUsername().equals(list.get(i).getUsername()))
//				return true;
//		}
//		return false;
//	}
//	
//	private int generateId() {
//		int id = 0;
//		
//		boolean isDupl = false;
//		do {
//			id = (int) Math.floor(Math.random() * (9999-1000+1)) + 1000;	// 1000~9999
//
//			for(int i=0; i<list.size(); i++) {
//				if(list.get(i).getId() == id)
//					isDupl = true;
//			}
//		} while(isDupl);
//		
//		return id;
//	}
//	
//	// 2) Read
	public UserResponseDto findById(int id) {
		conn = DBManager.getConnection();
		
		if(conn != null) {
			
			try {
				String sql = "SELECT * FROM `user` WHERE id=?";
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
			}
		}
		 
		return result;
	}
	
//	public UserResponseDto findByUsername(String username) {
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).getUsername().equals(username))
//				return new UserResponseDto(list.get(i));
//		}
//		
//		return null;
//	}
//	
//	public UserResponseDto findByPassword(String password) {
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).getPassword().equals(password))
//				return new UserResponseDto(list.get(i));
//		}
//		
//		return null;
//	}
//	
//	private User getUser(UserRequestDto userDto) {
//		User user = null;
//		
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).getUsername() == userDto.getUsername()) {
//				user = list.get(i);
//			}
//		}
//		
//		return user;
//	}
//	
//	public ArrayList<UserResponseDto> findAll() {
//		// private list 리턴 X (사본) 
//		ArrayList<UserResponseDto> response = new ArrayList<>();
//		
//		for(int i=0; i<list.size(); i++) {
//			User user = list.get(i);
//			response.add(new UserResponseDto(user));
//		}
//		
//		return response;
//	}
//	
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
//	// 4) Delete
//	public boolean deleteUser(UserRequestDto user) {
//		User target = getUser(user);
//		System.out.println("terget: "+target);
//		
//		if(target == null) {
//			return false;
//		}
//		
//		list.remove(target);
//		return true;
//	}
//	
//	public int getSize() {
//		return list.size();
//	}

}
