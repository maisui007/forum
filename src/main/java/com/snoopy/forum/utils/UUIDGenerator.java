package com.snoopy.forum.utils;

import java.util.UUID;

public class UUIDGenerator {
	public static String generator32() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		
		return uuid;
	}

	public static String generator36() {
		String uuid = UUID.randomUUID().toString();
		
		return uuid;
	}
}
