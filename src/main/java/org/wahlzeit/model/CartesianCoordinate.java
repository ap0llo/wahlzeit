package org.wahlzeit.model;

import static java.lang.Math.*;

public class CartesianCoordinate extends AbstractCoordinate {

    private final double x;
    private final double y;
    private final double z;


    public CartesianCoordinate(double x, double y, double z) {

        if(Double.isNaN(x)) {
            throw new IllegalArgumentException("Value of x is not a number");
        }

        if(Double.isNaN(y)) {
            throw new IllegalArgumentException("Value of y is not a number");
        }

        if(Double.isNaN(z)) {
            throw new IllegalArgumentException("Value of z is not a number");
        }

        this.x = x;
        this.y = y;
        this.z = z;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;

        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }


    @Override
    protected void ensureCanGetDistance(Coordinate coordinate) {

    }

    @Override
    protected double doGetDistance(Coordinate c) {

        CartesianCoordinate other = (CartesianCoordinate) c;

        return sqrt(
                pow(getX() - other.getX(), 2) +
                pow(getY() - other.getY(), 2) +
                pow(getZ() - other.getZ(), 2)
        );

    }

    @Override
    protected boolean doIsEqual(Coordinate c) {
        CartesianCoordinate other = (CartesianCoordinate)c;
        return Double.compare(other.x, x) == 0 && Double.compare(other.y, y) == 0 && Double.compare(other.z, z) == 0;
    }

}
