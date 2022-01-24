package com.rahul.log;

import java.util.Date;

public class Logger {

	static Date startedOn = new Date();
	
	public static void log(String msg) {
		long millis = new Date().getTime() - startedOn.getTime();
		
		msg = String.format("[%1s] %2dms %3$s", new Date(), millis, msg);
		System.err.println(msg);
		startedOn = new Date();
	}
	
}
