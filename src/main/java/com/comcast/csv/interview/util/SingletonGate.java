package com.comcast.csv.interview.util;

import java.util.Properties;

/**
 * @author sandip.majumdar
 *
 */
public enum SingletonGate {
	INSTANCE;
	
	public Properties loadProperty(String relativeFileLocation){		
		PropertyUtil propertyUtil = new PropertyUtil();
		return propertyUtil.loadProperties(relativeFileLocation);		
	}
	
	

}
