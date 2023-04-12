package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import member.service.MemberService;
import member.vo.MemberVO;


@WebServlet("/memberModify.do")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*10, maxFileSize = 1024*1024*30,
		maxRequestSize = 1024*1024*100
		)
public class MemberModify extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		MemberVO memberVO = new MemberVO();
		String id = request.getParameter("id");
		String pw= request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String add= request.getParameter("add");
		
		memberVO.setMem_id(id);
		memberVO.setMem_pass(pw);
		memberVO.setMem_name(name);
		memberVO.setMem_tel(tel);
		memberVO.setMem_addr(add);
		
		//file request
		String fileName="";
		//업로드될 파일 경로 설정
		String uploadPath = "C:/Users/PC-26/Desktop/memberPhoto";
				
				//저장될 폴더가 없으면 새로만든다.
		File f = new File(uploadPath);
				
		if(!f.exists()) {
			f.mkdirs();
		}
				
				
		Collection<Part> parts = request.getParts();
		for (Part part : request.getParts()) {
			fileName = extractFileName(part);
					
				
					
					//찾은 파일명이 빈 문자열이면 이것은 파일이 아니다.
			if(!"".equals(fileName)) { //파일인지 검사
						
						//실제 저장되는 파일 이름이 중복되는 것을 방지하기 위해서 uuid객체를 이용하여
						//저장할 파일명을 만든다.
				String saveFileName = UUID.randomUUID().toString();
						
						//이 값을 VO에 저장 파일명으로 저장한다.
				memberVO.setMem_photo(saveFileName);
						

				try {
							//part.write()메서드 ==> upload된 파일을 저장하는 메서드
					part.write(uploadPath + File.separator+saveFileName);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
					
		}
				
				
				//update service 코드부분
		MemberService service = MemberService.getInstance();
		String prephoto = service.selectPhoto(id);
		int res = service.updateMember(memberVO);
		if(res==1) {
			System.out.println("성공, 포토 지우는 작업 추가");
			File file = new File(uploadPath + File.separator+prephoto);
			if(file.exists()) {
				if(file.delete()) {
					System.out.println("이미지 삭제 성공");
				}else {
					System.out.println("이미지 삭제 실패");
				}
				
			}
		}else {
			System.out.println("실패");
		}
				
		response.sendRedirect(request.getContextPath()+"/member/memberList.jsp");
				
				
				
				
				
				
		
	}
	
	private String extractFileName(Part part) {
		String fileName="";
		String headerValue = part.getHeader("content-disposition"); //헤더의 키값을 이용하여 값읗 구한다.
		String[] items = headerValue.split(";");
		
		for (String item : items) {
			if(item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=")+2,item.length()-1);
			}
		}
		
		return fileName;
	}

}
