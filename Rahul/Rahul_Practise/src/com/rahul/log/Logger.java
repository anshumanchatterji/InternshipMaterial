package com.rahul.log;

import java.util.Date;

public class Logger {

	static Date rootStartedOn = new Date();
	static Date startedOn = new Date();

	public static void log(String msg) {
		long millis = new Date().getTime() - startedOn.getTime();
		long totalElapsed = new Date().getTime() - rootStartedOn.getTime();

		msg = String.format("[%1s] [%4dms] {%5dms} %4$s", new Date(), millis, totalElapsed, msg);
		System.err.println(msg);
		startedOn = new Date();
	}

}
