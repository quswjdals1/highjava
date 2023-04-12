package kr.or.ddit.basic.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpServer {

	/*
	
		UDP방식: 비연결 지향 , 신뢰성이 없다. 데이터가 순서대로 도착한다는 보장이 없다, 그러나 빠르다.
		
		datagramsocket객체와 datagrampacket객체를 이용해서 통신한다.
		1. DatagramSocket: 데이터의 송수신과 관련된 작업을 수행한다.(우체부)
		2. datagrampacket: 주고받는 데이터와 관련된 작업을 수행한다(소포)
			 			=>수신용 생성자와 송신용 생성자를 따로 제공한다.
			 			
			-tcp의 경우 스트림을 이용해서 송수신하지만
			-udp의 경우 데이터그램을 이용해서 송수신한다.
			
	
	*/
	
//클라이언트가 보낸 메시지를 받고, 받은 메시지를 그대로 클라이언트에게 보내는 예제
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			DatagramSocket socket = new DatagramSocket(8888);
			
			//수신용 패킷객체 변수와 송신용 패킷객체변수 선언
			DatagramPacket inpacket, outpacket;
			System.out.println("서버 실행중...");
			
			while(true) {
				//데이터가 저장될 byte형 배열 변수 선언
				byte[] bMsg = new byte[1024];
				
				//수신용 패킷객체 생성
				//==>데이터가 저장될 byte형 배열, 배열의 길이를 생성자의 인수로 지정하여 생성한다.
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				//데이터 수신하기 ==> receive()메소드
				//이 메서드는 데이터가 올때까지 기다린다.	
				//수신된 데이터의 패킷정보는 지정한 패킷객체에 저장된다.
				socket.receive(inpacket);
				
				InetAddress address = inpacket.getAddress();
				int port = inpacket.getPort();
				
				System.out.println();
				System.out.println("상대방 ip정보: "+address);
				System.out.println("상대방 port번호: "+port);
				System.out.println();
				
				//상대방이 보낸 메세지 출력하기
				//-상대방이 보낸 데이터는 수신용 패킷객체를 생성할 때 지정한 byte형 배열과
				//수신용 패킷객체의 getData()메서드를 통해서 구할 수 있다.
				//- 실제 읽어온 데이터의 길이는 수신용 패킷 객체의 getLength()메서드를 통해서 구할 수 있다.
				
				//수신된 데이터는 byte형 배열로 오기 때문에 이 데이터를 문자열로 변환해서 출력한다.
				String msg= new String(bMsg,0,inpacket.getLength(),"utf-8");
				//String msg= new String(inpacket.getData(),0,inpacket.getLength(),"utf-8");
				if("/end".equals(msg)) {//수신문자열이 "/end"인 경우 종료
					break;
				}
				
				System.out.println("상대방이 보낸 메시지: "+msg);
				System.out.println();
				
				
				
				//상대방에게 메시지 보내기(수신받은 메시지를 그대로 송신한다.)
				
				//송신할 데이터를 byte형 배열로 변환한다.
				byte[] sendMsg=msg.getBytes("utf-8");
				
				//송신용 패킷객체 생성
				// ==> 전송할 데이터가 저장된 byte형 배열, 전송할 데이터의 길이(배열길이),
				//		상대방의 주소정보(InetAddress객체), 포트번호 이 4가지를 생성자의 인자로 넣어준다.
				outpacket = new DatagramPacket(sendMsg, sendMsg.length,address,port);
				socket.send(outpacket);
				System.out.println("송신종료");
				
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
