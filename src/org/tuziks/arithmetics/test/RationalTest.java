package org.tuziks.arithmetics.test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import org.tuziks.arithmetics.Rational;

public class RationalTest {
	@Test
	public void testCtor() {
		Rational r;

		r = new Rational(new BigInteger("1"), new BigInteger("2"));
		assertEquals("1/2", r.toString());
	
		r = new Rational("3", "4");
		assertEquals("3/4", r.toString());

		r = new Rational("5");
		assertEquals("5", r.toString());

		r = new Rational("-6", "7");
		assertEquals("-6/7", r.toString());

		r = new Rational("-8");
		assertEquals("-8", r.toString());
		
		r = new Rational("9/10");
		assertEquals("9/10", r.toString());
		
		// jabut vienkarostam:
		r = new Rational("100/200");
		assertEquals("1/2", r.toString());
	}
	
    @Test(expected = IllegalArgumentException.class)
    public void testCtorIllegalArgument() throws Exception {
    	new Rational("100/0");
    }

    
	@Test
	public void testIsGreater() {
		Rational r1 = new Rational("1/3");
		Rational r2 = new Rational("2/3");
		assertTrue(r2.isGreater(r1));
		assertFalse(r1.isGreater(r2));
		assertFalse(r1.isGreater(r1));
		assertFalse(r2.isGreater(r2));
	}
	
	@Test
	public void testNeg() {
		Rational r = new Rational("1/3");
		assertEquals("-1/3", r.neg().toString());
		assertEquals("1/3", r.neg().neg().toString());
	}
	
	@Test
	public void testAdd() {
		
		// 1/3 + 1/3 = 2/3
		Rational r1 = new Rational("1/3");
		Rational r2 = new Rational("1/3");
		assertEquals("2/3", r1.add(r2).toString());

		// 1/2 + 1/2 = 1
		r1 = new Rational("1/2");
		assertEquals("1", r1.add(r1).toString());
		
		// 17/13 + 13/17 = 458/221
		r1 = new Rational("17/13");
		r2 = new Rational("13/17");
		assertEquals("458/221", r1.add(r2).toString());
	}

	
	@Test
	public void testSubtract() {
		
		// 2/3 - 1/3 = 1/3
		Rational r1 = new Rational("2/3");
		Rational r2 = new Rational("1/3");
		assertEquals("1/3", r1.subtract(r2).toString());

		// 1 - 1/2 = 1/2
		r1 = new Rational("1");
		r2 = new Rational("1/2");
		assertEquals("1/2", r1.subtract(r2).toString());

		// 458/221 - 17/13 = 13/17
		r1 = new Rational("458/221");
		r2 = new Rational("17/13");
		assertEquals("13/17", r1.subtract(r2).toString());
	}
	
	
	@Test
	public void testMultiply() {
		
		// 17/13 * 13/17 = 13/17 * 17/13 = 1
		Rational r1 = new Rational("17/13");
		Rational r2 = new Rational("13/17");
		assertEquals("1", r1.multiply(r2).toString());
		assertEquals("1", r2.multiply(r1).toString());

		// 2/3 - 4/5 = 8/15
		r1 = new Rational("2/3");
		r2 = new Rational("4/5");
		assertEquals("8/15", r1.multiply(r2).toString());
		assertEquals("8/15", r2.multiply(r1).toString());
	}
	
	@Test
	public void testDivide() {
		// 4/3 : 9/5  = 20/27
		Rational r1 = new Rational("4/3");
		Rational r2 = new Rational("9/5");
		assertEquals("20/27", r1.divide(r2).toString());
	}
}