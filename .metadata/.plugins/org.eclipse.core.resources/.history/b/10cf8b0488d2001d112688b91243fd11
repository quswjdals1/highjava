package kr.or.ddit.basic.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.basic.fileupload.service.FileinfoServiceImpl;
import kr.or.ddit.basic.fileupload.service.IFileinfoService;
import kr.or.ddit.vo.FileinfoVO;

/*
	servlet 3.0 이상에서 파일업로드를 하려면 작성하는 서블릿에 @multipartconfig 어노테이션을
	설정해야 한다.
	
	@multipartconfig의 설정값들
	1. location : 업로드한 파일이 임시적으로 저장될 경로를 지정한다.(기본값: "")
	2. fileSizeThreshold : 이곳에 지정한 값보다 큰파일이 전송되면 location에 지정한 임시 디렉토리에 저장한다
							(단위: byte, 기본값: 0(무조건 임시 디렉토리 사용))
	3. maxFileSize : 1개 파일의 최대 크기(단위: byte, 기본값 : -1L(무제한))
	4. maxRequestSize : 서버로 전송되는 전체 request데이터의 전체 크기
*/

@WebServlet("/fileUpload.do")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*10, maxFileSize = 1024*1024*30,
		maxRequestSize = 1024*1024*100
		)
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("/basic/fileupload/fileUpload.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//업로드될 파일 경로 설정
		String uploadPath = "d:/d_other/uploadFiles";
		
		//저장될 폴더가 없으면 새로만든다.
		File f = new File(uploadPath);
		
		if(!f.exists()) {
			f.mkdirs();
		}
		
		//파일이 아닌 일반데이터는 getParameter()나 getParameterValues로 받는다.
		String userName = request.getParameter("username");
		
		System.out.println("일반파라미터 데이터 username: "+userName);
		
		//------------------------------------------------------------
		
		// 수신 받은 파일 데이터 처리하기
		String fileName = ""; //파일명이 저장될 변수 선언
		
		//수신 받은 파잏이 여러개일 때 Upload한 파일 목록이 저장될 List객체 생성
		List<FileinfoVO> list = new ArrayList<>();
		
		/*
			servlet 3.0 이상에서 새롭게 추가된 upload용 메서드
			1. request.getParts() ==> 전체 part객체를 collection객체에 담아서 반환한다.
			2. request.getPart("part이름") ==> 지정된 part이름 을 가진 개별 part 객체를 반환한다.
											  form태그 안에 입력요소의 name값으로 구별한다.
		*/
		
		// 전체 part객체 개수만큼 반복 처리하기
		for (Part part : request.getParts()) {
			fileName = extractFileName(part);
			
			
			
			//찾은 파일명이 빈 문자열이면 이것은 파일이 아니다.
			if(!"".equals(fileName)) { //파일인지 검사
				//1개의 upload파일에 대한 정보를 저장하기
				FileinfoVO fvo = new FileinfoVO();
				fvo.setFile_writer(userName); //작성자 데이터 저장
				fvo.setOrigin_file_name(fileName); //원본파일명 저장
				
				//실제 저장되는 파일 이름이 중복되는 것을 방지하기 위해서 uuid객체를 이용하여
				//저장할 파일명을 만든다.
				String saveFileName = UUID.randomUUID().toString();
				
				//이 값을 VO에 저장 파일명으로 저장한다.
				fvo.setSave_file_name(saveFileName);
				
				//part.getSize() ==> Upload된 파일의 크기를 반환한다. (단위:byte)
				
				//파일 크기를 구해서 kb단위로 변환해서 VO에 저장한다.
				fvo.setFile_size((long)Math.ceil(part.getSize()/1024.0));
				
				try {
					//part.write()메서드 ==> upload된 파일을 저장하는 메서드
					part.write(uploadPath + File.separator+saveFileName);
				}catch (Exception e) {
					e.printStackTrace();
				}
				list.add(fvo);
			}
			
		}
		
		//List에 저장된 파일정보를 db에 insert한다.
		
		IFileinfoService service = FileinfoServiceImpl.getInstance();
		
		for (FileinfoVO fileinfoVO : list) {
			service.insertFileinfo(fileinfoVO);
		}
	
		response.sendRedirect(request.getContextPath()+"/fileList.do");
		
	}

	
	
	//--------------------------------------------------------
	/*
		part 구조
		
		1. 파일이 아닌 일반 데이터일 경우
		--------------------123987woosouwrqe9237840 ==> part를 구분하는 구분선
		content-disposition : form-data; name="username" ==> form태그에서 name
				==> 빈줄
		gildong ==파라미터 값
		
		
		2) 파일일 경우
		--------------------123987woosouwrqe9237840 ==> part를 구분하는 구분선
		content-disposition : form-data; name="upFile1"; filename="test1.txt" ==> 파일정보
		content-type: text/plain		==>파일 종류
										==>빈줄
		asdf12345안녕						==>파일의 내용
	*/
	//--------------------------------------------------------
	
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

