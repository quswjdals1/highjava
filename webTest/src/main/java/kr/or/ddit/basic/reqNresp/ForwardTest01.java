package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forwardTest01.do")
public class ForwardTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ForwardTest01() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// 파라미터 받기
		String userName = request.getParameter("username");
		//이전 문서에서 setAttribute()로 셋팅해서 보낸 데이터는 getAttribute()로 받는다.
		String tel = (String) request.getAttribute("tel");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'><title>Request객채 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>forward 연습</h3>");
		out.println("<p>이름: "+userName+"</p>");
		out.println("<p>전화번호: "+tel+"</p>");

		out.println("</body></html>");
 	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
