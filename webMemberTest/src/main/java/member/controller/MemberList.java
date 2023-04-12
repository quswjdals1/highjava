package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import member.service.MemberService;
import member.vo.MemberVO;


@WebServlet("/memberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		MemberService service = MemberService.getInstance();
		List<MemberVO> list = service.getAllMember();
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		out.print(json);
		out.flush();
	}

}
