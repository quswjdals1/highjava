package kr.or.ddit.basic.fileupload.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.basic.fileupload.service.FileinfoServiceImpl;
import kr.or.ddit.basic.fileupload.service.IFileinfoService;
import kr.or.ddit.vo.FileinfoVO;


@WebServlet("/images/imageSrcView.do")
public class ImageSrcView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//파라미터로 넘어온 파일번호를 구한다.
		String strfileno = request.getParameter("fileno");
		Long fileno = Long.parseLong(strfileno);
		
		//파일 번호를 이용하여 db에서 해당 파일정보를 가져온다.
		IFileinfoService service = FileinfoServiceImpl.getInstance();
		FileinfoVO fvo = service.getFileinfo(fileno);
		
		//파일이 저장된 폴더경로 지정
		String uploadPath = "d:/d_other/uploadFiles";
		
		//지정된 폴더경로가 없으면 새로만든다.
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		String imgPath = uploadPath+File.separator+fvo.getSave_file_name();
		File imgFile = new File(imgPath);
		
		if(imgFile.exists()) {
			BufferedInputStream bin=null;
			BufferedOutputStream bout = null;
			
			try {
				//출력용 스트림 객체 생성
				bout = new BufferedOutputStream(response.getOutputStream());
				bin = new BufferedInputStream(new FileInputStream(imgFile));
				
				byte[] temp = new byte[1024];
				int len=0;
				while((len=bin.read(temp))>0) {
					bout.write(temp,0,len);
				}
				bout.flush();
				
			} catch (Exception e) {
				System.out.println("입출력 오류: "+e.getMessage());
			}finally {
				if(bin!=null) bin.close();
				if(bout!=null) bout.close();
			}
			
		}
		
		
	}

}
