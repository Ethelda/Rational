package org.tuziks.arithmetics.test;

import org.junit.Test;
import org.tuziks.arithmetics.DecimalValue;

import static org.junit.Assert.*;

public class DecimalValueTest {
    @Test
    public void testIsGreater() {
        DecimalValue d1 = new DecimalValue("4.2");
        DecimalValue d2 = new DecimalValue("2.4");
        assertTrue(d1.isGreater(d2));
        assertFalse(d2.isGreater(d1));
    }

    @Test
    public void testAppend1() {
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

    @Test
    public void testAppend2() {
        DecimalValue d = new DecimalValue();
        d.append(".222");
        assertEquals("0.222", d.toString());
    }

    @Test
    public void testAppend3() {
        DecimalValue d = new DecimalValue();
        String stuff = "1000000000000000000000000000000000000133700000000000000000000000000000000000000000000000000001" +
                "1234579656565265962654965962326549653.23456789101112131415161718192000000000000000000000000000" +
                "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001";

        for (int i = 0; i < stuff.length(); i = i + 2) {
            d.append(stuff.substring(i, i + 2));
        }

        assertEquals(stuff, d.toString());
    }

    @Test
    public void testAppend4() {
        DecimalValue d = new DecimalValue("");
        assertEquals("0", d.toString());

        d = new DecimalValue("                    ");
        assertEquals("0", d.toString());

        d = new DecimalValue(null);
        assertEquals("0", d.toString());

        d = new DecimalValue(".2");
        assertEquals("0.2", d.toString());
    }
}
