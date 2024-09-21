package com.engineeringwithsandeep.learning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoundingBox {
    private Coordinate minCoordinate;

    private Coordinate maxCoordinate;

    @Override
    public String toString() {
        return "BoundingBox{" +
                "minCoordinate=" + minCoordinate +
                ", maxCoordinate=" + maxCoordinate +
                '}';
    }
}
