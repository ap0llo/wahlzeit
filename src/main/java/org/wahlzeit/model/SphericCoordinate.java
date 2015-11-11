package org.wahlzeit.model;

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
    @Override
    public double getX() {
        return getRadius() * sin(toRadians(longitude)) * cos(toRadians(latitude));
    }

    /**
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
    public double getY() {
        return getRadius() * sin(toRadians(longitude)) * sin(toRadians(latitude));
    }

    /**
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
    public double getZ() {
        return getRadius() * sin(toRadians(longitude));
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




}
