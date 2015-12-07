package org.wahlzeit.model;


import java.io.Serializable;

// implemented as abstract class instead of an interface to make it persistable using Objectify
public abstract class Coordinate implements Serializable {

    /***
     * @methodtype get
     */
    public abstract double getDistance(Coordinate coordinate);

    /**
     * @methodtype boolean-query
     */
    public abstract boolean isEqual(Coordinate coordinate);

    /***
     * @methodtype get
     */
    public abstract double getX();

    /***
     * @methodtype set
     */
    public abstract Coordinate setX(double value);

    /***
     * @methodtype get
     */
    public abstract double getY();

    /**
     * @methodtype set
     */
    public abstract Coordinate setY(double value);

    /***
     * @methodtype get
     */
    public abstract double getZ();

    /***
     * @methodtype set
     */
    public abstract Coordinate setZ(double value);
}
