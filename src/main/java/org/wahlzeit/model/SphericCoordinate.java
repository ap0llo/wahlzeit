package org.wahlzeit.model;

import java.io.Serializable;

import static java.lang.Math.*;

public class SphericCoordinate extends AbstractCoordinate {

    // The radius of earth in kilometers for calculating the distance between two points
    private static final double EARTH_RADIUS = 6371d;

    private final double latitude;
    private final double longitude;
    private final double radius;


    public SphericCoordinate(double latitude, double longitude) {

        this(latitude, longitude, EARTH_RADIUS);
    }

    /**
     * Instantiates a new instance of SphericCoordinate
     *
     * @param latitude  The latitude value.
     * @param longitude The longitude value.
     * @param radius    The sphere's radius
     * @throws IllegalArgumentException Thrown if either longitude or latitude are not in the range [-360, 360]
     */
    public SphericCoordinate(double latitude, double longitude, double radius) {

        if (latitude > 90d || latitude < -90d) {
            throw new IllegalArgumentException("Latitude must be in range [-90, 90]");
        }

        if (longitude > 180d || longitude < -180d) {
            throw new IllegalArgumentException("Longitude must be in range [-180, 180]");
        }

        if (!(radius >= 0)) {
            throw new IllegalArgumentException("Radius must be positive");
        }

        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
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
     * @methodtype get
     * @methodproperty primitive
     */
    public double getRadius() {
        return radius;
    }


    /**
     * Calculates the latitudinal distance
     *
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
     *
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
                Double.valueOf(this.longitude).hashCode() |
                Double.valueOf(this.radius).hashCode();
    }

    /**
     * @methodtype boolean-query
     * @methodproperty primitive
     */
    @Override
    protected boolean doIsEqual(Coordinate c) {

        SphericCoordinate other = (SphericCoordinate) c;
        return this == other || (this.getLatitude() == other.getLatitude() && this.getLongitude() == other.getLongitude() && this.getRadius() == other.getRadius());

    }

    @Override
    protected double doGetDistance(Coordinate c) {

        double x1 = radius * sin(toRadians(longitude)) * cos(toRadians(latitude));
        double y1 = radius * sin(toRadians(longitude)) * sin(toRadians(latitude));
        double z1 = radius * sin(toRadians(longitude));

        SphericCoordinate other = (SphericCoordinate) c;

        double x2 = other.radius * sin(toRadians(other.longitude)) * cos(toRadians(other.latitude));
        double y2 = other.radius * sin(toRadians(other.longitude)) * sin(toRadians(other.latitude));
        double z2 = other.radius * sin(toRadians(other.longitude));

        return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2) + pow(z1 - z2, 2));
    }

    @Override
    protected void ensureCanGetDistance(Coordinate coordinate) {
        if (!(coordinate instanceof SphericCoordinate)) {
            throw new IllegalArgumentException("coordinate must be an instance of SphericCoordinate");
        }
    }

}
