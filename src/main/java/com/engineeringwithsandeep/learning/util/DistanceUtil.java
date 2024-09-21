package com.engineeringwithsandeep.learning.util;

import com.engineeringwithsandeep.learning.dto.BoundingBox;
import com.engineeringwithsandeep.learning.dto.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class DistanceUtil {

    public static void main(String[] args) {

        List<Coordinate> coordinatesList = new ArrayList<>();
        coordinatesList.add(new Coordinate(4.3463309059397, 51.124661597518));
        coordinatesList.add(new Coordinate(4.3462997096368, 51.124659437809));
        coordinatesList.add(new Coordinate(4.3462678523936, 51.124658021456));
        coordinatesList.add(new Coordinate(4.3462352940615, 51.124657870091));
        coordinatesList.add(new Coordinate(4.3462035253772, 51.124658976092));
        coordinatesList.add(new Coordinate(4.3461732697668, 51.12466176407));
        coordinatesList.add(new Coordinate(4.3461463717161, 51.124667911395));
        coordinatesList.add(new Coordinate(4.3461244331345, 51.124675421869));
        coordinatesList.add(new Coordinate(4.3461087503263, 51.124684334122));
        coordinatesList.add(new Coordinate(4.3460957805778, 51.124692792182));

        System.out.println(findBoundingBox(coordinatesList));
    }

    public static BoundingBox findBoundingBox(List<Coordinate> coordinatesList) {

        double minLongitude = Double.MAX_VALUE;
        double minLatitude = Double.MAX_VALUE;
        double maxLongitude = Double.MIN_VALUE;
        double maxLatitude = Double.MIN_VALUE;

        for (Coordinate coordinates : coordinatesList) {
            double longitude = coordinates.getLon();
            double latitude = coordinates.getLat();

            if (longitude < minLongitude) {
                minLongitude = longitude;
            }
            if (latitude < minLatitude) {
                minLatitude = latitude;
            }
            if (longitude > maxLongitude) {
                maxLongitude = longitude;
            }
            if (latitude > maxLatitude) {
                maxLatitude = latitude;
            }
        }
        return new BoundingBox(
                new Coordinate(minLongitude, minLatitude),
                new Coordinate(maxLongitude, maxLatitude)
        );
    }
}
