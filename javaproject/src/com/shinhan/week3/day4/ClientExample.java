package com.shinhan.week3.day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

	public static void main(String[] args) {
		try {
			//소켓생성과 동시에 localhost의 50001 port로 연결요청
			Socket socket = new Socket("192.168.0.76", 50001);
			
			System.out.println("[클라이언트] 연결 성공");
			//네트워크에서 들어온 문자를 보내기
			String message = "이종경";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(message);
			dos.flush();
			System.out.println("클라이언트가 메시지를 보냄");
			
			//네트워크에서 들어온 문자를 읽기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receivemessage = dis.readUTF();
			System.out.println("클라이언트가 메시지를 받음 : " + receivemessage);
			
			
			//socket닫기
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
		}catch(UnknownHostException e) {
			//IP표기방법이 잘모못되었을 경우
		}catch(IOException e) {
			//해당포트와 서버에 연결할 수 없는 경우
		}
	}

}
