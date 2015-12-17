package org.wahlzeit.model;

import java.io.Serializable;
import java.util.Date;

public class Concert implements Serializable {


    private final ConcertType type;
    private Location location;
    private Date date;
    private long numberOfVisitors;

    protected Concert(ConcertType type){

        assert type != null;
        this.type = type;
    }

    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public ConcertType getType() {
        return this.type;
    }

    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * @methodtype set
     * @methodproperty primitive
     */
    public void setLocation(Location value) {
        this.location = value;
    }

    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * @methodtype set
     * @methodproperty primitive
     */
    public void setDate(Date value) {
        this.date = value;
    }

    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public long getNumberOfVisitors() {
        return this.numberOfVisitors;
    }

    /**
     * @methodtype set
     * @methodproperty primitive
     */
    public void setNumberOfVisitors(long value) {
        assert value >= 0;
        this.numberOfVisitors = value;
    }

}
