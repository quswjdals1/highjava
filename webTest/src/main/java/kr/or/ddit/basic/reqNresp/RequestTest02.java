package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest02
 */
@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int fv = Integer.parseInt(request.getParameter("fv"));
		int sv = Integer.parseInt(request.getParameter("sv"));
		String opr = request.getParameter("opr");
		int res =0;
//		if(opr.equals("+")) {
//			res = fv+sv;
//		}
//		if(opr.equals("-")) {
//			res = fv-sv;
//		}
//		if(opr.equals("*")) {
//			res = fv*sv;
//		}
//		if(opr.equals("%")) {
//			res = fv%sv;
//		}
//		if(opr.equals("/")) {
//			res = fv/sv;
//		}
		
		// 자바는 String 타입도 case문이 된다..
		switch(opr) {
		case "*":
			res=fv*sv;
			break;
		case "-":
			res=fv-sv;
			break;
		case "/":
			res=fv/sv;
			break;
		case "+":
			res=fv+sv;
			break;
		case "%":
			res=fv%sv;
			break;
		}
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>Request객채 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>계산 결과</h3>");
		out.println("<p>"+fv+" "+opr+" "+sv+" ="+res);

		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
