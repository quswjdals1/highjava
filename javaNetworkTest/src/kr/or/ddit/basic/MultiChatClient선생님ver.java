package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MultiChatClient선생님ver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MultiChatClient선생님ver().clientStart();
	}

	private void clientStart() {
		// TODO Auto-generated method stub
		Socket socket = null;
		
		try {
			socket= new Socket("localhost",7777);
			System.out.println("서버에 연결되었습니다.");
			System.out.println();
			
			clientSender sender = new clientSender(socket);
			clientReceiver receiver = new clientReceiver(socket);
			sender.start();
			receiver.start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	class clientSender extends Thread{
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		private String name;
		private Scanner sc;
		
		public clientSender(Socket socket) {
			this.socket = socket;
			sc = new Scanner(System.in);
			
			try {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				if(dis!=null) {
					//클라이언트용 프로그램은 처음 실행되면 서버에 접속하고 
					//대화명을 입력받아 전송하고, 중복인지 아닌지를 응답받아야 한다.
					while(true) {
						System.out.print("대화명>>");
						String name = sc.nextLine();
						dos.writeUTF(name);
						String feedBack=dis.readUTF();
						if(feedBack.equals("대화명중복")) {
							System.out.println(name+"은 중복되는 대화명 입니다.");
							System.out.println("다른 대화명을 입력하세요.");
							System.out.println();
							
						}else {
							this.name=name;
							System.out.println("["+name+"] 대화명으로 입장했습니다.");
							System.out.println();
							break;
						}
						
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Override
		public void run() {
			
			try {
				while(dos!=null) {
					dos.writeUTF("["+this.name+"]"+sc.nextLine());
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	class clientReceiver extends Thread{
		private Socket socket;
		private DataInputStream dis;
		
		
		public clientReceiver(Socket socket) {
			this.socket = socket;
			try {
				this.dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(dis!=null) {
				try {
					System.out.println(dis.readUTF());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
