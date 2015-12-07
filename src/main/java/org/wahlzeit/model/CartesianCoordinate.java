package org.wahlzeit.model;

import org.wahlzeit.utils.MultiLevelHashMap;

public class CartesianCoordinate extends AbstractCoordinate {

    private static MultiLevelHashMap<Double, Double, Double, CartesianCoordinate> instances = new MultiLevelHashMap<>();


    public synchronized static CartesianCoordinate newInstance(double x, double y, double z) {

        // preconditions
        assertIsValidXCoordinate(x);
        assertIsValidYCoordinate(y);
        assertIsValidZCoordinate(z);

        return getOrCreateInstance(x, y, z);
    }

    protected synchronized static CartesianCoordinate getOrCreateInstance(double x, double y, double z) {

        CartesianCoordinate instance = instances.get(x, y, z);

        if(instance == null) {
            instance = new CartesianCoordinate(x, y, z);
            instances.put(x, y, z, instance);
        }

        return instance;
    }



    private final double x;
    private final double y;
    private final double z;


    private CartesianCoordinate(double x, double y, double z) {

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
     * @methodproperty composite
     */
    @Override
    protected AbstractCoordinate doSetX(double value) {

        return  getOrCreateInstance(value, this.getY(), this.getZ());
    }

    /**
     * @methodtype set
     * @methodproperty composite
     */
    protected AbstractCoordinate doSetY(double value) {

        return getOrCreateInstance(this.getX(), value, this.getZ());
    }


    /***
     * @methodtype set
     * @methodproperty composite
     */
    protected AbstractCoordinate doSetZ(double value) {

        return getOrCreateInstance(this.getX(), this.getY(), value);
    }



}
