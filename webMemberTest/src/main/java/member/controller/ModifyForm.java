package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.MemberVO;

/**
 * Servlet implementation class ModifyForm
 */
@WebServlet("/modifyForm.do")
public class ModifyForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		MemberService service = MemberService.getInstance();
		MemberVO member = service.getMember(id);
		
		request.setAttribute("member", member);
		
		request.getRequestDispatcher("/member/memberModify.jsp").forward(request, response);;
	}

}
