package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket server=null;
		Socket socket=null;
		InputStream is=null;
		FileOutputStream fos=null;
		try {
			File file = new File("d:/d_other/연습용");
			if(!file.exists()) {
				file.mkdirs();
			}
			
			server = new ServerSocket(7777);
			System.out.println("연결 기다리는중");
			socket = server.accept();
			System.out.println("연결 완료");
			
			is = socket.getInputStream();
			DataInputStream dos = new DataInputStream(is);
			String fname = dos.readUTF();
			System.out.println("파일명: "+fname);
			
			fos = new FileOutputStream(file+"/"+fname);
			byte temp[]= new byte[1024];
			int len=0;
			while((len=is.read(temp))!=-1) {
				fos.write(temp);
			}
			fos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				fos.close();
			}
			if(is!=null) {
				is.close();
			}
			if(socket!=null) {
				socket.close();
			}
			if(server!=null) {
				server.close();
			}
		}
		


		
	}

}
