package org.wahlzeit.model;

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
        ensureCanGetDistance(other);

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
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        return doIsEqual(other);
    }

    /**
     * @methodproperty composed
     * @methodtype boolean-query
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof Coordinate && isEqual((Coordinate) other);
    }

    //endregion

    // region Inheritance interface

    /**
     * @methodtype get
     * @methodproperty composed
     */
    // force reimplementation of hashCode() in subclasses
    public abstract int hashCode();


    /**
     * @methodtype assertion
     * @methodproperty primitive
     */
    protected abstract void ensureCanGetDistance(Coordinate coordinate);

    /**
     * @methodproperty primitive
     */
    protected abstract double doGetDistance(Coordinate other);

    /**
     * @methodproperty primitive
     * @methodtype boolean-query
     */
    protected abstract boolean doIsEqual(Coordinate other);

    //endregion

    // region Protected Methods

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


    //endregion

}
