package com.comcast.csv.interview.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author sandip.majumdar
 *
 */
public class PropertyUtil {
	
	Properties properties = new Properties();

	/**
	 * @param relativeFilePath
	 * @return
	 */
	public Properties loadProperties(String relativeFileLocation) {

                try {
                    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(relativeFileLocation);
                    if (inputStream != null){
                    	properties.load(inputStream);
                    }  

		} catch (FileNotFoundException e) {
			e.printStackTrace();
	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;

	}

	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}	

}
