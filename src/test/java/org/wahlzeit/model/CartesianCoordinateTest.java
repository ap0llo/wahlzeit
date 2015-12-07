package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static java.lang.Math.*;

public class CartesianCoordinateTest {

    private CartesianCoordinate coordinate1 = CartesianCoordinate.newInstance(1,2,3);
    private CartesianCoordinate coordinate1_instance2 = CartesianCoordinate.newInstance(1,2,3);
    private CartesianCoordinate coordinate2 = CartesianCoordinate.newInstance(4,5,6);



    @Test(expected = AssertionError.class)
    public void test_Constructor_throws_IllegalArgumentException_if_x_is_NaN() {
        CartesianCoordinate.newInstance(Double.NaN, 0,0);
    }

    @Test(expected = AssertionError.class)
    public void test_Constructor_throws_IllegalArgumentException_if_y_is_NaN() {
        CartesianCoordinate.newInstance(0, Double.NaN, 0);
    }

    @Test(expected = AssertionError.class)
    public void test_Constructor_throws_IllegalArgumentException_if_z_is_NaN() {
        CartesianCoordinate.newInstance(0,0, Double.NaN);
    }

    @Test
    public void test_equals_returns_true_if_all_values_are_the_same() {

        assertEquals(coordinate1, coordinate1_instance2);
    }

    @Test
    public void test_hashCode_returns_the_if_all_values_are_the_same() {

        assertEquals(coordinate1.hashCode(), coordinate1_instance2.hashCode());
    }

    @Test(expected = AssertionError.class)
    public void test_getDistance_throws_IllegalArgumentException() {

        coordinate1.getDistance(null);
    }

    @Test
    public void test_getDistance_returns_0_for_self() {
        assertEquals(0, coordinate1.getDistance(coordinate1), 0);
        assertEquals(0, coordinate1.getDistance(coordinate1_instance2), 0);
    }

    @Test
    public void test_getDistance_returns_expectedValue() {

        double expected = sqrt(
                pow(coordinate1.getX() - coordinate2.getX(), 2) +
                pow(coordinate1.getY() - coordinate2.getY(), 2) +
                pow(coordinate1.getZ() - coordinate2.getZ(), 2)
        );

        assertEquals(expected, coordinate1.getDistance(coordinate2), 0);
    }

    @Test
    public void test_getDistance_parameters_can_be_swapped(){
        assertEquals(coordinate1.getDistance(coordinate2), coordinate2.getDistance(coordinate1), 0);
    }
}
