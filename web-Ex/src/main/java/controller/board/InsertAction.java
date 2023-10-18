package controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import model.board.Board;
import model.board.BoardDao;
import model.user.UserDao;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String auther = request.getParameter("auther");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDao dao = BoardDao.getInstance();
		int save = dao.insert(auther, title, content);
		
		if(save != -1) {
			response.sendRedirect("/board/list.jsp");
		} else {
			response.sendRedirect("/board/insert.jsp");
		}
		
	}

}
