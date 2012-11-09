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

	@Test(expected = IllegalArgumentException.class)
	public void testCtorIllegalArgument2() throws Exception {
		new Rational(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCtorIllegalArgument3() throws Exception {
		new Rational("/");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCtorIllegalArgument4() throws Exception {
		new Rational("1/");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCtorIllegalArgument5() throws Exception {
		new Rational("/1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCtorIllegalArgument6() throws Exception {
		new Rational(null, new BigInteger("1"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCtorIllegalArgument7() throws Exception {
		new Rational(new BigInteger("1"), null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCtorIllegalArgument8() throws Exception {
		BigInteger i1 = null;
		BigInteger i2 = null;
		new Rational(i1, i2);
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

	@Test(expected = IllegalArgumentException.class)
	public void testIsGreaterNull() throws Exception {
		String s = null;
		new Rational("1/3").isGreater(s);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testIsGreaterRationalNull() throws Exception {
		Rational r = null;
		new Rational("1/3").isGreater(r);
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

	@Test(expected = IllegalArgumentException.class)
	public void testAddNull() throws Exception {
		String s = null;
		new Rational("1/3").add(s);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddRationalNull() throws Exception {
		Rational r = null;
		new Rational("1/3").add(r);
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
	
	@Test(expected = IllegalArgumentException.class)
	public void testSubtractNull() throws Exception {
		String s = null;
		new Rational("1/3").subtract(s);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSubtractRationalNull() throws Exception {
		Rational r = null;
		new Rational("1/3").subtract(r);
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

	@Test(expected = IllegalArgumentException.class)
	public void testMultiplyNull() throws Exception {
		String s = null;
		new Rational("1/3").multiply(s);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMultiplyRationalNull() throws Exception {
		Rational r = null;
		new Rational("1/3").multiply(r);
	}
	
	@Test
	public void testDivide() {
		// 4/3 : 9/5 = 20/27
		Rational r1 = new Rational("4/3");
		Rational r2 = new Rational("9/5");
		assertEquals("20/27", r1.divide(r2).toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDivideNull() throws Exception {
		String s = null;
		new Rational("1/3").divide(s);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDivideRationalNull() throws Exception {
		Rational i = null;
		new Rational("1/3").divide(i);
	}

	@Test
	public void testAllTogether() {
		// -(((1/2 + 3/4) * ((5/6) / (7/8))) - 9/10) = -61/210
		assertEquals("-61/210", new Rational("1/2").add("3/4").multiply("5/6").divide("7/8").subtract("9/10").neg().toString());
	}
}
