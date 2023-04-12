package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// Request객체를 이용하여 요청할 때 가져온 데이터 처리하기
@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식으로 전달되는 문자데이터의 인코딩 방식 설정
		request.setCharacterEncoding("utf-8");
		
		// 전달되는 데이터 받기
		// request.getParameter("파라미터명") ==> 해당 파라미터에 설정된 '값'을 가져온다.
		//					==>지정한 파라미터명이 없으면 null을 가져온다.
		String userName = request.getParameter("username");
		String job = request.getParameter("job");
		
		// request.getParameterValues("파라미터명") ==> '파라미터명'이 같은 것이 여러개일 경우에 사용한다
		// 					==>가져오는 '값'의 자료형은 String[] 이 된다.
		//					==>지정한 파라미터명이 없으면 null을 가져온다.
		// getParameterValues()를 이용해서 'hobby'로 설정된 form의 체크박스값ㅅ들을 모두 읽어오기
		
		String[] hobbies = request.getParameterValues("hobby");
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>Request객채 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>Request객채 처리 결과</h3>");
		out.println("<table border='1'>");
		out.println("<tr><td>이름</td><td>"+userName+"</td></tr>");
		out.println("<tr><td>직업</td><td>"+job+"</td></tr>");
		out.println("<tr><td>취미</td>");
		out.println("<td>");
		if(hobbies!=null) {
			for (int i = 0; i < hobbies.length; i++) {
				out.println(hobbies[i]+"<br>");
			}
			//향상된 for문
			for (String string : hobbies) {
				out.println(string+"<br>");
			}
		}
		out.print("</td>");
		out.println("</table>");
		
		out.println("<br><hr><br>");
		out.println("<h3>Request객체 메서드</h3>");
		out.println("<ul>");
		out.println("<li>클라이언트 ip 주소: "+ request.getRemoteAddr()+"</li>");
		out.println("<li>요청 방식: "+request.getMethod()+"</li>");
		out.println("<li>ContextPath: "+request.getContextPath()+"</li>");
		out.println("<li>프로토콜: "+request.getProtocol()+"</li>");
		out.println("<li>URL 정보: "+request.getRequestURL()+"</li>");
		out.println("<li>URI 정보: "+request.getRequestURI()+"</li>");
		out.println("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
