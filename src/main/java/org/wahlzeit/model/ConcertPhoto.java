package org.wahlzeit.model;

public class ConcertPhoto extends Photo {


    private String artistName;
    private String genre;


    /***
     * @methodtype get
     * @methodproperty primitive
     */
    public String getArtistName() {
        return artistName;
    }

    /**
     * @methodtype set
     * @methodproperty composed
     */
    public void setArtistName(String value) {
        this.artistName = value;
        incWriteCount();
    }

    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * @methodtype set
     * @methodproperty composed
     */
    public void setGenre(String value) {
        this.genre = value;
        incWriteCount();
    }

}
