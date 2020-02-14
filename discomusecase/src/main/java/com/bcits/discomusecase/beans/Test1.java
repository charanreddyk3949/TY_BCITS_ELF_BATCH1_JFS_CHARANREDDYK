package com.bcits.discomusecase.beans;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a String");
		String str=scanner.nextLine();
//		char[] ch=str.toCharArray();
//		
//		for (int i = 0; i < ch.length; i++) {
//			if (ch[i]>=65 && ch[i]<=97) {
//				ch[i]=' ';
//				System.out.println(ch[i]);
//			}else {
//				System.out.println(ch[i]);
//			}
//		}
  
		  for (int i = 0; i < str.length(); i++) {
			    
	            if(Character.isUpperCase(str.charAt(i))){    
	            	str.charAt(i);
	            }else {
					System.out.println(str.charAt(i));
				}
	            
	 }
		
		
		
	}//End of main()

}//End of Class
