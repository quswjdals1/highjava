package kr.or.ddit.basic;

import java.io.InputStreamReader;

/*
	
	바이트 기반 스트림 - 문자열 문서가 아닌 이미지 파일이나 다른 파일들은 이것을 써야함
					 FileinputStream, FileoutputStream
	
	문자기반 스트림 - 문자열 파일을 입출력 하기 위해서는 이것을 써야함
				  영어(2byte)씩 읽기 때문
				  Filereader, Filewriter

				  영어를 읽기에는 문제가 없지만 한글은 3byte이므로 문자형식을 지정해
				  주어야 한다. 문자형식은 두번째 인자로 넣어준다. 
				  ms949 : ansi타입
				  utf-8 : utf-8
	 			  new InputStreamReader( filereader,"ms949");

*/
