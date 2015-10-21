package org.wahlzeit.model;

public class Coordinate {

    private final double latitude;
    private final double longitude;


    public Coordinate(double latitude, double longitude) {

        if(latitude > 360d || latitude < -360d) {
            throw new IllegalArgumentException("Latitude must be in range [-360, 360]");
        }

        if(longitude > 360d || longitude < -360d) {
            throw new IllegalArgumentException("Longitude must be in range [-360, 360]");
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


    public Coordinate getDistance(Coordinate other) {

        if (other == null) {
            throw new IllegalArgumentException("'other' must not be null");
        }

        return new Coordinate(this.getLatitude() - other.getLatitude(), this.getLongitude() - other.getLongitude());
    }


    public double getLatitudinalDistance(Coordinate other) {
        if (other == null) {
            throw new IllegalArgumentException("'other' must not be null");
        }

        return this.latitude - other.getLatitude();
    }

    public double getLongitudinalDistance(Coordinate other) {
        if (other == null) {
            throw new IllegalArgumentException("'other' must not be null");
        }

        return this.getLongitude() - other.getLongitude();
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
