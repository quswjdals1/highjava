package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieDel.do")
public class CookieDel extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 저장된 쿠키정보 삭제하기
		// ==> 쿠키정보의 삭제는 쿠키의 유지시간을 0으로 설정하는 방법을 사용한다.
		// ==> 유지시간을 0으로 설정한 후 다시	addCookie()메서드를 이용해서 다시 저장하면 기존에 쿠키를 덮어쓴다.
		//		형식)cookie객체변수.setMaxAge(0);
		//			response.addCookie(cookie 객체변수);
		
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html><head><meta charset='utf-8'><title>cookie 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>cookie정보 삭제완료</h3>");
		if(cookieArr!=null){
			for (Cookie cookie : cookieArr) {
				//삭제하려는 쿠키를 찾는다.
				String name=cookie.getName(); //쿠키 이름 구하기
				// 예: 쿠키이름이 gender인 쿠키 삭제하기
				if("gender".equals(name)) {
					cookie.setMaxAge(0); //찾은 쿠키의 유지시간을 0으로 설정
					
					response.addCookie(cookie); // 유지시간이 변경된 쿠키를 다시 respose에 저장하여 덮어쓴다.
				}
				
			}
		}
		out.println("<a href='"+request.getContextPath()+"/basic/cookie/cookieTest01.jsp"+"'>시작문서로 이동하기</a>");
		
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
