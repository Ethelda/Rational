package org.tuziks.arithmetics.test;

import org.junit.Test;
import org.tuziks.arithmetics.IntegerValue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntegerValueTest {
    @Test
    public void testIsGreater() {
        IntegerValue i1 = new IntegerValue("4");
        IntegerValue i2 = new IntegerValue("2");

        assertTrue(i1.isGreater(i2));
        assertFalse(i2.isGreater(i1));
    }
}
