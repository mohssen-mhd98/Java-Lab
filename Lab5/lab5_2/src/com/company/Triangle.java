package com.company;

import static java.lang.Math.sqrt;

public class Triangle extends Polygon {

    public Triangle(double... sides) {
        super(sides);
        super.className="Triangle";
    }
    public boolean isEquilateral() {
        return sides.get(0).equals(sides.get(1)) && sides.get(1).equals(sides.get(2));
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter()/2;
        return (sqrt(p*(p - sides.get(0))*(p - sides.get(1))*(p - sides.get(2))));
    }
}
