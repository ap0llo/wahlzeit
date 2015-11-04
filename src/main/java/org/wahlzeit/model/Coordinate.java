package org.wahlzeit.model;


import java.io.Serializable;

public abstract class Coordinate implements Serializable {

    public abstract double getDistance(Coordinate coordinate);

    public abstract boolean isEqual(Coordinate coordinate);

}
