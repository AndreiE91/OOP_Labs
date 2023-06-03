package controllers;

import java.util.UUID;

public class GUID {

	public static String generateGUID() {
		//
		// Creating a random UUID (Universally unique identifier).
		//
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();
		return randomUUIDString;
	}

}
