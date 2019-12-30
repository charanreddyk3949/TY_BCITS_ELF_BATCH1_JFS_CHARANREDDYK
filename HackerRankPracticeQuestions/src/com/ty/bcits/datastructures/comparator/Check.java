package com.ty.bcits.datastructures.comparator;

import java.util.Comparator;

public class Check implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		
		return o1.score-o2.score;
	}
	

}