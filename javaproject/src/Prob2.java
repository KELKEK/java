import javax.crypto.IllegalBlockSizeException;

public class Prob2 {

	public static void main(String[] args) throws IllegalBlockSizeException {
		System.out.println(leftPad("Samsung", 10, '#'));
		System.out.println(leftPad("SDS", 5, '*'));
		System.out.println(leftPad("Multicampus", 5, '@'));

	}

	public static String leftPad(String str, int size, char fillChar) throws IllegalBlockSizeException {
		// 구현하시오.....return값 수정할것

		int k = str.length();
		if (str.length() - size > 0) {
			throw new IllegalBlockSizeException("문자열의 길이보다 size가 큽니다.");
		}else {
			for (int i = k; i < size; i++) {
				str = new StringBuilder(str).insert(0, fillChar).toString();
			}

		}
		return str;
	}

}

//구현하시오.
class IllegalSizeException {
	String message;

	public IllegalSizeException(String message) {
		this.message = message;
		System.out.println(message);
	}
	
}
