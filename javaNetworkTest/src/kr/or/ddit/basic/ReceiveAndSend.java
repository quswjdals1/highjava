package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

//이 쓰레드 클래스는 소켓을 통해서 메시지를 받아서 화면에 출력함
public class ReceiveAndSend extends Thread{
	private Socket socket;
	private DataInputStream din;
	
	//생성자
	public ReceiveAndSend(Socket socket) {
		this.socket=socket;
		try {
			din= new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(din!=null) {
			try {
				Map<String, Socket> map = TcpMultiChatServer.map;
				System.out.println(map.size());
				String msg = din.readUTF();
				System.out.println(msg);
				for (Map.Entry<String, Socket> entry : map.entrySet()) {
					String key = entry.getKey();
					Socket val = entry.getValue();
					if(val.equals(this.socket)) {
						continue;
					}
					DataOutputStream dos = new DataOutputStream(val.getOutputStream());
					dos.writeUTF(msg);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
