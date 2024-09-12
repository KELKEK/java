package com.shinhan.week3.day3;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Comparable<Student>, Serializable{
	private String name;
	private int score;
	private String sex;
	
	public Student (String name, int score) {
		this.name = name;
		this.score = score;
	}

	public Student(String name, int score, String sex) {
		this.name = name;
		this.score = score;
		this.sex = sex;
	}

	public String getName() { return name; }
	public int getScore() { return score; }


	@Override
	public int hashCode() {
		return Objects.hash(name, score, sex);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && score == other.score && Objects.equals(sex, other.sex);
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=").append(name).append(", score=").append(score).append(", sex=").append(sex)
				.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Student obj) {
		// TODO Auto-generated method stub
		// score asc, name desc
		if(score == obj.score) return obj.name.compareTo(name);//이름으로 desc
		return score - obj.score;//이것만 있으면 아무리 name이 달라도 score가 같으면 중복된것으로 인식해버림
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
	
}