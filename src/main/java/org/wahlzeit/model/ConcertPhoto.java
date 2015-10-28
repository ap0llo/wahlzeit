package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass(index = true)
public class ConcertPhoto extends Photo {


    private String artistName;
    private String genre;


    public ConcertPhoto() {
        super();
    }

    public ConcertPhoto(PhotoId photoId) {
        super(photoId);
    }


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
