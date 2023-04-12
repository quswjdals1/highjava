package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		Cookie[] cookies = request.getCookies();
		Cookie cntCookie=null; 
		int cnt=0;
		boolean isContain=false;
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("cnt")) {
				isContain=true;
				cntCookie=cookies[i];
			}
		}
		if(!isContain) {
			Cookie cookie = new Cookie("cnt","1");
			cnt=1;
			response.addCookie(cookie);
		}else {
			cnt=Integer.parseInt(cntCookie.getValue())+1;
			Cookie cookie = new Cookie("cnt",""+cnt);
			response.addCookie(cookie);
		}
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'><title>cookie 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>어서오세요."+cnt+"번째 방문자 입니다.</h3>");
		out.println("<a href='"+request.getContextPath()+"/cookieCountServlet.do"+"'>카운트 증가하기</a>");
		out.println("<a href='"+request.getContextPath()+"/basic/cookie/cookieTest02.jsp"+"'>시작문서로 이동하기</a>");
		
		out.println("</body></html>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
