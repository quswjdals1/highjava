package kr.or.ddit.basic;

import org.apache.log4j.Logger;

public class LoggingTest {
	// Logger 클래스의 인스턴스르 받아온다.
	static Logger logger = Logger.getLogger(LoggingTest.class);
	
	public static void main(String[] args) {
		// 로그 기록을 남기는 방법
		// 형식) Logger객체변수.로그레벨명("출력할 메세지")

		 logger.trace("이것은 Log4j의 Trace레벨의 메시지입니다.");
		 logger.debug("이것은 Log4j의 debug레벨의 메시지입니다.");
		 logger.info("이것은 Log4j의 info레벨의 메시지입니다.");
		 logger.warn("이것은 Log4j의 warn레벨의 메시지입니다.");
		 logger.error("이것은 Log4j의 error레벨의 메시지입니다.");
		 logger.fatal("이것은 Log4j의 fatal레벨의 메시지입니다.");
		
	}

}
