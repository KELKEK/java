package code_save;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C10814 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Person[] parr = new Person[N];
		
		for(int i = 0; i < N; i++) {
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s, " ");
			parr[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		Arrays.sort(parr, (s1, s2) -> {return s1.age - s2.age;});
		
		for(int i = 0; i < N; i++) {
			System.out.println(parr[i].toString());
		}
	}

}

class Person{
	int age;
	String name;
	
	Person(int age, String name){
		this.age = age;
		this.name = name;
	}

	
	public String toString() {
		return age + " " + name;
	}
	
}