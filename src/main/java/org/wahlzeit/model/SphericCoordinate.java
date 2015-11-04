package org.wahlzeit.model;

import java.io.Serializable;
import static java.lang.Math.*;

public class SphericCoordinate implements Serializable {


    // The radius of earth in kilometers for calculating the distance between two points
    private final double EARTH_RADIUS = 6371d;

    private final double latitude;
    private final double longitude;


    /**
     * Instantiates a new instance of SphericCoordinate
     * @param latitude The latitude value.
     * @param longitude The longitude value.
     * @throws IllegalArgumentException Thrown if either longitude or latitude are not in the range [-360, 360]
     */
    public SphericCoordinate(double latitude, double longitude) {

        if(latitude > 90d || latitude < -90d) {
            throw new IllegalArgumentException("Latitude must be in range [-90, 90]");
        }

        if(longitude > 180d || longitude < -180d) {
            throw new IllegalArgumentException("Longitude must be in range [-180, 180]");
        }

        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Gets the distance between this Coordiante and another coordinate
     * @param other The coordinate to calculate the distance to
     * @return Returns a tuple of latitudinal and longitudinal distance
     * @throws IllegalArgumentException Thrown if other is null
     * @methodtype get
     * @methodproperty composed
     */
    public double getDistance(SphericCoordinate other) {

        ensureCoordinateIsNotNull(other);

        return EARTH_RADIUS *
                acos(
                        (sin(toRadians(this.getLatitude())) * sin(toRadians(other.getLatitude()))) +
                        (cos(toRadians(this.getLatitude())) * cos(toRadians(other.getLatitude())) * cos(toRadians(other.getLongitude() - this.getLongitude())))
                ) ;
    }

    /**
     * Calculates the latitudinal distance
     * @param other The coordinate to calculate the distance to
     * @return Returns the difference between the two Coordinates' latitude componets
     * @throws IllegalArgumentException Thrown if other is null
     * @methodtype get
     * @methodproperty composed
     */
    public double getLatitudinalDistance(SphericCoordinate other) {

        ensureCoordinateIsNotNull(other);
        return abs(this.latitude - other.getLatitude());
    }

    /**
     * Calculates the longitudinal distance
     * @param other The coordinate to calculate the distance to
     * @return Returns the difference between the two Coordinates' longitude componets
     * @throws IllegalArgumentException Thrown if other is null
     * @methodtype get
     * @methodproperty composed
     */
    public double getLongitudinalDistance(SphericCoordinate other) {

        ensureCoordinateIsNotNull(other);
        return abs(this.getLongitude() - other.getLongitude());
    }

    /**
     * @methodtype get
     * @methodproperty composed
     */
    @Override
    public int hashCode() {

        return Double.valueOf(this.latitude).hashCode() |
                Double.valueOf(this.longitude).hashCode();
    }

    /**
     * @methodtype boolean-query
     * @methodproperty composed
     */
    @Override
    public boolean equals(Object other) {

        if (other instanceof SphericCoordinate) {
            return equals((SphericCoordinate) other);
        } else {
            return false;
        }
    }

    /**
     * @methodtype boolean-query
     * @methodproperty primitive
     */
    public boolean equals(SphericCoordinate other) {

        if (other == null) {
            return false;
        } else {
            return this == other || (this.getLatitude() == other.getLatitude() && this.getLongitude() == other.getLongitude());
        }
    }

    /**
     *
     * @methodtype assertion
     * @methodproperty primitive
     */
    private void ensureCoordinateIsNotNull(SphericCoordinate coordinate){
        if (coordinate == null) {
            throw new IllegalArgumentException("coordinate must not be null");
        }
    }
}
