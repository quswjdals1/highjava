package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		// InetAddress 클래스 ==> IP주소를 다루기 위한 클래스
		
		
		InetAddress ip = InetAddress.getByName("www.naver.com");
		System.out.println("HostName: "+ip.getHostName());
		System.out.println("HostAddress: "+ip.getHostAddress());
		System.out.println("tostring: "+ip);
		System.out.println();
		
		//현재 컴퓨터의 ip정보 가져오기
		InetAddress localIp=InetAddress.getLocalHost();
		System.out.println("HostName: "+localIp.getHostName());
		System.out.println("HostAddress: "+localIp.getHostAddress());
		System.out.println();
		//ip주소가 여러개인 호스트의 정보 가져오기
		
		InetAddress[] ipArr=InetAddress.getAllByName("www.naver.com");
		System.out.println(Arrays.toString(ipArr));
		
	}

}
