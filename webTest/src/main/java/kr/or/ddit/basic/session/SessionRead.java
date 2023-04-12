package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 저장된 session 정보 읽어오기
		
		// 1. Session객체를 생성하거나 현재 Session 가져오기
		HttpSession session = request.getSession();
		session.getAttribute("");
		
		out.println("<html><head><meta charset='utf-8'><title>session 읽기 연습</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Session데이터 확인하기</h2><hr>");
		out.println("<h3>Session 데이터 1개 확인하기</h3>");
		
		//2. 저장된 Session데이터를 개별적으로 가져올 때는 getAttribute()메서드를 사용한다.
		//형식) session객체.getAttribute("key값")
		String sessionValue=(String) session.getAttribute("testSession");
		if(sessionValue==null) {
			out.println("'<h3>testSession'의 세션값이 없습니다</h3>");
		}else {
			out.println("<h3> testSession: "+sessionValue+"</h3><br>");
		}
		
		out.println("<br><br><br>");
		
		out.println("<h3>전체 세션 데이터 확인하기</h3>");
		out.println("<ol>");
		//session의 모든 키값들을 구해서 enumeration객체형으로 반환한다.
		//Enumeration 객체 ==> Iterator의 예전 버전
		Enumeration<String> sessionNames=session.getAttributeNames();
		int cnt=0;
		while(sessionNames.hasMoreElements()) {//다음데이터가 있는지 여부 검사
			cnt++;
			String sessionKey = sessionNames.nextElement();
			out.println("<li>"+sessionKey+" : "+session.getAttribute(sessionKey)+"</li>");
		}
		if(cnt==0) {
			out.println("<li><h3>세션데이터가 하나도 없습니다.</h3></li>");
		}
		out.println("<br><br>");
		
		
		out.println("<hr>");
		//세션ID ==> 세션을 구분하기 위한 고유값
		out.println("세션 ID: "+session.getId()+"<br>");
		//생성시간 ==> 1970년 1월 1일부터 경과한 시간(밀리세컨드 단위)
		out.println("세션 생성 시간: "+session.getCreationTime()+"<br>");
		//최근 접근 시간 ==> 1970년 1월 1일부터 경과한 시간(밀리세컨드 단위)
		out.println("세션 최근 접근 시간: "+ session.getLastAccessedTime()+"<br>");
		
		out.println("세션 유효 시간: "+ session.getMaxInactiveInterval()+"<br>");
		
		
		out.println("<a href='"+request.getContextPath()+"/basic/session/sessionTest.jsp'>시작문서로 이동하기</a>");
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
