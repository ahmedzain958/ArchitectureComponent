package com.zain.alarmmanagerstandup.BlaBlas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GettingTest {

    @Test
    public void testConvertFehrnToCel() throws Exception {
        float input = 212;
        float output;
        float expected = 100;
        double delta = 0.1;


        Getting getting = new Getting();
        output = getting.convertFehrnToCel(input);
        assertEquals(expected, output, delta);
    }

    @Test
    public void testConvertCelToFahr() throws Exception{
        float input = 100;
        float output;
        float expected = 212;
        double delta = 0.1;


        Getting getting10 = new Getting();
        output = getting10.convertCelToFahr(input);
        assertEquals(expected, output, delta);
    }
}