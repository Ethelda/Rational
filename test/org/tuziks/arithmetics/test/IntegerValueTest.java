package org.tuziks.arithmetics.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.tuziks.arithmetics.IntegerValue;

public class IntegerValueTest {
    @Test
    public void testIsGreater() {
        IntegerValue i1 = new IntegerValue("4");
        IntegerValue i2 = new IntegerValue("2");

        assertTrue(i1.isGreater(i2));
        assertFalse(i2.isGreater(i1));
    }
}
