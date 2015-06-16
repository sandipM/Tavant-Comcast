package com.comcast.csv.interview.problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import com.comcast.csv.interview.util.LisUtility;
import com.comcast.csv.interview.util.YearComparator;
import com.comcast.csv.meme.Meme;

/**
 * Implement the specified interface.
 */
public class CollectionsProblemImpl implements CollectionsProblem {
	static Logger log = Logger.getLogger(CollectionsProblemImpl.class);

	public void sort(Collection<Meme> memes, boolean ascending) {
		
		List<Meme> memeList = new ArrayList<Meme>( memes );
		
		if(ascending){			
			Collections.sort( memeList, new YearComparator());	
			log.info("### Printing asending list");			
		}else{			
			Collections.sort(memeList ,Collections.reverseOrder(new YearComparator()));	
			log.info("### Printing descending list");
		}		
		LisUtility.printList(memeList);
		
	}

	public void addTag(Collection<Meme> memes, String tag) {
		//**[SM] Not sure about this requirement
		
	}

}
