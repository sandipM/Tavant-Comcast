package com.comcast.csv.interview.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.comcast.csv.meme.Meme;

/**
 * @author sandip.majumdar
 *
 */
public class LisUtility {
	
	private static Logger log = Logger.getLogger(LisUtility.class);
	
	
    public static void printList(List<Meme> memeList){    	
    	for (Iterator<Meme> iterator = memeList.iterator(); iterator.hasNext();) {
			Meme meme = (Meme) iterator.next();
			log.info("Name :: " + meme.getName());
			log.info("Year:: " + meme.getYear());
			log.info("Tags:: " + Arrays.toString(meme.getTags()));			
		}  
    }

}
