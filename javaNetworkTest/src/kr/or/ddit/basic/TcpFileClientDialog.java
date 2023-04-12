package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TcpFileClientDialog {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Socket socket=null;
		BufferedOutputStream bos=null;
		try {
			//File file = new File("d:/d_other/컴퓨터1.jpg");
			
			File file = showDialog("OPEN");
			
			
			if(!file.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				System.exit(0);
			}
			
			socket = new Socket("localhost",7777);
			System.out.println("서버에 연결되었습니다.");
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(file.getName());
			
			FileInputStream fis = new FileInputStream(file);
			bos = new BufferedOutputStream(os);
			byte[] temp = new byte[1024];
			int len=0;
			
			while((len=fis.read(temp))!=-1) {
				bos.write(temp,0,len);
			}
			
			bos.flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bos!=null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket!=null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	
	//openType은 열기용일 때는 "OPEN", 저장용일 때는 "SAVE"로 지정한다
	public static File showDialog(String openType) {
				JFileChooser chooser = new JFileChooser();
				
				//선택할 파일의 확장자 설정
				FileNameExtensionFilter doc = new FileNameExtensionFilter("MS Word", "doc","docx");
				FileNameExtensionFilter img = new FileNameExtensionFilter("Image Files", new String[] {"png","jpg","gif"});
				FileNameExtensionFilter pdf = new FileNameExtensionFilter("PDF 파일", "pdf");
				FileNameExtensionFilter txt = new FileNameExtensionFilter("text파일", "txt");
				
				// 구성한 확장자 추가
				chooser.addChoosableFileFilter(doc);
				chooser.addChoosableFileFilter(img);
				chooser.addChoosableFileFilter(pdf);
				chooser.addChoosableFileFilter(txt);
				
				// 구성한 확장자 목록 중에서 현재 선택된 상태가 될 확장자 지정
				// ==>이것을 설정하지 않으면 첫번쨰로 추가한 확장자가 기본적으로 선택된다.
				chooser.setFileFilter(txt);
				
				
				//확장자 목록에 모든파일 목록을 표시할지 여부
				//chooser.setAcceptAllFileFilterUsed(true);
				
				//dialog창이 나타날 때 기본적으로 보여줄 위치
				chooser.setCurrentDirectory(new File("d:/d_other"));
		
				int result=0;
				if(openType.equals("OPEN")) {
					result = chooser.showOpenDialog(new Panel()); //열기
				}else if(openType.equals("SAVE")) {
					result = chooser.showSaveDialog(new Panel()); //저장
				}else {
					System.out.println("openType은 'OPEN'또는 'SAVE'로 지정해야 합니다.");
					return null;
				}

				File selectedFile=null;
				
				if(result==JFileChooser.APPROVE_OPTION) {//파일을 선택하고 '저장','열기' 버튼을 눌렀을 경우
					
					//선택한 파일정보 구하기
					selectedFile = chooser.getSelectedFile();
					System.out.println("선택한 파일: "+selectedFile.getAbsolutePath());
				}
				
				return selectedFile;
	}

}
