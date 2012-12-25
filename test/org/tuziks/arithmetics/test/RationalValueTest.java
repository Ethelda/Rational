package org.tuziks.arithmetics.test;

import org.junit.Test;
import org.tuziks.arithmetics.RationalValue;
import org.tuziks.arithmetics.RationalValue;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class RationalValueTest {
    @Test
    public void testCtor() {
        RationalValue r;

        r = new RationalValue(new BigInteger("1"), new BigInteger("2"));
        assertEquals("1/2", r.toString());

        r = new RationalValue("3", "4");
        assertEquals("3/4", r.toString());

        r = new RationalValue("5");
        assertEquals("5", r.toString());

        r = new RationalValue("-6", "7");
        assertEquals("-6/7", r.toString());

        r = new RationalValue("-8");
        assertEquals("-8", r.toString());

        r = new RationalValue("9/10");
        assertEquals("9/10", r.toString());

        // jabut vienkarostam:
        r = new RationalValue("100/200");
        assertEquals("1/2", r.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorIllegalArgument() throws Exception {
        new RationalValue("100/0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorIllegalArgument2() throws Exception {
        new RationalValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorIllegalArgument3() throws Exception {
        new RationalValue("/");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorIllegalArgument4() throws Exception {
        new RationalValue("1/");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorIllegalArgument5() throws Exception {
        new RationalValue("/1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorIllegalArgument6() throws Exception {
        new RationalValue(null, new BigInteger("1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorIllegalArgument7() throws Exception {
        new RationalValue(new BigInteger("1"), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorIllegalArgument8() throws Exception {
        BigInteger i1 = null;
        BigInteger i2 = null;
        new RationalValue(i1, i2);
    }

    @Test
    public void testIsGreater() {
        RationalValue r1 = new RationalValue("1/3");
        RationalValue r2 = new RationalValue("2/3");
        assertTrue(r2.isGreater(r1));
        assertFalse(r1.isGreater(r2));
        assertFalse(r1.isGreater(r1));
        assertFalse(r2.isGreater(r2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsGreaterNull() throws Exception {
        String s = null;
        new RationalValue("1/3").isGreater(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsGreaterRationalNull() throws Exception {
        RationalValue r = null;
        new RationalValue("1/3").isGreater(r);
    }

    @Test
    public void testNeg() {
        RationalValue r = new RationalValue("1/3");
        assertEquals("-1/3", r.neg().toString());
        assertEquals("1/3", r.neg().neg().toString());
    }

    @Test
    public void testAdd() {

        // 1/3 + 1/3 = 2/3
        RationalValue r1 = new RationalValue("1/3");
        RationalValue r2 = new RationalValue("1/3");
        assertEquals("2/3", r1.add(r2).toString());

        // 1/2 + 1/2 = 1
        r1 = new RationalValue("1/2");
        assertEquals("1", r1.add(r1).toString());

        // 17/13 + 13/17 = 458/221
        r1 = new RationalValue("17/13");
        r2 = new RationalValue("13/17");
        assertEquals("458/221", r1.add(r2).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNull() throws Exception {
        String s = null;
        new RationalValue("1/3").add(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRationalNull() throws Exception {
        RationalValue r = null;
        new RationalValue("1/3").add(r);
    }

    @Test
    public void testSubtract() {

        // 2/3 - 1/3 = 1/3
        RationalValue r1 = new RationalValue("2/3");
        RationalValue r2 = new RationalValue("1/3");
        assertEquals("1/3", r1.subtract(r2).toString());

        // 1 - 1/2 = 1/2
        r1 = new RationalValue("1");
        r2 = new RationalValue("1/2");
        assertEquals("1/2", r1.subtract(r2).toString());

        // 458/221 - 17/13 = 13/17
        r1 = new RationalValue("458/221");
        r2 = new RationalValue("17/13");
        assertEquals("13/17", r1.subtract(r2).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractNull() throws Exception {
        String s = null;
        new RationalValue("1/3").subtract(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractRationalNull() throws Exception {
        RationalValue r = null;
        new RationalValue("1/3").subtract(r);
    }

    @Test
    public void testMultiply() {

        // 17/13 * 13/17 = 13/17 * 17/13 = 1
        RationalValue r1 = new RationalValue("17/13");
        RationalValue r2 = new RationalValue("13/17");
        assertEquals("1", r1.multiply(r2).toString());
        assertEquals("1", r2.multiply(r1).toString());

        // 2/3 - 4/5 = 8/15
        r1 = new RationalValue("2/3");
        r2 = new RationalValue("4/5");
        assertEquals("8/15", r1.multiply(r2).toString());
        assertEquals("8/15", r2.multiply(r1).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyNull() throws Exception {
        String s = null;
        new RationalValue("1/3").multiply(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyRationalNull() throws Exception {
        RationalValue r = null;
        new RationalValue("1/3").multiply(r);
    }

    @Test
    public void testDivide() {
        // 4/3 : 9/5 = 20/27
        RationalValue r1 = new RationalValue("4/3");
        RationalValue r2 = new RationalValue("9/5");
        assertEquals("20/27", r1.divide(r2).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideNull() throws Exception {
        String s = null;
        new RationalValue("1/3").divide(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideRationalNull() throws Exception {
        RationalValue i = null;
        new RationalValue("1/3").divide(i);
    }

    @Test
    public void testAllTogether() {
        // -(((1/2 + 3/4) * ((5/6) / (7/8))) - 9/10) = -61/210
        assertEquals("-61/210", new RationalValue("1/2").add("3/4").multiply("5/6").divide("7/8").subtract("9/10").neg().toString());
    }
}
