package mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DepartServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 req.setCharacterEncoding("EUC-KR");
		 resp.setContentType("text/html; charset=EUC-KR");
		 		
		String depart = req.getParameter("depart");
		DepartExpert de = new DepartExpert();
		List<String> advice = de.getAdvice(depart);
		
		req.setAttribute("advice", advice); //req에 저장
		
		RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		view.forward(req, resp);
		
		/*PrintWriter pw = resp.getWriter();
		//pw.println("<h2>넘어온 데이터 : " + depart + "</h2>");
		for(String msg : advice) {
			pw.println("<h2>" + msg + "</h2>");
		}
		*/
	}
	
	

}
