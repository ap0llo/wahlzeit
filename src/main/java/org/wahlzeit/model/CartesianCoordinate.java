package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

    private final double x;
    private final double y;
    private final double z;


    public CartesianCoordinate(double x, double y, double z) {

        // preconditions
        assertIsValidXCoordinate(x);
        assertIsValidYCoordinate(y);
        assertIsValidZCoordinate(z);

        this.x = x;
        this.y = y;
        this.z = z;

        // postconditions
        assert this.x == x;
        assert this.y == y;
        assert this.z == z;
        assertClassInvariants();
    }


    /***
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
    public double getX() {
        return x;
    }

    /***
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
    public double getY() {
        return y;
    }

    /***
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
    public double getZ() {
        return z;
    }

    /***
     * @methodtype get
     * @methodproperty primitive
     */
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



    /**
     * @methodtype set
     * @methodproperty primitive
     */
    protected AbstractCoordinate doSetY(double value) {

        return new CartesianCoordinate(this.getX(), value, this.getZ());
    }

    /**
     * @methodtype set
     * @methodproperty primitive
     */
    @Override
    protected AbstractCoordinate doSetX(double value) {

        return new CartesianCoordinate(value, this.getY(), this.getZ());
    }

    /***
     * @methodtype set
     * @methodproperty primitive
     */
    protected AbstractCoordinate doSetZ(double value) {

        return new CartesianCoordinate(this.getX(), this.getY(), value);
    }

}
