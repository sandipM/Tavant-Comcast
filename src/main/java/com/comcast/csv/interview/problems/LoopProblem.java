package com.comcast.csv.interview.problems;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.comcast.csv.meme.Meme;

/**
 * Using all forms of loops and recursions to iterate over a {@link List} of {@link Meme}s and log it's name and year.
 * Format of the log message isn't important.
 */
public class LoopProblem {
	
	static Logger log = Logger.getLogger(LoopProblem.class);
	
	
	public void loopAllTypes(List<Meme> memes){
		
		log.info("************** for each");
		for (Meme meme : memes) {			
			log.info("Name ::" + meme.getName() + " Year:: " + meme.getYear());
		}
		
		log.info("************** Using Iterator");
		for (Iterator<Meme> iterator = memes.iterator(); iterator.hasNext();) {
			Meme meme = (Meme) iterator.next();
			log.info("Name ::" + meme.getName() + " Year:: " + meme.getYear());			
		}
		
		log.info("************** Using Array");
		for (int i = 0; i < memes.size(); i++) {
			Meme meme = (Meme)memes.get(i);
			log.info("Name ::" + meme.getName() + " Year:: " + meme.getYear());						
		}
		
		log.info("************** Using While");
		int i = 0;
		while (i < memes.size()) {
			Meme meme = (Meme)memes.get(i);
			log.info("Name ::" + meme.getName() + " Year:: " + meme.getYear());		
			i++;
		}
		
		
		log.info("************** Using Recursive");
		recusrive(memes);
		
	}
	
	public static void recusrive(List<Meme> list) {
	    if( list.isEmpty() ) return;
	    Meme meme = list.get(0) ;
	    log.info("Name ::" + meme.getName() + " Year:: " + meme.getYear());	
	    recusrive(list.subList(1,list.size()));
	}

}
