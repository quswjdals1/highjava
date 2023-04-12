package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	Servlet의 동작과정...
	1. 사용자(클라이언트)가 URL을 클릭하면 http의 request를 servlet container로 전송한다.
	2. 컨테이너는 web.xml에 정의된 URL패턴을 확인하여 어느 서블릿을 통해 처리해야할 지를 검색한다.
		(해당 서블릿이 로딩이 안 된 경우에는 로딩하고 처음 로딩시 init()메서드를 호출한다.)
		(Servlet 버전 3.0 이상에서는 어노테이션(@WebServlet)으로 설정할 수 있다.)
	3. Servlet Container는 요청을 처리할 개별 쓰레드 객체를 생성하여 해당 서블릿 객체의 service()메서드를 호출한다
		(이 때 httpServletrequest객체와 HttpServletResponse 객체를 생성하여 파라미터로 넘겨준다.)
	4. service()메서드는 클라이언트의 요청 방법(method)을 체크하여 적절한 메서드를 호출한다.
		(doGet,doPost,doDelete,doPut 등...)
	5. 요청 및 응답처리가 완료되면 HttpServletRequest객체와 HttpServletResponse객체는 자동으로 소멸된다.
	6. 컨테이너로부터 서블릿이 제거되는 경우에는 destroy()메서드가 호출된다.
	
*/

@WebServlet("/servletTest03.do")
public class ServletTest03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Servlet : "+this.getServletName()+"에서의 init()메서드 입니다.");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service()메서드 시작...");
		// Get방식과 Post방식을 구분하여 요청방식에 맞는 메서드를 호출한다.
		
		// 방법1 ==> HttpServlet(부모객체)의 service()메서드로 위임하기
		//super.service(req, resp);
		
		// 방법2 ==> 클라이언트의 전송방식(Get,Post)을 구분해서 직접 메서드 호출하기
		String method = req.getMethod(); //클라이언트의 전송 방식을 구하기
		System.out.println("method: "+method);
		
		if("GET".equals(method)) {
			this.doGet(req, resp);
		}else if("POST".equals(method)){
			this.doPost(req, resp);
		}
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Servlet: "+this.getServletName()+"에서의 destroy()매서드 실행");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()메서드가 시작...");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><meta charset='utf-8'>"
				+ "</head><body><h1 style='color:red;'>doGet()메소드 처리내용</h1></body></html>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost메서드 시작...");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><meta charset='utf-8'>"
				+ "</head><body><h1 style='color:blue;>doPost()메소드 처리내용</h1></body></html>");

	}

}
