/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import paint.model.Shape;
import paint.view.Application;

/**
 *
 * @author user
 */
public class Load {
    
    public Load() throws FileNotFoundException{
        try (XMLDecoder d = new XMLDecoder(
                new BufferedInputStream(
                        new FileInputStream("Test.xml")))) {
            Application.shapes = ((ArrayList<Shape>)d.readObject());
            Application.canvas.paintComponent(Application.canvas.getGraphics());
        }
    }
}
