package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = "test";
		String pw = "test";
		
		String iid= request.getParameter("id").trim();
		String ipw= request.getParameter("pass").trim();
		String[] check = request.getParameterValues("idcookie");
		PrintWriter out = response.getWriter();

		if(check!=null) {
			
			Cookie cookie = new Cookie("cid", iid);
			response.addCookie(cookie);
		}else {
			Cookie [] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName()+" "+cookie.getValue());
				if(cookie.getName().equals("cid")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		if(id.equals(iid)&&pw.equals(ipw)) {
			response.sendRedirect("/webTest/basic/cookie/cookieMain.jsp");
		}else {
			response.sendRedirect("/webTest/basic/cookie/cookieLogin.jsp");
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
