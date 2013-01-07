package org.tuziks.arithmetics.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.tuziks.arithmetics.DecimalValue;

import java.text.DecimalFormatSymbols;

public class DecimalValueTest {
    @Test
    public void testIsGreater() {
        DecimalValue d1 = new DecimalValue("4.2");
        DecimalValue d2 = new DecimalValue("2.4");
        assertTrue(d1.isGreater(d2));
        assertFalse(d2.isGreater(d1));
    }

    @Test
    public void testAppend() {
        DecimalValue d = new DecimalValue("4");
        d.append("2");
        assertEquals("42", d.toString());
        d.append("12");
        d.append("3");
        assertEquals("42123", d.toString());

        d.append(".");
        assertEquals("42123", d.toString());


        d.append("1");
        assertEquals("42123.1", d.toString());

    }
}
