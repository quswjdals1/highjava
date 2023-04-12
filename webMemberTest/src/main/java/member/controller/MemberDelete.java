package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;

/**
 * Servlet implementation class MemberDelete
 */
@WebServlet("/memberDelete.do")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String id = request.getParameter("id");
		
		MemberService service = MemberService.getInstance();
		int res = service.deleteMember(id);
		String str="";
		if(res==1) {
			str="삭제 완료했습니다.";
		}else {
			str="삭제에 실패했습니다.";
		}
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'><title></title>"
				+ "<script type=\"text/javascript\">window.onload=function(){alert(\""+str+"\") \r\n"
				+ "	location.href=\""+request.getContextPath()+"/member/memberList.jsp\"\r\n"
				+ "}</script></head>");
		

		out.println("</html>");
		

	}

}
