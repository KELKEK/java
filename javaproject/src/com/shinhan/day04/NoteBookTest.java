package com.shinhan.day04;

public class NoteBookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NoteBook note1 = new NoteBook("A", 100);
		NoteBook note2 = new NoteBook("B", 200);
		NoteBook note3 = new NoteBook("C", 300);
		
		System.out.println(note1.count);
		System.out.println(note2.count);
		System.out.println(note3.count);
		//ㄴ 오류는 아닌데 바람직한 사용법은 아님
		//어차피 다 같은 값의 결과가 나옴
		System.out.println(NoteBook.count);
		//ㄴ 클래스로 접근하는 것이 좋다.
	}

}
