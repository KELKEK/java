package com.shinhan.week3.day4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) throws IOException {
		System.out.println("-------------");
		System.out.println("서버를 종료하려면 q또는 Q를 입력하고 Enter키를 입력");
		System.out.println("--------------");

		// TCP서버 시작
		startServer();

		// 키보드 입력
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String key = scanner.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}
		}
		scanner.close();

		// TCP 서버 종료
		stopServer();

	}

	private static void stopServer() {
		// ServerSocket을 닫고 Port언바인딩
		try {
			serverSocket.close();
			System.out.println("[서버] 종료됨");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	private static void startServer() {
		// 작업스레드 정의
		Thread thread = new Thread() {
			public void run() {
				try {
					// ServerSocket 생성 및 Port 바인딩
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버]시작됨");

					while (true) {
						System.out.println("\n[서버] 연결 요청을 기다립니다.\n");
						// 연결수락
						Socket socket = serverSocket.accept();

						// 연결된 클라이언트 정보 얻기
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[서버]" + isa.getHostName() + "의 연결요청을 수락함");

						//데이터 받기
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String message = dis.readUTF();
						
						//데이터 보내기
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(message);
						dos.flush();
						System.out.println("받은 메시지 : " + message);
						
						// 연결끊기
						socket.close();
						System.out.println("[서버] " + isa.getHostName() + "의 연결요청을 끊음");
					}
				} catch (IOException e) {
					System.out.println("[서버]" + e.getMessage());
				}
			}
		};
		// 스레드 시작
		thread.start();
	}

}
