package sts.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Tools {
	
	public static String getDataBaseProperty(String key) throws IOException{
		String value = "";
		Properties pt = new Properties();
		InputStream in=Tools.class.getClassLoader().getResourceAsStream("conf/database.properties");
		pt.load(in);
		value =pt.getProperty(key).trim();
		return value;
	}

	
	
	
	
	@SuppressWarnings("rawtypes")
	public static boolean objectIsNull(Object object) {
		boolean result = false;
		if (object == null) {
			result = true;
		}
		if (object instanceof List && ((List) object).isEmpty()) {
			result = true;
		}

		if (object instanceof String && ((String) object).trim() == "") {
			result = true;
		}
		if (object instanceof Map && ((Map) object).isEmpty()) {
			result = true;
		}
		return result;
	}
}
