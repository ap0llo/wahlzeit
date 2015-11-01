package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

import java.util.UUID;
import java.util.logging.Logger;

public class ConcertPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(PhotoFactory.class.getName());

    private static ConcertPhotoFactory instance;


    /**
     * Hidden singleton instance; needs to be initialized from the outside.
     */
    public static void initialize() {
        getInstance(); // drops result due to getInstance() side-effects
    }

    /**
     * Public singleton access method.
     */
    public static synchronized PhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic PhotoFactory").toString());
            setInstance(new ConcertPhotoFactory());
        }

        return instance;
    }




    /**
     * Method to set the singleton instance of PhotoFactory.
     */
    protected static synchronized void setInstance(ConcertPhotoFactory photoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initalize PhotoFactory twice");
        }

        instance = photoFactory;
    }



    private ConcertPhotoFactory() {

    }



    /**
     * @methodtype factory
     */
    @Override
    public ConcertPhoto createPhoto() {
        ConcertPhoto result = new ConcertPhoto();
        result.setArtistName(UUID.randomUUID().toString());
        result.setGenre(UUID.randomUUID().toString());
        return result;
    }

    /**
     * Creates a new photo with the specified id
     */
    @Override
    public ConcertPhoto createPhoto(PhotoId id) {
        ConcertPhoto result = new ConcertPhoto(id);
        result.setArtistName(UUID.randomUUID().toString());
        result.setGenre(UUID.randomUUID().toString());
        return result;
    }


}
