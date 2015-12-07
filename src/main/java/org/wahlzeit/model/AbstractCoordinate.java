package org.wahlzeit.model;

import org.wahlzeit.utils.MultiLevelHashMap;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public abstract class AbstractCoordinate extends Coordinate {


    //region Public Interface

    /**
     * Gets the distance between this Coordinate and another coordinate
     * @param other The coordinate to calculate the distance to
     * @return Retruns the distance as double value
     * @throws IllegalArgumentException Thrown if other is null or incompatible Coordinate implementation
     * @methodtype get
     * @methodproperty composed
     */
    @Override
    public double getDistance(Coordinate other) {

        //preconditions
        assertCoordinateIsNotNull(other);

        double result = doGetDistance(other);

        //postconditions
        assertIsValidDistance(result);
        // method does not change object state => no need to check class invariants


        return result;
    }

    /**
     * Determines whether this instance of coordinate is equal to the specified coordinate.
     * Another Coordinate is considered equal if both instances are of the same type and describe the same point
     * @methodproperty composed
     * @methodtype boolean-query
     */
    @Override
    public boolean isEqual(Coordinate other) {

        //preconditions
        assertCoordinateIsNotNull(other);


        //method implementation

        if (this == other) {
            return true;
        }
        return doIsEqual(other);

        //postconditions
        // method does not change object state => no need to check class invariants

    }

    /**
     * @methodproperty composed
     * @methodtype boolean-query
     */
    @Override
    public boolean equals(Object other) {
        return other != null && other.getClass() == this.getClass() && isEqual((Coordinate) other);
    }

    @Override
    public abstract double getX();

    @Override
    public Coordinate setX(double value){

        //preconditions
        assertIsValidXCoordinate(value);

        // method implementation
        //TODO: Sharing
        AbstractCoordinate result =  doSetX(value);

        //postconditions
        assert result.getX() == value;

        return result;
    }

    @Override
    public abstract double getY();

    @Override
    public Coordinate setY(double value){


        //preconditions
        assertIsValidYCoordinate(value);

        //TODO: Sharing
        AbstractCoordinate result = doSetY(value);

        //postconditions
        assert result.getY() == value;

        return result;
    }

    @Override
    public abstract double getZ();

    @Override
    public Coordinate setZ(double value){

        //preconditions
        assertIsValidZCoordinate(value);

        //method implementaton
        Coordinate result = doSetZ(value);

        //postconditions
        assert result.getZ() == value;

        //TODO: Sharing
        return doSetZ(value);
    }


    //endregion

    // region Inheritance interface

    /**
     * @methodtype get
     * @methodproperty composed
     */
    // force reimplementation of hashCode() in subclasses
    public abstract int hashCode();


    protected abstract AbstractCoordinate doSetX(double value);

    protected abstract AbstractCoordinate doSetY(double value);

    protected abstract AbstractCoordinate doSetZ(double value);


    //endregion

    // region Protected Methods

    /**
     * @methodproperty primitive
     */
    protected double doGetDistance(Coordinate other) {

        return sqrt(
                pow(getX() - other.getX(), 2) +
                        pow(getY() - other.getY(), 2) +
                        pow(getZ() - other.getZ(), 2)
        );

    }

    protected boolean doIsEqual(Coordinate other) {

        return getX() == other.getX() &&
                getY() == other.getY() &&
                getZ() == other.getZ();

    }

    /**
     *
     * @methodtype assertion
     * @methodproperty primitive
     */
    protected void assertCoordinateIsNotNull(Coordinate coordinate){
        assert coordinate != null: "Coordinate must not be null";
    }

    /**
     * @methodtype assertion
     * @methodtype primitive
     */
    protected void assertClassInvariants() {

        assert !Double.isNaN(this.getX());
        assert !Double.isNaN(this.getY());
        assert !Double.isNaN(this.getZ());
    }

    protected void assertIsValidDistance(double distance) {
        assert distance >= 0;
        assert !Double.isNaN(distance);
    }

    protected static void assertIsValidXCoordinate(double value) {
        assertIsValidCoordinate(value, "x");
    }

    protected static void assertIsValidYCoordinate(double value) {
        assertIsValidCoordinate(value, "y");
    }

    protected static void assertIsValidZCoordinate(double value) {
        assertIsValidCoordinate(value, "z");
    }

    protected static void assertIsValidCoordinate(double value, String name) {
        assert !Double.isNaN(value) : name + " coordinate must be a number";
    }


    //endregion

}
