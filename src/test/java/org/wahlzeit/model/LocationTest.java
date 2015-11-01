package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocationTest {

    Location location1;
    Location location1_instance2;
    Location location2;
    Location location3;


    @Before
    public void setUp() {

        location1 = new Location("LocationName", new Coordinate(12.3, 4.56));
        location1_instance2 = new Location("LocationName", new Coordinate(12.3, 4.56));

        location2 = new Location("SomeOtherName", new Coordinate(12.3, 4.56));

        location3 = new Location("LocationName", new Coordinate(1.23, 45.6));

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Name_must_not_be_null() {
        new Location(null, new Coordinate(0,0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Name_must_not_be_empty() {
        new Location("", new Coordinate(0,0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Coordinate_must_not_be_null() {
        new Location("Irrelevant", null);
    }


    @Test
    public void test_Location_equal_if_coordinate_and_name_are_equal() {

        assertEquals(location1, location1_instance2);
        assertNotEquals(location1, location2);
        assertNotEquals(location1, location3);
    }

    @Test
    public void test_hashCode_is_equal_if_coordinate_and_name_are_equal(){

        assertEquals(location1.hashCode(), location1_instance2.hashCode());

    }
}
