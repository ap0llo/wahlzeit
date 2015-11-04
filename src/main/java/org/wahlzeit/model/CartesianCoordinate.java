package org.wahlzeit.model;

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



    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CartesianCoordinate that = (CartesianCoordinate) o;

        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0 && Double.compare(that.z, z) == 0;
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
    protected double doGetDistance(Coordinate other) {
        return 0;
    }

}
