package org.wahlzeit.model;

import org.wahlzeit.design.Pattern;
import org.wahlzeit.utils.MultiLevelHashMap;

@Pattern(name = "singleton")
public class ConcertTypeFactory {

    private static final ConcertTypeFactory instance = new ConcertTypeFactory();

    public static ConcertTypeFactory getInstance() {
        return instance;
    }


    private MultiLevelHashMap<String, String, String, ConcertType> types = new MultiLevelHashMap<>();

    private ConcertTypeFactory() {

    }



    public ConcertType getConcertType(String artist, String genre, String tourName) {

        ConcertType type = types.get(artist.toLowerCase(), genre.toLowerCase(), tourName.toLowerCase());
        if(type == null) {
            type = new ConcertType(artist, genre, tourName);
            types.put(artist.toLowerCase(), genre.toLowerCase(), tourName.toLowerCase(), type);
        }
        return type;
    }

}
