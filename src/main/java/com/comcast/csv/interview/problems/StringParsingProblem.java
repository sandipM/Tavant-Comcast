package com.comcast.csv.interview.problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The following methods operate on street addresses in a particular format. The format contains the following components:
 * 
 *  1. Number of miles from the center of the city
 *  2. Primary direction from the city as a single lower-case letter
 *  3. Street number
 *  4. Street name (always a single word)
 *  5. An abbreviation for either a Street or Avenue with a period
 * 
 * </h2>Example Valid Addresses</h2>
 * 25w873 Apple St.
 * 3n17 Special Ave.
 * 0e34800 Main St.
 */
public class StringParsingProblem {

    /**
     * Returns true if the address is valid, otherwise false.
     * 
     * @param address the address to validate
     * @return true if the address is valid
     */
    public boolean isAddressValid(String address) {    	
    	
    	String[] tempAddress = address.split("\\s+");    	
    	
    	if(tempAddress.length != 3) return false;   	
    
    	//**[SM] - Validates if the 3rd part is in the proper format of St. or Ave.
        if(!tempAddress[2].matches("^(St|Ave)\\.$")) return false;
        
      //**[SM] - Validates if the 2nd part contains only alpha characters.
    	if(!tempAddress[1].matches("[a-zA-Z]+")) return false;
    	//**[SM] - validates if the first part is only alphanumeric
    	if(!tempAddress[0].matches("[a-z0-9]+")) return false;
    		
    	//**[SM] - The below code will validate for the direction   

    	Pattern pattern = Pattern.compile("(n|e|w|s){1}");
        Matcher matcher = pattern.matcher(tempAddress[0]);
        int cnt = 0;
        while (matcher.find()) {
        	cnt++;
        	//**[SM] - Should contain only one lowercase character (n|e|w|s) , the character should not be at the beginning or end
        	if(cnt > 1 || matcher.start() == 0 || matcher.start() == tempAddress[0].length()-1) return false;        	            
        }     
        
        
        return true;
    }
    
    /**
     * Get the distance in miles from the center of the city from the given address.
     * 
     * @param address the address
     * @return the distance
     */
    public int getDistanceFromCityCenter(String address) {
    	//**[SM] - Address should be valid    	
    	String[] tempAddress = address.split("\\s+");    	   

    	Pattern pattern = Pattern.compile("(n|e|w|s){1}");
        Matcher matcher = pattern.matcher(tempAddress[0]);
        while (matcher.find()) {
        	return Integer.parseInt(tempAddress[0].substring(0, matcher.start()));  	            
        }             
        return 0;
    }    
    
}
