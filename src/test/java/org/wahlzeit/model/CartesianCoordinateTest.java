package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class CartesianCoordinateTest {


    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_throws_IllegalArgumentException_if_x_is_NaN() {
        new CartesianCoordinate(Double.NaN, 0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_throws_IllegalArgumentException_if_y_is_NaN() {
        new CartesianCoordinate(0, Double.NaN, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Constructor_throws_IllegalArgumentException_if_z_is_NaN() {
        new CartesianCoordinate(0,0, Double.NaN);
    }

    @Test
    public void test_equals_returns_true_if_all_values_are_the_same() {

        CartesianCoordinate coordinate1 = new CartesianCoordinate(1,2,3);
        CartesianCoordinate coordinate2 = new CartesianCoordinate(1,2,3);


        assertEquals(coordinate1, coordinate2);
    }


    @Test
    public void test_hashCode_returns_the_if_all_values_are_the_same() {

        CartesianCoordinate coordinate1 = new CartesianCoordinate(1,2,3);
        CartesianCoordinate coordinate2 = new CartesianCoordinate(1,2,3);

        assertEquals(coordinate1.hashCode(), coordinate2.hashCode());
    }
}
