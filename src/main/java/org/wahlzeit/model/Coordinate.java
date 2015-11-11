package org.wahlzeit.model;


import java.io.Serializable;

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
     * @methodtype get
     */
    public abstract double getY();

    /***
     * @methodtype get
     */
    public abstract double getZ();

}
