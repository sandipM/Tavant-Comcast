package com.comcast.csv.interview.util;

import java.util.Comparator;
import com.comcast.csv.meme.Meme;

/**
 * @author sandip.majumdar
 *
 */
public class YearComparator implements Comparator<Meme>{

	public int compare(Meme m1, Meme m2) {		
		
		if(m1.getYear() == m2.getYear())  
			return 0;  
		else if(m1.getYear() > m2.getYear())  
			return 1;  
		else  
			return -1;  
	}


}
