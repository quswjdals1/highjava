package kr.or.ddit.basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest03 {
	public static void main(String[] args) {
		FileTest03 test = new FileTest03();
		
		File file = new File("c:/Users/pc-26/desktop");
		
		test.dir(file);
		
		
		
	}
	
	public void dir(File d) {
		if(!d.isDirectory()) {
			System.out.println("디렉토리만 가능합니다.");
			return;
		}
		System.out.println("["+d.getAbsolutePath()+"] 디렉토리 내용");
	
		//해당 디렉토리 안에 있는 모든 파일 및 디렉토리 목록을 구한다.
		File[] files = d.listFiles();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		//가져온 파일과 디렉토리 목록 개수만큼 반복처리
		for (File file : files) {
			String fileName = file.getName();
			String attr = ""; // 파일의 속성(읽기, 쓰기, 히든, 디렉토리 구분)
			String size=""; // 파일의 크기
			
			if(file.isDirectory()) {
				attr="<DIR>";
			}else {
				size=file.length()+"";
				attr=file.canRead() ? "R":"";
				attr+=file.canWrite() ? "W":"";
				attr+=file.isHidden() ? "H":"";
			}
			String strDate = df.format(new Date(file.lastModified()));
			System.out.printf("%s %5s %12s %s\n", strDate,attr,size,fileName);
		}
	
	}
}
