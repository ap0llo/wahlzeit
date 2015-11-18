package org.wahlzeit.model;

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

        ensureCoordinateIsNotNull(other);
        return doGetDistance(other);
    }

    /**
     * Determines whether this instance of coordinate is equal to the specified coordinate.
     * Another Coordinate is considered equal if both instances are of the same type and describe the same point
     * @methodproperty composed
     * @methodtype boolean-query
     */
    @Override
    public boolean isEqual(Coordinate other) {

        if (this == other) {
            return true;
        }
        ensureCoordinateIsNotNull(other);

        return doIsEqual(other);
    }

    /**
     * @methodproperty composed
     * @methodtype boolean-query
     */
    @Override
    public boolean equals(Object other) {
        return other != null && other.getClass() == this.getClass() && isEqual((Coordinate) other);
    }

    //endregion

    // region Inheritance interface

    /**
     * @methodtype get
     * @methodproperty composed
     */
    // force reimplementation of hashCode() in subclasses
    public abstract int hashCode();

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
    protected void ensureCoordinateIsNotNull(Coordinate coordinate){
        if (coordinate == null) {
            throw new IllegalArgumentException("coordinate must not be null");
        }
    }


    /**
     * @methodtype assertion
     * @methodtype primitive
     */
    protected void assertClassInvariants() {

        // AbstractCoordinate does not have a state, so there are now invariants that need to be checked here
    }

    /**
     * Asserts that the specified double value is a number (!= NaN)
     * @param value The value to check
     * @param parameterName The name of the parameter to use for the exception being thrown
     * @methodtype assertion
     * @methodproperty primitive
     */
    protected void assertParameterIsNumber(double value, String parameterName){
        if(Double.isNaN(value)) {
            throw new IllegalArgumentException("Value of '" + parameterName + "' is not a number");
        }
    }

    //endregion

}
