package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpFileClient {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Socket socket=null;
		BufferedOutputStream bos=null;
		try {
			File file = new File("d:/d_other/컴퓨터1.jpg");
			
			if(!file.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				System.exit(0);
			}
			
			socket = new Socket("localhost",7777);
			System.out.println("서버에 연결되었습니다.");
			
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF(file.getName());
			
			FileInputStream fis = new FileInputStream(file);
			bos = new BufferedOutputStream(os);
			byte[] temp = new byte[1024];
			int len=0;
			
			while((len=fis.read(temp))!=-1) {
				bos.write(temp,0,len);
			}
			
			bos.flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bos!=null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket!=null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
