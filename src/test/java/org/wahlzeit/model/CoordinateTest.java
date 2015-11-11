package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {



    @Test
    public void test_isEqual_for_SphericCoordinate_and_CartesianCoordinate_returns_true_if_they_describe_the_same_point(){

        SphericCoordinate coordinate1 = new SphericCoordinate(23.34, 42, 25);
        CartesianCoordinate coordinate2 = new CartesianCoordinate(coordinate1.getX(), coordinate1.getY(), coordinate1.getZ());

        assertTrue(coordinate1.isEqual(coordinate2));
        assertTrue(coordinate2.isEqual(coordinate1));

    }

    @Test
    public void test_getDistance_can_handle_both_cartesian_and_spheric_coordinates(){

        SphericCoordinate coordinate1 = new SphericCoordinate(23.34, 42, 25);
        CartesianCoordinate coordinate2 = new CartesianCoordinate(coordinate1.getX(), coordinate1.getY(), coordinate1.getZ());

        assertEquals(0, coordinate1.getDistance(coordinate2), 0);
        assertEquals(0, coordinate2.getDistance(coordinate1), 0);

        assertEquals(0, coordinate1.getDistance(coordinate1), 0);
        assertEquals(0, coordinate2.getDistance(coordinate2), 0);
    }
}
