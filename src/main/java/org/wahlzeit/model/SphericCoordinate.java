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

        // preconditions
        assertIsValidLatitude(latitude);
        assertIsValidLongitude(longitude);
        assertIsValidRadius(radius);

        // implementation
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;

        //postconditions
        assert this.latitude == latitude;
        assert this.longitude == longitude;
        assert this.radius == radius;
        assertClassInvariants();
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
     * @methodtype set
     * @methodproperty composed
     */
    public SphericCoordinate setLatitude(double value) {

        //preconditions
        assertIsValidLatitude(value);

        // method implementation
        SphericCoordinate result = new SphericCoordinate(value, this.getLongitude(), this.getRadius());

        //postconditions
        assert result.getLatitude() == value;

        return result;
    }

    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @methodtype set
     * @methodproperty composed
     */
    public SphericCoordinate setLongitude(double value) {

        //preconditions
        assertIsValidLongitude(value);

        //method implementation
        SphericCoordinate result = new SphericCoordinate(this.getLatitude(), value, this.getRadius());

        //postconditions
        assert result.getLongitude() == value;


        return result;
    }

    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @methodtype set
     * @methodproperty composed
     */
    public SphericCoordinate setRadius(double value) {

        //preconditions
        assertIsValidRadius(value);

        //method implementation
        SphericCoordinate result = new SphericCoordinate(this.getLatitude(), this.getLongitude(), value);

        //postconditions
        assert result.getRadius() == value;

        return result;
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

        // preconditions
        assertCoordinateIsNotNull(other);

        //method implementation
        double result = abs(this.latitude - other.getLatitude());

        //postconditions
        assertIsValidDistance(result);

        // method does not change object state => no need to check class invariants

        return result;
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

        // preconditions
        assertCoordinateIsNotNull(other);

        // method implementation
        double result = abs(this.getLongitude() - other.getLongitude());

        //postconditions
        assertIsValidDistance(result);

        // method does not change object state => no need to check class invariants

        return result ;
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
     * @methodtype assertion
     * @methodproperty composed
     */
    @Override
    protected void assertClassInvariants() {

        super.assertClassInvariants();

        assertIsValidLatitude(this.latitude);

        assertIsValidLongitude(this.longitude);

        assertIsValidRadius(this.radius);
    }

    /**
     * @methodtype assertion
     * @methodproperty primitive
     */
    protected void assertIsValidLatitude(double value) {
        assert !Double.isNaN(value) : "Latitude must be a number";
        assert value <= 90d : "Latitude must be less or equal than 90 degrees";
        assert value >= -90d : "Latitude must not be lass then -90 degrees";
    }

    /**
     * @methodtype assertion
     * @methodproperty primitive
     */
    protected void assertIsValidLongitude(double value) {
        assert !Double.isNaN(longitude) : "Longitude must be a number";
        assert longitude <= 180d : "Longitude buse be less or equal than 180 degrees";
        assert longitude >= -180d : "Longitude must not be less than -180 degrees";
    }

    /**
     * @methodtype assertion
     * @methodproperty primitive
     */
    protected void assertIsValidRadius(double value) {
        assert !Double.isNaN(radius) : "Radius must be a number";
        assert radius >= 0 : "Radius must be positive or 0";
    }


    @Override
    protected AbstractCoordinate doSetX(double x) {
        return convertFromCartesianCoordinates(x, this.getY(), this.getZ());
    }

    @Override
    protected AbstractCoordinate doSetY(double y) {
        return convertFromCartesianCoordinates(this.getX(), y, this.getZ());
    }

    @Override
    protected AbstractCoordinate doSetZ(double z) {
        return new SphericCoordinate(this.getX(), this.getY(), z);
    }

    private AbstractCoordinate convertFromCartesianCoordinates(double x, double y, double z) {

        double radius = sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2));
        double latitude = atan(y / x);
        double longitude = acos( z / radius);

        return new SphericCoordinate(latitude, longitude, radius);
    }


}
