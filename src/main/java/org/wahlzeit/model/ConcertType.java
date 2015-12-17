package org.wahlzeit.model;

import java.io.Serializable;

public class ConcertType implements Serializable {


    private String artist;
    private String genre;
    private String tourName;


    public ConcertType(String artist, String genre, String tourName) {

        this.artist = artist;
        this.genre = genre;
        this.tourName = tourName;
    }



    public Concert createInstance() {
        return new Concert(this);
    }


    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String value) {
        this.artist = value;
    }

    public String getGenre()  {
        return this.genre;
    }

    public void setGenre(String value) {
        this.genre = value;
    }

    public String getTourName(){
        return this.tourName;
    }

    public void setTourName(String value) {
        this.tourName = value;
    }

}
