package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CoordinateTest {

    Coordinate nullInstance;
    Coordinate zeroCoordinate;
    Coordinate coordinate1;
    Coordinate coordinate1_instance2;
    Coordinate coordinate2;

    @Before
    public void setUp() {

        nullInstance = null;
        zeroCoordinate = new Coordinate(0, 0);

        coordinate1 = new Coordinate(42.5, 23.42);
        coordinate1_instance2 = new Coordinate(42.5, 23.42);

        coordinate2 = new Coordinate(13.37, 123.456);
    }

    @Test
    public void test_Constructor_allows_latitude_values_between_minus90_and_90() {
        new Coordinate(90, 0);
        new Coordinate(-90, 0);
    }

    @Test
    public void test_Constructor_allows_longitude_values_between_minus180_and_180() {
        new Coordinate(0, 180);
        new Coordinate(0, -180);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_throws_IllegalArgumentException_for_latitude_less_than_minus90_1() {
        new Coordinate(-91, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_throws_IllegalArgumentException_for_latitude_less_than_minus90_2() {
        new Coordinate(-145, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_throws_IllegalArgumentException_for_latitude_greater_than_90_1() {
        new Coordinate(91, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_throws_IllegalArgumentException_for_latitude_greater_than_90_2() {
        new Coordinate(123, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_throws_IllegalArgumentException_for_longitude_less_than_minus180_1() {
        new Coordinate(0, -181);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_throws_IllegalArgumentException_for_longitude_less_than_minus180_2() {
        new Coordinate(0, -567);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_throws_IllegalArgumentException_for_longitude_greater_than_180_1() {
        new Coordinate(0, 181);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_throws_IllegalArgumentException_for_longitude_greater_than_180_2() {
        new Coordinate(0, 256);
    }

    @Test
    public void test_hashCode_is_equal_for_equal_instances() {

        assertEquals(coordinate1.hashCode(), coordinate1_instance2.hashCode());
    }

    @Test
    public void test_equals_returns_true_if_both_components_are_the_same() {

        assertEquals(zeroCoordinate, zeroCoordinate);
        assertEquals(coordinate1, coordinate1_instance2);
        assertNotEquals(coordinate1, zeroCoordinate);
    }

    @Test
    public void test_equals_returns_false_for_null_arguments() {

        assertFalse(zeroCoordinate.equals(null));
        assertFalse(coordinate1.equals(nullInstance));
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_getDistance_throws_IllegalArgumentException() {

        zeroCoordinate.getDistance(null);
    }

    @Test
    public void test_getDistance_of_identity() {

        Coordinate expected = new Coordinate(0, 0);

        assertEquals(expected, zeroCoordinate.getDistance(zeroCoordinate));
        assertEquals(expected, coordinate1.getDistance(coordinate1));
        assertEquals(expected, coordinate1_instance2.getDistance(coordinate1_instance2));
    }

    @Test
    public void test_getDistance_from_zero_coordinate_returns_value_equal_to_original_value() {

        assertEquals(coordinate1, coordinate1_instance2.getDistance(zeroCoordinate));
        assertEquals(coordinate2, coordinate2.getDistance(zeroCoordinate));
    }

    @Test
    public void test_getDistance_returns_correct_distance() {

        Coordinate expected = new Coordinate(coordinate1.getLatitude() - coordinate2.getLatitude(),
                coordinate1.getLongitude() - coordinate2.getLongitude());

        assertEquals(expected, coordinate1.getDistance(coordinate2));
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_getLatitudinalDistance_throws_IllegalArgumentException() {

        zeroCoordinate.getLatitudinalDistance(null);
    }

    @Test
    public void test_getLatitudinalDistance() {

        assertEquals(coordinate1.getLatitude() - coordinate2.getLatitude(), coordinate1.getLatitudinalDistance(coordinate2), 0);
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_getLongitudinalDistance_throws_IllegalArgumentException() {

        zeroCoordinate.getLongitudinalDistance(null);
    }

    @Test
    public void test_getLongitudinalDistance() {

        assertEquals(coordinate1.getLongitude() - coordinate2.getLongitude(), coordinate1.getLongitudinalDistance(coordinate2), 0);
    }

}
