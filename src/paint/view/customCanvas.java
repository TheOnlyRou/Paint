/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class customCanvas extends Canvas {
    
    public customCanvas(){
        super();
        setBackground(new Color(83,83,83));
    }
    
    public void paint(Graphics g)
    {
        g.drawRect(100, 100, 50, 100);
    }
}
