
package com.comcast.csv.interview;

import java.awt.Rectangle;
import java.io.File;
import java.util.Properties;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

import com.comcast.csv.interview.problems.CollectionsProblemImpl;
import com.comcast.csv.interview.problems.FileJsonResourceProblem;
import com.comcast.csv.interview.problems.LoopProblem;
import com.comcast.csv.interview.problems.PojoAlgProblem;
import com.comcast.csv.interview.problems.StringParsingProblem;
import com.comcast.csv.interview.util.SingletonGate;
import com.comcast.csv.meme.YoureDoingItWrongException;

/**
 * @author sandip.majumdar
 *
 */
public class MainController {
	static Properties properties;
	private static Logger log = Logger.getLogger(MainController.class);
	
	
	
	static{
		properties = SingletonGate.INSTANCE.loadProperty("memetest.properties");	
	}


	public static void main(String[] args) {
		
		
		solveJsonResourceProblem();
		
		solveStringParsingProblem();
		
		solveLoopProblem();
		
		solveCollectionsProblemImpl();
		
		solvePojoAlgoProblem();
		
	}
	
	
	public static void solveJsonResourceProblem(){
		
		try {
			FileJsonResourceProblem jsonResourceProblem = new FileJsonResourceProblem();
			jsonResourceProblem.readFromFile(new File(properties.getProperty("json.file.path") + File.separator + properties.getProperty("json.file.name")));			
			jsonResourceProblem.readFromClasspath(properties.getProperty("json.file.name"));
		} catch (YoureDoingItWrongException e) {
			log.error(e.getMessage());
		}
		
	}
	
	public static void solvePojoAlgoProblem(){
		
		int xCordinate = 20;
		int yCordinate = 30;
		Rectangle inner = new Rectangle(100,50);
		Rectangle outer = new Rectangle(xCordinate, yCordinate, 200, 100); 
		
		PojoAlgProblem algProblem = new PojoAlgProblem();
		
		algProblem.bottomRight(inner, outer);
		JFrame window1 = new JFrame();
        window1.setSize(500,500);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window1.getContentPane().add(algProblem);
        window1.setVisible(true);		
        
        PojoAlgProblem algProblem2 = new PojoAlgProblem();
        algProblem2.middleCenter(inner, outer);
		JFrame window2 = new JFrame();
        window2.setSize(500,500);
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window2.getContentPane().add(algProblem2);
        window2.setVisible(true);	
        
	}
	
	public static void solveStringParsingProblem(){
		
		String address = "25w873 Apple St.";		
		StringParsingProblem stringParsingProblem = new StringParsingProblem();		
		log.info("Is Valid Adrees :: " +stringParsingProblem.isAddressValid(address));		
		log.info("Distance :: " +stringParsingProblem.getDistanceFromCityCenter(address));
		
	}
	
	
	public static void solveLoopProblem(){
			
			try {
				LoopProblem loopProblem = new LoopProblem();
				FileJsonResourceProblem jsonResourceProblem = new FileJsonResourceProblem();
				loopProblem.loopAllTypes(jsonResourceProblem.readFromClasspath(properties.getProperty("json.file.name")));
				
			} catch (YoureDoingItWrongException e) {
				log.error("solveJsonResourceProblem() :: " + e.getMessage());
			}
			
	}
	
	public static void solveCollectionsProblemImpl(){
		
		try {
			properties = SingletonGate.INSTANCE.loadProperty("memetest.properties");		
			CollectionsProblemImpl problemImpl = new CollectionsProblemImpl();
			FileJsonResourceProblem jsonResourceProblem = new FileJsonResourceProblem();
			problemImpl.sort(jsonResourceProblem.readFromClasspath(properties.getProperty("json.file.name")), false);
		} catch (YoureDoingItWrongException e) {
			log.error("solveJsonResourceProblem() :: " + e.getMessage());
		}		
		
	}
	

}
