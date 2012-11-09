package org.tuziks.arithmetics.test;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Test;

import static org.tuziks.arithmetics.Utils.*;

public class UtilsTest {
	@Test
	public void testGcd() {
		assertEquals(new BigInteger("3"), gcd(new BigInteger("9"), new BigInteger("6")));
		assertEquals(new BigInteger("1"), gcd(new BigInteger("1"), new BigInteger("1")));
		assertEquals(new BigInteger("100"), gcd(new BigInteger("100"), new BigInteger("0")));
		assertEquals(new BigInteger("0"), gcd(new BigInteger("0"), new BigInteger("0")));
		assertEquals(new BigInteger("5"), gcd(new BigInteger("-10"), new BigInteger("-5")));
	}

}
