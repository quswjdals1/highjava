package json;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/lprodList.do")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		ILprodDao dao = LprodDaoImpl.getInstance();
		
		List<LprodVO> selectLprod = dao.selectLprod();
		
		request.setAttribute("list", selectLprod);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/test.jsp");
		rd.forward(request, response);
		
	}

}
