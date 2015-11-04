package org.wahlzeit.model;

public abstract class AbstractCoordinate extends Coordinate {

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

    @Override
    public boolean isEqual(Coordinate coordinate) {

        // just use equals() implementation for now
        return equals(coordinate);
    }



    // force reimplementation of hashCode() in subclasses
    public abstract int hashCode();

    // force reimplementation of equals() in subclasses
    public abstract boolean equals(Object other);



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

    protected abstract void ensureCanGetDistance(Coordinate coordinate);

    protected abstract double doGetDistance(Coordinate other);


}
