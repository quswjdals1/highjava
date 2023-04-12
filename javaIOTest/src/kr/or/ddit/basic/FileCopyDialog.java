package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileCopyDialog {

	public void copyStart() {		
		File file = showDialog("OPEN");
		
		if(file==null) {
			System.out.println("복사할 원본파일의 선택에 실패했습니다.");
			System.out.println("복사 작업 중지...");
			return;
		}
		
		if(!file.exists()) {//원본파일이 없으면
			System.out.println("원본파일"+file.getName()+"이 없습니다.");
			System.out.println("복사 작업 중지...");
		}
		
		File targetDir = new File("d:/d_other/연습용");
		if(!targetDir.exists()) {// 저장할 폴더가 없는경우
			targetDir.mkdirs();
		}
		
		File targetFile = showDialog("SAVE");
		if(targetFile==null) {
			System.out.println("복사될 대상파일 선택에 실패했습니다.");
			System.out.println("복사 작업을 중지합니다...");
			return;
		}
		
		FileInputStream fis=null;
		FileOutputStream fos = null;
		
		try {
			fis=new FileInputStream(file);
			fos=new FileOutputStream(targetFile);
			int data;
			System.out.println("복사시작. . .");
			while((data=fis.read())!=-1) {
				fos.write(data);
			}
			System.out.println("복사완료. . .");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//openType은 열기용일 때는 "OPEN", 저장용일 때는 "SAVE"로 지정한다
	private File showDialog(String openType) {
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new FileCopyDialog().copyStart();
		
	}

}
