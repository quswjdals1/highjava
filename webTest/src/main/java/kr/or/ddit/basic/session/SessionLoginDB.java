package kr.or.ddit.basic.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.basic.vo.MemberVO;


@WebServlet("/sessionLoginDB.do")
public class SessionLoginDB extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("id");
		String userPass = request.getParameter("pass");
	
		//입력받은 데이터를 vo에 저장한다.
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_id(userId);
		memberVO.setMem_pass(userPass);

		//dao객체 생성
		MemberDao dao =MemberDao.getInstance();
		
		//DB에서 id와 password가 일치하는지 데이터 검색
		MemberVO mem = dao.getMember(memberVO);
		HttpSession session = request.getSession();
		if(mem!=null) {
			session.setAttribute("member", mem);
			
		}
		response.sendRedirect(request.getContextPath()+"/basic/session/sessionLogin.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
