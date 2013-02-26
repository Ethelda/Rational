package org.tuziks.arithmetics.test;

import org.junit.Test;
import org.tuziks.arithmetics.IntegerValue;

import static org.junit.Assert.*;

public class IntegerValueTest {
    @Test
    public void testIsGreater() {
        IntegerValue i1 = new IntegerValue("4");
        IntegerValue i2 = new IntegerValue("2");

        assertTrue(i1.isGreater(i2));
        assertFalse(i2.isGreater(i1));
    }

    @Test
    public void testAppend1() {
        IntegerValue i = new IntegerValue();
        assertEquals("0", i.toString());
        i.append("0");

        assertEquals("0", i.toString());

        i.append("1");
        assertEquals("1", i.toString());
        i.append("2345678");
        assertEquals("12345678", i.toString());
    }
}
