package com.bcits.exceptionhandling.checkedexceptionstrycatch;

public class TestS {
	public static void main(String[] args) {
		System.out.println("main started");
		Student s=new Student();
		try {
		Class.forName("Student");
		s.clone();
		System.out.println("object is cloned");
		}catch(CloneNotSupportedException |ClassNotFoundException e){
			System.out.println(e.getMessage());
	}
	 System.out.println("main is ended");
	}

}
