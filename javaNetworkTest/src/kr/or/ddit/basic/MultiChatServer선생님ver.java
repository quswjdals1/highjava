package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MultiChatServer선생님ver {
	static Map<String,Socket> clientMap; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiChatServer선생님ver().serverStart();
	}
	public MultiChatServer선생님ver(){
		clientMap= Collections.synchronizedMap(new HashMap<>());
	}
	public void serverStart() {
		ServerSocket server =null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다...");
			
			while(true) {
				socket = server.accept();
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]에서 접속했습니다.");
				System.out.println();
				
				ServerReceiver serverReceiver = new ServerReceiver(socket);
				serverReceiver.start();
			}
		} catch (IOException e) {
			
		}finally {
			if(server!=null)
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	private void sendToAll(String msg) {
		//clientMap의 데이터 개수만큼 반복처리
		for(String name : clientMap.keySet()) {
			
			try {
				DataOutputStream dout = new DataOutputStream(clientMap.get(name).getOutputStream());
				dout.writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//서버에서 클라이언트로 메시지를 전송하는 thread를 inner class형식으로 구현
	class ServerReceiver extends Thread{
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		//생성자
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				dis = new DataInputStream(this.socket.getInputStream());
				dos = new DataOutputStream(this.socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			String name="";
			
			//클라이언트와 연결이 되면 먼저 대화명을 입력받는다.
			//서버에서는 이 대화명을 받아서 중복여부를 검사하여 그 결과를 보낸다.
			try {
				while(true) { // 대화명이 중복되지 않을때 까지 반복한다.
					name=dis.readUTF();//대화명 수신
					
					//중복검사
					if(clientMap.containsKey(name)) {
						dos.writeUTF("대화명중복");
					}else {
						dos.writeUTF("OK");
						break;
					}
				}
				
				//이미 접속한 다른 모든 접속자들에게 지금 접속한 사람의 대화명을 이용하여
				//대화방 참여 메시지를 전송한다.
				sendToAll("["+name+"]님이 대화방에 입장했습니다.");
				
				//대화명과 현재 접속한 클라이언트의 Socket객체를 맵에 추가한다.
				clientMap.put(name, socket);
				
				System.out.println("현재 접속자 수: "+clientMap.size()+"명");
				
				//현재 클라이언트가 보낸 메시지를 받아서 전체 클라이언트에게 보낸다.
				while(dis!=null) {
					sendToAll(dis.readUTF());
				}
				
			} catch (IOException e) {
				
			}finally {
				//이 finally 영역이 실행된다는 것은 클라이언트가 접속을 종료했다는 의미
				sendToAll("["+name+"]님이 접속을 종료했습니다.");
			
				//사용자 목록(map)에서도 제거해줘야 함
				clientMap.remove(name);
				
				//서버출력
				System.out.println("["+name+"]님이 접속을 종료했습니다.");
				System.out.println("현재 접속자 수: "+clientMap.size()+"명");
			}
		}
	}
	
}
