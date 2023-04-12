package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/responseTest02.do")
public class ResponseTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
			- redirect
			==> 다른 페이지로 넘어가도록 하는 기능을 말한다.
				이 기능은 응답시 브라우저에게 '이동할 URL'을 전송하여 브라우저가 해당URL로 재요청 하여
				이동하는 방식을 말한다. (재요청시 get방식으로 되기 때문에 URL길이에 제한이 있다.)
				==> redirect는 request객체와 response객체를 공유하지 못한다.
			
			==> redirect는 response객체의 sendRedirect() 메서드를 사용한다.
				이 때 이동할 URL주소를 지정해 주는데 주소는 전체 주소를 모두 기술해야 한다.
		*/
		//request.setAttribute("tel", "010-1234-5678"); //redirect는 이런식으로 보낼 수 없음
		
		//데이터를 보내려면 만들어진 데이터를 redirect문서로 보내려면 get방식의 파라미터로 재구성 해서 보내야 한다.
		
		String name=request.getParameter("username");
		String tel = "010-1234-5678";
		
		response.sendRedirect(request.getContextPath()+"/redirectTest.do?username="+name+"&tel="+tel);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
