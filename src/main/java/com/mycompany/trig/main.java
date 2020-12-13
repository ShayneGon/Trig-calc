package com.mycompany.trig;
import java.util.*;
public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] sides = new double[2];
        String[] sTypes = new String[2];
        double x = 0;
        String measurement = "";
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter size of side " + (i + 1) + " - if side " + (i + 1) + " is to be found enter 0: ");
            sides[i] = input.nextDouble();
            System.out.println("Enter type (hypotenuse or h, opposite or o, adjacent or a): ");
            sTypes[i] = input.next();
        }
        System.out.println("Enter size of angle - if looking for angle then enter 0: ");
        double angle = input.nextFloat();

        if (angle == 0) {
            // looking for angle
            if (sTypes[1].equalsIgnoreCase("h") || sTypes[1].equalsIgnoreCase("hypotenuse") || sTypes[0].equalsIgnoreCase("h") || sTypes[0].equalsIgnoreCase("hypotenuse")) {
                if (sTypes[1].equalsIgnoreCase("o") || sTypes[1].equalsIgnoreCase("opposite") || sTypes[0].equalsIgnoreCase("o") || sTypes[0].equalsIgnoreCase("opposite")) {
                    if (sTypes[0].equalsIgnoreCase("h") || sTypes[0].equalsIgnoreCase("hypotenuse")) {
                        x = Math.asin(sides[1] / sides[0]);        // SIN inverse
                    } else
                        x = Math.asin(sides[0] / sides[1]);
                }
                else  // if no opposite must have adjacent
                    if (sTypes[0].equalsIgnoreCase("h") || sTypes[0].equalsIgnoreCase("hypotenuse")) {
                        x = Math.acos(sides[0] / sides[1]);          //COS inverse
                    } else
                        x = Math.acos(sides[1] / sides[0]);
            }
            else if (sTypes[1].equalsIgnoreCase("o") || sTypes[1].equalsIgnoreCase("opposite") || sTypes[0].equalsIgnoreCase("o") || sTypes[0].equalsIgnoreCase("opposite")) {
                if (sTypes[0].equalsIgnoreCase("o") || sTypes[0].equalsIgnoreCase("opposite")) {
                    x = Math.atan(sides[0] / sides[1]);         //TAN inverse
                } else
                    x = Math.atan(sides[1] / sides[0]);
            }
        }
        // looking for sides
        else
            if (sTypes[1].equalsIgnoreCase("h") || sTypes[1].equalsIgnoreCase("hypotenuse") || sTypes[0].equalsIgnoreCase("h") || sTypes[0].equalsIgnoreCase("hypotenuse")) {
                if (sTypes[1].equalsIgnoreCase("o") || sTypes[1].equalsIgnoreCase("opposite") || sTypes[0].equalsIgnoreCase("o") || sTypes[0].equalsIgnoreCase("opposite")) {
                    if (sTypes[0].equalsIgnoreCase("h") || sTypes[0].equalsIgnoreCase("hypotenuse")) {
                        if (sides[0] == 0) {
                            x = sides[1] / Math.sin(Math.toRadians(angle));      // SIN
                        } else
                            x = sides[0] * Math.sin(Math.toRadians(angle));
                    } else if (sides[1] == 0) {
                        x = sides[0] / Math.sin(Math.toRadians(angle));
                    } else
                        x = sides[1] * Math.sin(Math.toRadians(angle));

                }else
                    if (sTypes[0].equalsIgnoreCase("h") || sTypes[0].equalsIgnoreCase("hypotenuse")) {
                        if (sides[0] == 0) {
                            x = sides[1] / Math.cos(Math.toRadians(angle));      // COS
                        } else
                            x = sides[0] * Math.cos(Math.toRadians(angle));
                    } else if (sides[1] == 0) {
                        x = sides[0] / Math.cos(Math.toRadians(angle));
                    } else
                        x = sides[1] * Math.cos(Math.toRadians(angle));
            }
            else
                if (sTypes[0].equalsIgnoreCase("o") || sTypes[0].equalsIgnoreCase("opposite")) {
                    if (sides[0] == 0) {
                        x = sides[1] * Math.tan(Math.toRadians(angle));      // TAN
                    } else
                        x = sides[0] / Math.tan(Math.toRadians(angle));
                } else if (sides[1] == 0) {
                    x = sides[0] * Math.tan(Math.toRadians(angle));
                } else
                    x = sides[1] / Math.tan(Math.toRadians(angle));
        if (angle != 0) {
            System.out.println("Enter measurement of sides (cm,m,etc)");
            System.out.println("x = " + x + measurement);
        }else
            System.out.println("x = " + Math.toDegrees(x) + "\u00B0");
    }
}
