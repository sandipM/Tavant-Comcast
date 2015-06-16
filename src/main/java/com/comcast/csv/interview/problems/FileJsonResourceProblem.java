package com.comcast.csv.interview.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.apache.log4j.Logger;

import com.comcast.csv.interview.util.LisUtility;
import com.comcast.csv.meme.Meme;
import com.comcast.csv.meme.YoureDoingItWrongException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Read a list of {@link Meme}s from a JSON source file that might be on the classpath or file system.
 */
public class FileJsonResourceProblem {
	static Logger log = Logger.getLogger(FileJsonResourceProblem.class);
	private Gson gson = new Gson();
    /**
     * Read a list of memes from a JSON file stored on the filesystem
     * 
     * @param file the file to read
     * @return the list of memes read
     */
    public List<Meme> readFromFile(File file) throws YoureDoingItWrongException {
    	List<Meme> memeList = null;
    	  	
		try {
			BufferedReader jsonData = new BufferedReader(new FileReader(file));
			memeList = gson.fromJson(jsonData, new TypeToken<List<Meme>>(){}.getType());				
			
			log.info("Meme List Size :: " + ((null != memeList) ? memeList.size() : 0));
			if(null != memeList) LisUtility.printList(memeList);
			
		} catch (FileNotFoundException e) {
			log.error("readFromFile() :: " + e.getMessage());
		}    	
    	
    	return memeList;

    }

    /**
     * Read a list of memes from a JSON file stored on the classpath
     * 
     * @param path the path to the resource
     * @return the list of memes read
     */
    public List<Meme> readFromClasspath(String path) throws YoureDoingItWrongException {    	
    	
    		List<Meme> memeList = null;
	  	
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
	    	Reader reader = new InputStreamReader(inputStream);
			
			memeList = gson.fromJson(reader, new TypeToken<List<Meme>>(){}.getType());		
			
			
			log.info("Meme List Size :: " + ((null != memeList) ? memeList.size() : 0));
			if(null != memeList) LisUtility.printList(memeList);
			
    	return memeList;
    }   

}
