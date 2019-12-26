package com.bcits.collections.priorityqueue;

import java.util.PriorityQueue;

public class PriorityQueue1 {
	public static void main(String[] args) {
		PriorityQueue<Integer> p1=new PriorityQueue<Integer>();
		p1.add(45);
		p1.add(2);
		p1.add(98);
		p1.add(62);
		p1.add(45);
		p1.add(0                                                                                                                                  );
		System.out.println(p1);//first it will give priority to least element first
		p1.remove();
		System.out.println(p1);
		p1.remove();
		System.out.println(p1);
		System.out.println(p1.contains(8));
		System.out.println(p1.size());
		System.out.println(p1.isEmpty());
	}

}
