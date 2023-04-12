package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TcpMultiChatServer {
	
	static	Map<String,Socket> map = Collections.synchronizedMap(new HashMap<>());
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			ServerSocket server = new ServerSocket(7777);
			
			while(true) {
				System.out.println("map size: "+map.size());
				
				Socket socket = server.accept();
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				OutputStream os = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				String chatName = dis.readUTF();
				System.out.println(chatName);
				if(map.containsKey(chatName)) {
					System.out.println("대화명 중복");
					dos.writeUTF("대화명중복");
					dis.close();
					dos.close();
					socket.close();
					continue;
				}
				System.out.println("OK");
				dos.writeUTF("OK");
				map.put(chatName, socket);
				
				ReceiveAndSend receiveAndSend = new ReceiveAndSend(socket);
				receiveAndSend.start();
			}
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

