package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	@WebServlet 어노테이션의 속성들
	1. name: 서블릿 이름을 설정한다.(기본값: 빈 문자열(""))
	2. urlPatterns: 서블릿의 URL패턴의 목록을 설정한다.(기본값: 빈 배열({}))
				예) urlPatterns="/url1" 또는 urlPatterns={"/url1"} ==>패턴이 1개일때
				예) urlPatterns={"/url1","/url2",...} ==> 패턴이 2개 이상일때
	3. value: urlPatterns와 동일한 기능을 한다.
	4. description: 주석(설명글)을 설정한다.	
			
*/


@WebServlet(description = "어노테이션을 이용한 서블릿 설정 연습", urlPatterns = {"/servletTest02.do"})
public class ServletTest02 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		//처리한 내용 출력하기
		//방법2: print(), println()메서드 이용
		out.println("<html><head><meta charset='utf-8'><title>두번째 서블릿</title></head>");
		out.println("<body>");
		out.println("<h1 style='text-align:center;'>안녕하세요 두번째 서블릿 프로그램입니다.<br><br>");
		out.println("어노테이션을 이용하여 서블릿을 등록하는 예제입니다.</h1>");
		out.println("</body></html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
