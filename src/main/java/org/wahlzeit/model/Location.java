package org.wahlzeit.model;

import java.io.Serializable;

public class Location implements Serializable {


    private String name;
    private Coordinate coordinate;

    public Location(String name, Coordinate coordinate) {
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




}
