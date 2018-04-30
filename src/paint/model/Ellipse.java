/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class Ellipse extends AbstractShape implements Shape{
    protected Point p;
    protected Map<String, Double> prop;
    protected Color c;
    protected Color fc;

    public Ellipse() {
        super(0,0);
        prop = new HashMap<>();
        prop.put("radius1", 0.0);
        prop.put("radius2", 0.0);
    }

    @Override
    public void setPosition(Point position) {
        p = position;
    }

    @Override
    public Point getPosition() {
        return p;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        prop = properties;
    }

    @Override
    public Map<String, Double> getProperties() {
        return prop;
    }

    @Override
    public void setColor(Color color) {
        c = color;
    }

    @Override
    public Color getColor() {
        return c;
    }

    @Override
    public void setFillColor(Color color) {
        fc = color;
    }

    @Override
    public Color getFillColor() {
        return fc;
    }

    @Override
    public void draw(Object canvas) {
        ((Graphics2D) canvas).setColor(getFillColor());
        ((Graphics2D) canvas).fillOval((int) p.getX(),(int) p.getY(),(int) prop.get("radius1").intValue(),(int) prop.get("radius2").intValue());


        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        ((Graphics2D) canvas).drawOval((int) p.getX(),(int) p.getY(),(int) prop.get("radius1").intValue(), (int) prop.get("radius2").intValue());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Shape r = new Circle();
        r.setColor(c);
        r.setFillColor(fc);
        r.setPosition(p);
        Map newprop = new HashMap<>();
        for (Map.Entry s: prop.entrySet())
            newprop.put(s.getKey(), s.getValue());
        r.setProperties(newprop);
        return r;
    }

}
