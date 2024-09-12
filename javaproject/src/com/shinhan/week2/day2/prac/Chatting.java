package com.shinhan.week2.day2.prac;

class OtherClass{
	void method1() {
		Chatting.Chat aa = new Chatting().new Chat();
	}
}

public class Chatting {
	class Chat {
		//익명을 통해 재정의
		void start() {
		}

		void sendMessage(String message) {
		}
	}

	void method1() {
		Chat aa = new Chat();
	}
	void startChat(String chatId) {
		String nickName = null;
		//nickName = chatId; <-  이쪽을 빼줘야 함
		Chat chat = new Chat() {//익명구현 class, local inner class는 지역변수를 참조하는 경우 무조건 지역변수는 final이다.
			@Override
			public void start() {
				while (true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "] " + inputData;//이미 nickName을 null로 final했는데 값을 바꿔서 컴파일에러남
					sendMessage(message);
				}
			}
		};
		chat.start();
	}
}