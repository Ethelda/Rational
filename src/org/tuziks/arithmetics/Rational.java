package org.tuziks.arithmetics;

import java.math.BigInteger;
import static org.tuziks.arithmetics.Utils.*;

public class Rational {
	public final BigInteger numerator;
	public final BigInteger denominator;

	public Rational(String expression) {
		this(extractNumerator(expression), extractDenumerator(expression));
	}

	private static String extractNumerator(String expression) {
		if (expression == null)
			throw new IllegalArgumentException("Expression cannot be null");
		int p = expression.indexOf("/");
		return p > 0 ? expression.substring(0, p) : expression;
	}

	private static String extractDenumerator(String expression) {
		if (expression == null)
			throw new IllegalArgumentException("Expression cannot be null");
		int p = expression.indexOf("/");
		return p > 0 ? expression.substring(p + 1) : "1";
	}

	public Rational(String num, String denum) {
		this(new BigInteger(num), new BigInteger(denum));
	}

	public Rational(BigInteger numerator, BigInteger denominator) {
		if (numerator == null)
			throw new IllegalArgumentException("Numerator cannot be null");
		if (denominator == null)
			throw new IllegalArgumentException("Denominator cannot be null");
		if (denominator.compareTo(BigInteger.ZERO) == 0)
			throw new IllegalArgumentException("Denominator cannot be 0");
		BigInteger gcd = gcd(numerator, denominator);
		this.numerator = numerator.divide(gcd);
		this.denominator = denominator.divide(gcd);
	}

	public boolean isGreater(Rational r) {
		if (r == null)
			throw new IllegalArgumentException("Cannot compare to null");
		return r == null ? true : numerator.multiply(r.denominator).compareTo(r.numerator.multiply(denominator)) > 0;
	}

	public Rational neg() {
		return new Rational(numerator.multiply(new BigInteger("-1")), denominator);
	}

	public Rational add(Rational r) {
		if (r == null)
			throw new IllegalArgumentException("Cannot add null");
		return new Rational(numerator.multiply(r.denominator).add(r.numerator.multiply(denominator)), denominator.multiply(r.denominator));
	}

	public Rational subtract(Rational r) {
		if (r == null)
			throw new IllegalArgumentException("Cannot subtract null");
		return add(r.neg());
	}

	public Rational multiply(Rational r) {
		if (r == null)
			throw new IllegalArgumentException("Cannot multiply with null");
		return new Rational(numerator.multiply(r.numerator), denominator.multiply(r.denominator));
	}

	public Rational divide(Rational r) {
		if (r == null)
			throw new IllegalArgumentException("Cannot divide with null");
		return new Rational(numerator.multiply(r.denominator), denominator.multiply(r.numerator));
	}

	@Override
	public String toString() {
		String d = denominator.toString();
		return d.equals("1") ? numerator.toString() : numerator.toString() + "/" + d;
	}
}