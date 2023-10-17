package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;
import user.UserDao;
import user.UserRequestDto;
import user.UserResponseDto;

/**
 * Servlet implementation class LoginFormAction
 */
public class LoginFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 처리 로직
		
		//0) 파라미터 username, password ->
		//1) 유저가 존재하는지 확인
		//2) 유저의 비밀번호 일치하는지 확인
		//2-1) 일치하면 -> /mypage
		//		session log 저장
		//2-2) 불일치하면 -> /login
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao userDao = UserDao.getInstance();
		UserResponseDto user = userDao.findByUsername(username);
		
		String url = "";
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("log", username);
			url = "/mypage";
		} else {
			url = "/login";
		}
		
		response.sendRedirect(url);
	}

}
