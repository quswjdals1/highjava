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


@WebServlet("/cookieRead.do")
public class CookieRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		//저장된 쿠키 정보 읽어오기
		
		//1. 전체 쿠키정보를 request객체를 통해서 가져온다. ==> 가져온 쿠키정보들은 'Cookie[]'형태로 반환된다.
		//형식) Cookie[] 쿠키배열변수 = request.getCookies();
		
		Cookie[] cookieArr = request.getCookies();
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'><title>cookie 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>cookie정보 확인하기</h3>");
		if(cookieArr==null||cookieArr.length==0) {
			out.println("<h3>저장된 쿠키가 하나도 없습니다.");
		}else {
			for (Cookie cookie : cookieArr) {
				//쿠키배열에서 쿠키 이름과 쿠키 값을 가져옴
				//한글로 저장된 데이터는 디코딩한 후 사용해야한다.
				String name=cookie.getName();
				String value = URLDecoder.decode(cookie.getValue(),"utf-8");
				
				out.println("쿠키이름: "+name+"<br>");
				out.println("쿠키값: "+value+"<br>");
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
