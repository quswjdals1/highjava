package kr.or.ddit.basic.udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//송신용 , 수신용 패킷 객체변수 선언
		DatagramPacket inpacket, outpacket;
		
		//수신받은 데이터가 저장될 byte형 배열변수 선언
		byte[] bmsg = new byte[1024];
		
		try {
			DatagramSocket socket = new DatagramSocket();// socket 객체 생성
			
			//접속할 상대방의 주소정보 객체 생성
			InetAddress address = InetAddress.getByName("localhost");
			
			while(true) {
				
				//전송할 메시지 입력
				System.out.println("보낼 메시지 입력>>");
				String msg = sc.nextLine();
				
				//송신용 패킷 객체 생성
				outpacket = new DatagramPacket(msg.getBytes("utf-8"), msg.getBytes("utf-8").length,address,8888);
				socket.send(outpacket);
				
				if("/end".equals(msg)) {	//"/end"를 입력하면 종료
					break;
				}
				
				//------------------------------------------------
				//서버가 보내온 데이터 받아서 출력하기
				
				//수신용 패킷 생성
				inpacket = new DatagramPacket(bmsg, bmsg.length);
				
				//수신
				socket.receive(inpacket);
				
				String sendmsg= new String(bmsg,0,inpacket.getLength(),"utf-8");
				//String sendmsg= new String(inpacket.getData(),0,inpacket.getLength(),"utf-8");
				System.out.println("서버의 응답 메세지: "+sendmsg);
				
			}
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
