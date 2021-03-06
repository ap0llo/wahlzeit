package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SphericCoordinateTest {

    SphericCoordinate nullInstance;
    SphericCoordinate zeroCoordinate;
    SphericCoordinate coordinate1;
    SphericCoordinate coordinate1_instance2;
    SphericCoordinate coordinate2;
    SphericCoordinate coordinate3;
    SphericCoordinate coordinate4;

    double distance_0_to_1;
    double distance_0_to_2;
    double distance_0_to_3;
    double distance_0_to_4;
    double distance_2_to_4;

    // delta for comparisons between expected and calculated distances
    // (expected distance were calculated with a external tool and hence were rounded differently)
    static final double DISTANCE_EPSILON = 0.3d;


    @Before
    public void setUp() {

        nullInstance = null;
        zeroCoordinate = SphericCoordinate.newInstance(0.0, 0.0);

        coordinate1 = SphericCoordinate.newInstance(42.5, 23.42);
        coordinate1_instance2 = SphericCoordinate.newInstance(42.5, 23.42);
        distance_0_to_1 = 3581.1d;

        coordinate2 = SphericCoordinate.newInstance(13.37, 123.456);
        distance_0_to_2 = 7517d;

        coordinate3 = SphericCoordinate.newInstance(50, 5);
        distance_0_to_3 = 785.2d;

        coordinate4 = SphericCoordinate.newInstance(58,3);
        distance_0_to_4 = 471.5;


        distance_2_to_4 = 7117.7d;
    }

    @Test
    public void test_Constructor_allows_latitude_values_between_minus90_and_90() {
        SphericCoordinate.newInstance(90, 0);
        SphericCoordinate.newInstance(-90, 0);
    }

    @Test
    public void test_Constructor_allows_longitude_values_between_minus180_and_180() {
        SphericCoordinate.newInstance(0, 180);
        SphericCoordinate.newInstance(0, -180);
    }

    @Test(expected = AssertionError.class)
    public void test_Constructor_throws_IllegalArgumentException_for_latitude_less_than_minus90_1() {
        SphericCoordinate.newInstance(-91, 0);
    }

    @Test(expected = AssertionError.class)
    public void test_Constructor_throws_IllegalArgumentException_for_latitude_less_than_minus90_2() {
        SphericCoordinate.newInstance(-145, 0);
    }

    @Test(expected = AssertionError.class)
    public void test_Constructor_throws_IllegalArgumentException_for_latitude_greater_than_90_1() {
        SphericCoordinate.newInstance(91, 0);
    }

    @Test(expected = AssertionError.class)
    public void test_Constructor_throws_IllegalArgumentException_for_latitude_greater_than_90_2() {
        SphericCoordinate.newInstance(123, 0);
    }

    @Test(expected = AssertionError.class)
    public void test_Constructor_throws_IllegalArgumentException_for_longitude_less_than_minus180_1() {
        SphericCoordinate.newInstance(0, -181);
    }

    @Test(expected = AssertionError.class)
    public void test_Constructor_throws_IllegalArgumentException_for_longitude_less_than_minus180_2() {
        SphericCoordinate.newInstance(0, -567);
    }

    @Test(expected = AssertionError.class)
    public void test_Constructor_throws_IllegalArgumentException_for_longitude_greater_than_180_1() {
        SphericCoordinate.newInstance(0, 181);
    }

    @Test(expected = AssertionError.class)
    public void test_Constructor_throws_IllegalArgumentException_for_longitude_greater_than_180_2() {
        SphericCoordinate.newInstance(0, 256);
    }

    @Test(expected = AssertionError.class)
    public void test_Constructor_throws_IllegalArgumentException_for_negative_radius() {
        SphericCoordinate.newInstance(0, 256, -1);
    }

    @Test
    public void test_hashCode_is_equal_for_equal_instances() {

        assertEquals(coordinate1.hashCode(), coordinate1_instance2.hashCode());
    }

    @Test
    public void test_equals_returns_true_if_all_components_are_the_same() {

        assertEquals(zeroCoordinate, zeroCoordinate);
        assertEquals(coordinate1, coordinate1_instance2);
        assertNotEquals(coordinate1, zeroCoordinate);
    }

    @Test
    public void test_equals_returns_false_for_null_arguments() {

        assertFalse(zeroCoordinate.equals(null));
        assertFalse(coordinate1.equals(nullInstance));
    }

    @Test(expected = AssertionError.class)
    public void test_getDistance_throws_IllegalArgumentException() {

        zeroCoordinate.getDistance(null);
    }

    @Test
    public void test_getDistance_of_identity() {

        double expected = 0;

        assertEquals(expected, zeroCoordinate.getDistance(zeroCoordinate), 0.0);
        assertEquals(expected, coordinate1.getDistance(coordinate1), 0.0);
        assertEquals(expected, coordinate1_instance2.getDistance(coordinate1_instance2), 0.0);
    }

    @Test
    public void test_getDistance_to_zero() {

        assertEquals(distance_0_to_1, coordinate1.getDistance(zeroCoordinate), DISTANCE_EPSILON);
        assertEquals(distance_0_to_2, coordinate2.getDistance(zeroCoordinate), DISTANCE_EPSILON);
        assertEquals(distance_0_to_3, coordinate3.getDistance(zeroCoordinate), DISTANCE_EPSILON);
        assertEquals(distance_0_to_4, coordinate4.getDistance(zeroCoordinate), DISTANCE_EPSILON);

    }

    @Test
    public void test_getDistance(){

        assertEquals(distance_2_to_4, coordinate2.getDistance(coordinate4), DISTANCE_EPSILON);
    }

    @Test
    public void test_getDistance_parameters_can_be_swapped(){

        assertEquals(coordinate1.getDistance(zeroCoordinate), zeroCoordinate.getDistance(coordinate1), 0.0);
        assertEquals(coordinate2.getDistance(zeroCoordinate), zeroCoordinate.getDistance(coordinate2), 0.0);
        assertEquals(coordinate3.getDistance(zeroCoordinate), zeroCoordinate.getDistance(coordinate3), 0.0);
        assertEquals(coordinate4.getDistance(zeroCoordinate), zeroCoordinate.getDistance(coordinate4), 0.0);

        assertEquals(coordinate1.getDistance(coordinate2), coordinate2.getDistance(coordinate1), 0.0);
        assertEquals(coordinate2.getDistance(coordinate2), coordinate2.getDistance(coordinate2), 0.0);
        assertEquals(coordinate3.getDistance(coordinate2), coordinate2.getDistance(coordinate3), 0.0);
        assertEquals(coordinate4.getDistance(coordinate2), coordinate2.getDistance(coordinate4), 0.0);

        assertEquals(coordinate1.getDistance(coordinate3), coordinate3.getDistance(coordinate1), 0.0);
        assertEquals(coordinate2.getDistance(coordinate3), coordinate3.getDistance(coordinate2), 0.0);
        assertEquals(coordinate3.getDistance(coordinate3), coordinate3.getDistance(coordinate3), 0.0);
        assertEquals(coordinate4.getDistance(coordinate3), coordinate3.getDistance(coordinate4), 0.0);


        assertEquals(coordinate1.getDistance(coordinate4), coordinate4.getDistance(coordinate1), 0.0);
        assertEquals(coordinate2.getDistance(coordinate4), coordinate4.getDistance(coordinate2), 0.0);
        assertEquals(coordinate3.getDistance(coordinate4), coordinate4.getDistance(coordinate3), 0.0);
        assertEquals(coordinate4.getDistance(coordinate4), coordinate4.getDistance(coordinate4), 0.0);

    }

    @Test(expected = AssertionError.class)
    public void test_getLatitudinalDistance_throws_IllegalArgumentException() {

        zeroCoordinate.getLatitudinalDistance(null);
    }

    @Test
    public void test_getLatitudinalDistance() {
        assertEquals(coordinate1.getLatitude() - coordinate2.getLatitude(), coordinate1.getLatitudinalDistance(coordinate2), 0);
    }


    @Test
    public void test_getLatitudinalDistance_parameters_can_be_swapped() {
        assertEquals(coordinate1.getLatitudinalDistance(coordinate2), coordinate2.getLatitudinalDistance(coordinate1), 0.0);
    }


    @Test(expected = AssertionError.class)
    public void test_getLongitudinalDistance_throws_IllegalArgumentException() {

        zeroCoordinate.getLongitudinalDistance(null);
    }

    @Test
    public void test_getLongitudinalDistance() {
        assertEquals(Math.abs(coordinate1.getLongitude() - coordinate2.getLongitude()), coordinate1.getLongitudinalDistance(coordinate2), 0);
    }


    @Test
    public void test_getLongitudinalDistance_parameters_can_be_swapped() {
        assertEquals(coordinate1.getLongitudinalDistance(coordinate2), coordinate2.getLongitudinalDistance(coordinate1), 0.0);
    }

    @Test
    public void test_isEqual_returns_true_if_both_components_are_the_same() {

        assertEquals(zeroCoordinate, zeroCoordinate);
        assertEquals(coordinate1, coordinate1_instance2);
        assertNotEquals(coordinate1, zeroCoordinate);
    }

    @Test
    public void test_isEqual_returns_false_for_null_arguments() {

        assertFalse(zeroCoordinate.equals(null));
        assertFalse(coordinate1.equals(nullInstance));
    }


}
