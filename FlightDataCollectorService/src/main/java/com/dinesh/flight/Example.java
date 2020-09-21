package com.dinesh.flight;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm aa");
		
		String formattedTime = sdf2.format(date);
		System.out.println("formatted Time  ="+ formattedTime);
	}

}
