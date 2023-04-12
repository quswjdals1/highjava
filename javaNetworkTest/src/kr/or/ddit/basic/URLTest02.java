package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLTest02 {


	public static void main(String[] args) throws IOException {
		// URLConnection ==> 애플리케이션과 URL간의 통신연결을 위한 클래스
		//				 ==> URL객체를 통해서 구할 수 있다.
		
		//특정 서버의 정보와 파일 내용을 가져와 출력하는 예제
		URL url = new URL("https://www.ddit.or.kr:/index.php");
		
		//URLConnection 객체 구하기
		URLConnection conn = url.openConnection();
		
		//Header정보 가져오기
		Map<String,List<String>> headerMap = conn.getHeaderFields();
		
		//header정보 출력해 보기
		for (String key : headerMap.keySet()) {
			System.out.println(key+" "+headerMap.get(key));
		}
		System.out.println("----------------------------------------");
		System.out.println();
		
		//해당 문서의 내용 가져오기(index.php 코드 소스)
		//방법 1. URLConnection 객체를 이용한 방법
		InputStream is = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		while(true) {
			String str = br.readLine();
			if(str==null) {
				break;
			}
			System.out.println(str);
		}
		
		
		//방법 2. URL객체의 openStream()메소드 이용
		InputStream openStream = url.openStream();
		isr = new InputStreamReader(openStream,"utf-8");
		br = new BufferedReader(isr);
		String s;
		while((s=br.readLine())!=null) {
			System.out.println(s);
		}
	}

}
