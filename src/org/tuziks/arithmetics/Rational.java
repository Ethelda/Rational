package org.tuziks.arithmetics;

import java.math.BigInteger;

import static org.tuziks.arithmetics.Utils.*;

public class Rational {
	public final BigInteger numerator;
	public final BigInteger denominator;

	public Rational(String num) {
		this(extractNumerator(num), extractDenumerator(num));
	}

	private static String extractNumerator(String num) {
		int p = num.indexOf("/");
		return p > 0 ? num.substring(0, p) : num;
	}

	private static String extractDenumerator(String num) {
		int p = num.indexOf("/");
		return p > 0 ? num.substring(p + 1) : "1";
	}

	public Rational(String num, String denum) {
		this(new BigInteger(num), new BigInteger(denum));
	}

	public Rational(BigInteger num, BigInteger denom) {
		if (denom.compareTo(BigInteger.ZERO) == 0)
			throw new IllegalArgumentException("Denominator cannot be 0");
		BigInteger gcd = gcd(num, denom);
		this.numerator = num.divide(gcd);
		this.denominator = denom.divide(gcd);
	}

	public boolean isGreater(Rational r) {
		return numerator.multiply(r.denominator).compareTo(
				r.numerator.multiply(denominator)) > 0;
	}

	public Rational neg() {
		return new Rational(numerator.multiply(new BigInteger("-1")),
				denominator);
	}

	public Rational add(Rational r) {
		return new Rational(numerator.multiply(r.denominator).add(
				r.numerator.multiply(denominator)),
				denominator.multiply(r.denominator));
	}

	public Rational subtract(Rational r) {
		return add(r.neg());
	}

	public Rational multiply(Rational r) {
		return new Rational(numerator.multiply(r.numerator),
				denominator.multiply(r.denominator));
	}

	public Rational divide(Rational r) {
		return new Rational(numerator.multiply(r.denominator),
				denominator.multiply(r.numerator));
	}

	@Override
	public String toString() {
		String d = denominator.toString();
		return d.equals("1") ? numerator.toString() : numerator.toString()
				+ "/" + d;
	}
}