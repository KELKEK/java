package com.shinhan.week2.day3;

public class ExceptionTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// f1();
		try {
			f2("admin", "1234");
		} catch (NotExistIDException | WrongPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//의도한대로 pw입력오류를 에러메시지를 건넴
	}

	private static void f2(String id, String pw) throws NotExistIDException, WrongPasswordException {
		// TODO Auto-generated method stub
		if (!id.equals("admin"))
			throw new NotExistIDException("ID입력오류");
		if (!pw.equals("admin"))
			throw new WrongPasswordException ("pw입력오류");
	}

	private static void f1() {
		// TODO Auto-generated method stub
		String[] strArray = { "10", "2a" };
		int value = 0;
		for (int i = 0; i <= 2; i++) {
			try {
				value = Integer.parseInt(strArray[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스를 초과했음");
			} catch (NumberFormatException e) {
				System.out.println("숫자로 변환할 수 없음");
			} finally {
				System.out.println(value);
			}
		}
	}

}

class NotExistIDException extends Exception {
	public NotExistIDException() {
	}

	public NotExistIDException(String message) {
		super(message);
	}
}

class WrongPasswordException extends Exception {
	public WrongPasswordException() {
	}

	public WrongPasswordException(String message) {
		super(message);
	}
}
