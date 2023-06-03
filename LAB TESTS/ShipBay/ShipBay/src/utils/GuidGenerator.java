package utils;

import java.util.UUID;

public class GuidGenerator {
	
	public static String generate(){
		UUID guid = UUID.randomUUID();
		String randomUUIDString = guid.toString();
		return randomUUIDString;
	}

}
