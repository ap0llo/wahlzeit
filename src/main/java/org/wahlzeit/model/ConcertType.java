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


    /**
     * @methodtype factory
     * @methodproperty primitive
     */
    public Concert createInstance() {
        return new Concert(this);
    }

    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public String getArtist() {
        return this.artist;
    }



    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public String getGenre()  {
        return this.genre;
    }



    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public String getTourName(){
        return this.tourName;
    }



}
