package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;

/**
 * Servlet implementation class AddStudentsServlet
 */
@WebServlet("/AddStudentsServlet")
public class AddStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String ckPw = request.getParameter("ckPw");
		String grade = request.getParameter("grade");
		String classs = request.getParameter("class");
		if(pw.equals(ckPw)){
			User.newuser(name, pw, grade, classs);
			String view = "/WEB-INF/view/ok.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
