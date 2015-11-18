package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

    private double x;
    private double y;
    private double z;


    public CartesianCoordinate(double x, double y, double z) {

        // preconditions
        assertParameterIsNumber(x, "x");
        assertParameterIsNumber(y, "y");
        assertParameterIsNumber(z, "z");

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

    /**
     * @methodtype set
     * @methodproperty composed
     */
    public void setX(double value) {

        //preconditions
        assertParameterIsNumber(value, "value");

        // method implementation
        this.x = value;

        //postconditions
        assert this.x == value;
        assertClassInvariants();
    }

    /***
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * @methodtype set
     * @methodproperty composed
     */
    public void setY(double value) {

        //preconditions
        assertParameterIsNumber(value, "value");

        // method implementation
        this.y = value;

        //postconditions
        assert this.y == value;
        assertClassInvariants();
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
     * @methodtype set
     * @methodproperty primitive
     */
    public void setZ(double value) {

        //preconditions
        assertParameterIsNumber(value, "value");

        //method implementaton
        this.z = value;

        //postconditions
        assert this.z == value;
        assertClassInvariants();
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
     * @methodtype assertion
     * @methodproperty primitive
     */
    @Override
    protected void assertClassInvariants(){

        super.assertClassInvariants();

        assert !Double.isNaN(this.x);
        assert !Double.isNaN(this.y);
        assert !Double.isNaN(this.z);
    }



}
