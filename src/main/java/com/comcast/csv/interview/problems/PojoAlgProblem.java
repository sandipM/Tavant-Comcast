package com.comcast.csv.interview.problems;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

/**
 * Using absolute coordinates for EVERYTHING, implement the following methods to position the inner rectangle relative
 * to the outer rectangle.
 */
public class PojoAlgProblem extends JComponent{
	
	/**
	 * 
	 */
	private Rectangle innerAbsolute;
	private Rectangle outerAbsolute;

    /**
     * Put the inner rectangle so that it's bottom right corner aligns with the bottom right corner of the outer
     * rectangle.
     * 
     * @param inner the inner rectangle to position
     * @param outer the outer rectangle to use as a reference
     */
    public void bottomRight(Rectangle inner, Rectangle outer) {
    	
    	this.outerAbsolute = outer;
    	this.innerAbsolute = new Rectangle((outer.x + outer.width) - inner.width , (outer.y + outer.height) - inner.height, inner.width, inner.height);

    }

    /**
     * Put the inner rectangle so that it is centered vertically and horizontally 
     * 
     * @param inner the inner rectangle to position
     * @param outer the outer rectangle to use as a reference
     */
    public void middleCenter(Rectangle inner, Rectangle outer) {
    	this.outerAbsolute = outer;
    	this.innerAbsolute = new Rectangle(((outer.width) - inner.width)/2 +outer.x, ((outer.height) - inner.height)/2 +outer.y, inner.width, inner.height);

    }
    
    public void paint(Graphics graphics) {
    	
    	Graphics2D graphics2d = (Graphics2D)graphics;        
        graphics2d.draw(outerAbsolute);
        graphics2d.draw(innerAbsolute);
    }

}
