package com.company;

import java.util.Collections;

public class Rectangle extends Polygon {

    public Rectangle(double... sides) {

        super(sides);
        super.className = "Rectangle";
    }
    public boolean isSquare() {
        return sides.get(0).equals(sides.get(1)) && sides.get(1).equals(sides.get(2)) && sides.get(2).equals(sides.get(3));
    }

    @Override
    public double calculateArea() {
        Collections.sort(this.getSides());
        return this.sides.get(0)*this.sides.get(2);
    }
}
