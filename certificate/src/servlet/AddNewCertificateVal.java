package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CertificateDAO;
import dto.CertificateDTO;

/**
 * Servlet implementation class AddNewCertificateVal
 */
@WebServlet("/AddNewCertificateVal")
public class AddNewCertificateVal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewCertificateVal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String stuid = request.getParameter("id");
		String certiId = request.getParameter("certificateId");
		String date = request.getParameter("date");
		String acceptance = request.getParameter("acceptance");
		int stuId = Integer.parseInt(stuid);
		int certificateId = Integer.parseInt(certiId);
		Date dateD = Date.valueOf(date);
		boolean stats = false;

		if(Integer.parseInt(acceptance)==1){
			stats = true;
		}

		CertificateDTO addVal = new CertificateDTO(stuId, certificateId, dateD, stats);
		CertificateDAO.addCertificateVal(addVal);

		String view = "/WEB-INF/view/ok.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
