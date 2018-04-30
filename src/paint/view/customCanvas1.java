/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.border.Border;
import paint.model.*;



/**
 *
 * @author user
 */
public final class customCanvas1 extends JPanel{

    Point sPoint;
    Point ePoint;
    Border empty;
    protected Map<String, Double> prop;
    protected Boolean mousePressed;
    protected boolean mouseClicked;
    Graphics2D graph = (Graphics2D) this.getGraphics();
    public int rectcount=0,sqcount=0,circount=0,ellicount=0,rrcount=0;
    
    
    private customCanvas1()
    {
        init();
    }
    
    public void init(){
      setBackground(new Color(214,217,223));
      addMouseListener(new MouseAdapter()
       {
          @Override
          public void mousePressed(MouseEvent m)
          {
              sPoint=m.getPoint();
          }
          @Override
          public void mouseReleased(MouseEvent m)
          {
               ePoint = m.getPoint();
               repaint();
          }
        });

        addMouseMotionListener(new MouseMotionAdapter()
        {
           @Override
           public void mouseDragged(MouseEvent m)
              {
                 ePoint = m.getPoint();
              }
          });
}
    
    private static final customCanvas1 canvas = new customCanvas1();
    
    
    public void setColor(Color color)
    {
        this.getGraphics().setColor(color);
    }
    
    public static customCanvas1 getCanvas()
    {
        return canvas;
    }
       
    
    @Override
    public void paintComponent(Graphics g)
    { 
        super.paintComponent(g);
        if(sPoint!=null && Application.currentTool!=null && ePoint !=null)
        {
        switch (Application.currentTool) {
            case "SQUARE":
                prop = new HashMap<>();
                prop.put("Length", abs(sPoint.getX()-ePoint.getX()));
                Square s = new Square();
                s.setColor(Application.background);
                s.setFillColor(Application.foreground);
                s.setPosition(sPoint);
                s.setProperties(prop);
                Application.shapes.add(s);
                System.out.println("SQUARE" + prop.keySet() + prop.values() + sPoint.toString());
                sqcount++;
                Application.addListData("Square" + sqcount);
                break;
            case "ELLIPSE":
                prop = new HashMap<>();
                prop.put("radius1", abs((sPoint.getX()-ePoint.getX())));
                prop.put("radius2", abs((sPoint.getY()-ePoint.getY())));                
                Ellipse e = new Ellipse();
                e.setColor(Application.background);
                e.setFillColor(Application.foreground);
                e.setPosition(sPoint);
                e.setProperties(prop);
                Application.shapes.add(e);
                System.out.println("ELLIPSE" + prop.keySet() + prop.values() + sPoint.toString());
                ellicount++;
                Application.addListData("Ellipse"+ ellicount);
                break;
            case "RECTANGLE":
                prop = new HashMap<>();
                prop.put("Width", abs(sPoint.getX()-ePoint.getX()));
                prop.put("Length", abs(sPoint.getY()-ePoint.getY()));
                Rectangle r = new Rectangle();
                r.setColor(Application.background);
                r.setFillColor(Application.foreground);
                r.setPosition(sPoint);
                r.setProperties(prop);
                Application.shapes.add(r);
                System.out.println("RECTANGLE" + prop.keySet() + prop.values() + sPoint.toString());
                rectcount++;
                Application.addListData("Rectangle" + rectcount);
                break;
            case "ROUNDRECT":
                prop = new HashMap<>();
                prop.put("Width", abs(sPoint.getX()-ePoint.getX()));
                prop.put("Length", abs(sPoint.getY()-ePoint.getY()));
                prop.put("ArcWidth", 10.0);
                prop.put("ArcLength", 10.0);
                RoundRectangle rr = new RoundRectangle();
                rr.setColor(Application.background);
                rr.setFillColor(Application.foreground);
                rr.setPosition(sPoint);
                rr.setProperties(prop);
                Application.shapes.add(rr);
                System.out.println("ROUNDRECT" + prop.keySet() + prop.values() + sPoint.toString());
                rrcount++;
                Application.addListData("Round Rectangle" + rrcount);
                break;
            case "CIRCLE":
                prop = new HashMap<>();
                prop.put("radius", abs((sPoint.getX()-ePoint.getX())));               
                Circle c = new Circle();
                c.setColor(Application.background);
                c.setFillColor(Application.foreground);
                c.setPosition(sPoint);
                c.setProperties(prop);
                Application.shapes.add(c);
                System.out.println("CIRCLE" + prop.keySet() + prop.values() + sPoint.toString());
                circount++;
                Application.addListData("Circle" + circount);
                break;
            default:
                break;
        }
        if(!Application.shapes.isEmpty())
        {
            for(int i=0; i<Application.shapes.size(); i++)
            {

            if(Application.shapes.get(i) instanceof Square)
            {
               ((Square)Application.shapes.get(i)).draw(g);
               
            }
            else if(Application.shapes.get(i) instanceof Rectangle)
            {
                ((Rectangle)Application.shapes.get(i)).draw(g);
            }
            else if(Application.shapes.get(i) instanceof Circle)
            {
                ((Circle)Application.shapes.get(i)).draw(g);
                                int j=0;
                System.out.println(++j);
            }
            else if(Application.shapes.get(i) instanceof Ellipse)
            {
                ((Ellipse)Application.shapes.get(i)).draw(g);
            }
            else if(Application.shapes.get(i) instanceof RoundRectangle)
            {
                
                ((RoundRectangle)Application.shapes.get(i)).draw(g);
            }
        }
        }
        }
    }

}
