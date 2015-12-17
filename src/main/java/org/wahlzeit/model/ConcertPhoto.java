package org.wahlzeit.model;

import com.googlecode.objectify.annotation.Subclass;

@Subclass(index = true)
public class ConcertPhoto extends Photo {


    private Concert concert;



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
    public Concert getConcert() {
        return this.concert;
    }

    /**
     * @methodtype set
     * @methodproperty composed
     */
    public void setConcert(Concert value) {
        this.concert = concert;
        incWriteCount();
    }


}
