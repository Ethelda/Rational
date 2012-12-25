package org.tuziks.arithmetics.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.tuziks.arithmetics.DecimalValue;

public class DecimalValueTest {
    @Test
    public void testIsGreater() {
        DecimalValue d1 = new DecimalValue("4.2");
        DecimalValue d2 = new DecimalValue("2.4");

        assertTrue(d1.isGreater(d2));
        assertFalse(d2.isGreater(d1));
    }
}
