package org.wahlzeit.model;

import java.io.Serializable;
import static java.lang.Math.*;

public class Coordinate implements Serializable {


    // The radius of earth in kilometers for calculating the distance between two points
    private final double EARTH_RADIUS = 6371d;

    private final double latitude;
    private final double longitude;


    /**
     * Instantiates a new instance of Coordinate
     * @param latitude The latitude value.
     * @param longitude The longitude value.
     * @throws IllegalArgumentException Thrown if either longitude or latitude are not in the range [-360, 360]
     */
    public Coordinate(double latitude, double longitude) {

        if(latitude > 90d || latitude < -90d) {
            throw new IllegalArgumentException("Latitude must be in range [-90, 90]");
        }

        if(longitude > 180d || longitude < -180d) {
            throw new IllegalArgumentException("Longitude must be in range [-180, 180]");
        }

        this.latitude = latitude;
        this.longitude = longitude;
    }


    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    /**
     * Gets the distance between this Coordiante and another coordinate
     * @param other The coordinate to calculate the distance to
     * @return Returns a tuple of latitudinal and longitudinal distance
     * @throws IllegalArgumentException Thrown if other is nulll
     */
    public double getDistance(Coordinate other) {

        if (other == null) {
            throw new IllegalArgumentException("'other' must not be null");
        }

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
     */
    public double getLatitudinalDistance(Coordinate other) {
        if (other == null) {
            throw new IllegalArgumentException("'other' must not be null");
        }

        return abs(this.latitude - other.getLatitude());
    }

    /**
     * Calculates the longitudinal distance
     * @param other The coordinate to calculate the distance to
     * @return Returns the difference between the two Coordinates' longitude componets
     * @throws IllegalArgumentException Thrown if other is null
     */
    public double getLongitudinalDistance(Coordinate other) {
        if (other == null) {
            throw new IllegalArgumentException("'other' must not be null");
        }

        return abs(this.getLongitude() - other.getLongitude());
    }

    @Override
    public int hashCode() {

        return Double.valueOf(this.latitude).hashCode() |
                Double.valueOf(this.longitude).hashCode();
    }

    @Override
    public boolean equals(Object other) {

        if (other instanceof Coordinate) {
            return equals((Coordinate) other);
        } else {
            return false;
        }
    }

    public boolean equals(Coordinate other) {

        if (other == null) {
            return false;
        } else {
            return this == other || (this.getLatitude() == other.getLatitude() && this.getLongitude() == other.getLongitude());
        }
    }
}
