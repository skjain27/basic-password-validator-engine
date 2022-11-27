package com.development.validator.password.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author skjain27
 *
 */
public class GenericPropertyReader {

	private static final Properties properties = new Properties();
	private static GenericPropertyReader genericPropertyReader;

	public static GenericPropertyReader getInstance() {
		if (genericPropertyReader == null)
			genericPropertyReader = new GenericPropertyReader();
		return genericPropertyReader;
	}

	private GenericPropertyReader() {

		try (InputStream s = getClass().getClassLoader().getResourceAsStream("application.properties")) {
			properties.load(s);
		} catch (Exception e) {

		}
	}

	public int getProperty(String key) {
		if (properties.contains(key))
			return Integer.parseInt((String) properties.get(key));
		return 0;
	}

}
