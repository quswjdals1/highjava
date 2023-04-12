package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpMultiChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		try {
			
			
			while(true) {
				Socket socket = new Socket("localhost",7777);
				System.out.println("서버에 연결되었습니다...");
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				OutputStream os = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				System.out.print("대화명 입력: ");
				String name = sc.nextLine();
				dos.writeUTF(name);
				String msg =dis.readUTF();
				if (msg.equals("대화명중복")) {
					System.out.println("대화명 중복");
					dis.close();
					dos.close();
					socket.close();
					continue;
				}
				else if("OK".equals(msg)) {
					System.out.println("ok");
					Sender2 sender2 = new Sender2(socket,name);
					sender2.start();
					Receiver2 receiver2 = new Receiver2(socket);
					receiver2.start();
					System.out.println("대화를 시작하세요.");
				break;
			}
				
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
