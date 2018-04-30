/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

/**
 *
 * @author user
 */
public class AbstractShape{
    
    protected int x, y;
    public enum activeShape{CIRCLE,ELLIPSE,SQUARE,RECTANGLE,ROUNDRECT};
    
    public AbstractShape(int x, int y)
    {
	this.x = x;
	this.y = y;
    }    
}
