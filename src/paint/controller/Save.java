/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import paint.view.Application;

/**
 *
 * @author user
 */
public class Save {
   XMLEncoder e;

    public Save() throws FileNotFoundException {
        this.e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Test.xml")));
        e.writeObject(Application.shapes);
        e.close();
    }
       
}
