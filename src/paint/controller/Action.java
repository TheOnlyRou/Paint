/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import java.util.Map;

/**
 *
 * @author user
 */
public class Action {
    public enum tool{MOVE, BRUSH, SQUARE, CIRCLE, RECTANGLE, ELLIPSE, ROUNDRECT, ERASER, FILL};
    public enum change{POSITION,PROPS};
    public String tool;
    public String change;
    public Map<String, Double> prop;
}
