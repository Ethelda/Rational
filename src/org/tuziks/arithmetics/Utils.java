package org.tuziks.arithmetics;

import java.math.BigInteger;

public class Utils {

	public static BigInteger gcd(BigInteger a, BigInteger b) {
		BigInteger t;
		a = a.abs();
		b = b.abs();
		if (a.compareTo(b) > 0) {
			t = b;
			b = a;
			a = t;
		}
		while (b.compareTo(BigInteger.ZERO) != 0) {
			t = a.mod(b);
			a = b;
			b = t;
		}
		return a;
	}
	
	public static <T> void notNull(T value, String message) {
		if (value == null)
			throw new IllegalArgumentException(message);
	}
}
