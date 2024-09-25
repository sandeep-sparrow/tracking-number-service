package com.engineeringwithsandeep.learning.youtube.patterns.factory;

import java.util.stream.Stream;

enum CoordinateSystem
{
    CARTESIAN,
    POLAR
}

public class Point {

    private double x, y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static class PointFactory {

        /** newCartesianPoint - factory Method
         * @param x double
         * @param y double
         */
        public static Point newCartesianPoint(double x,  double y) {
            return new Point(x, y);
        }

        /** newPolarPoint - factory Method
         * @param rho double
         * @param theta double
         */
        public static Point newPolarPoint(double rho,  double theta) {
            return new Point(rho*Math.cos(theta), rho*Math.sin(theta));
        }
    }

}

class Demo {
    public static void main(String[] args) {
        Point point = Point.PointFactory.newCartesianPoint(1.0, 2.0);
        System.out.println(point);
        point = Point.PointFactory.newPolarPoint(1.0, 2.0);
        System.out.println(point);

        String[] names = {"A", "B", "C"};
        Stream.of(names).forEach(System.out::println);
    }
}
