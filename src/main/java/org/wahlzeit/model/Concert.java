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


    public ConcertType getType() {
        return this.type;
    }


    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location value) {
        this.location = value;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date value) {
        this.date = value;
    }

    public long getNumberOfVisitors() {
        return this.numberOfVisitors;
    }

    public void setNumberOfVisitors(long value) {
        assert value >= 0;
        this.numberOfVisitors = value;
    }

}
