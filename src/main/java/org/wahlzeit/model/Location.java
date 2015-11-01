package org.wahlzeit.model;

import java.io.Serializable;

public class Location implements Serializable {


    private String name;
    private Coordinate coordinate;

    public Location(String name, Coordinate coordinate) {

        if(name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("'name' must not be null or empty");
        }

        if(coordinate == null) {
            throw new IllegalArgumentException("'coordinate' must not be null");
        }

        this.name = name;
        this.coordinate = coordinate;
    }

    /**
     *
     * @methodtype get
     * @methodproperty primitive
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @methodtype get
     * @methodproperty primitive
     */
    public Coordinate getCoordinate() {
        return this.coordinate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Location other = (Location) o;
        return name.equals(other.name) && coordinate.equals(other.coordinate);

    }

    @Override
    public int hashCode() {

        return 31 * name.hashCode()+ (coordinate.hashCode());

    }
}
