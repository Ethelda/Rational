package org.tuziks.arithmetics;

import java.math.BigInteger;

import static org.tuziks.arithmetics.Utils.gcd;
import static org.tuziks.arithmetics.Utils.notNull;

public class Rational implements AritmeticalType<Rational> {
    public final BigInteger numerator;
    public final BigInteger denominator;
    private static final int NUMERATOR = 0;
    private static final int DENOMINATOR = 1;

    public Rational(String expression) {
        this(rationalPartFrom(expression, NUMERATOR), rationalPartFrom(expression, DENOMINATOR));
    }

    private static String rationalPartFrom(String expression, int part) {
        notNull(expression, "Expression cannot be null");
        int p = expression.indexOf("/");
        switch (part) {
            case NUMERATOR:
                return p > 0 ? expression.substring(0, p) : expression;
            case DENOMINATOR:
                return p > 0 ? expression.substring(p + 1) : "1";
            default:
                throw new IllegalArgumentException("Unknown part type");
        }
    }

    public Rational(String numerator, String denominator) {
        this(new BigInteger(numerator), new BigInteger(denominator));
    }

    public Rational(BigInteger numerator, BigInteger denominator) {
        notNull(numerator, "Numerator cannot be null");
        notNull(denominator, "Denominator cannot be null");
        if (denominator.compareTo(BigInteger.ZERO) == 0)
            throw new IllegalArgumentException("Denominator cannot be 0");
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    public boolean isGreater(Rational r) {
        notNull(r, "Cannot compare to null");
        return r == null ? true : numerator.multiply(r.denominator).compareTo(r.numerator.multiply(denominator)) > 0;
    }

    public boolean isGreater(String expression) {
        return isGreater(new Rational(expression));
    }

    public Rational neg() {
        return new Rational(numerator.multiply(new BigInteger("-1")), denominator);
    }

    public Rational add(Rational r) {
        notNull(r, "Cannot add null");
        return new Rational(numerator.multiply(r.denominator).add(r.numerator.multiply(denominator)), denominator.multiply(r.denominator));
    }

    public Rational add(String expression) {
        return add(new Rational(expression));
    }

    public Rational subtract(Rational r) {
        notNull(r, "Cannot subtract null");
        return add(r.neg());
    }

    public Rational subtract(String expression) {
        return subtract(new Rational(expression));
    }

    public Rational multiply(Rational r) {
        notNull(r, "Cannot multiply with null");
        return new Rational(numerator.multiply(r.numerator), denominator.multiply(r.denominator));
    }

    public Rational multiply(String expression) {
        return multiply(new Rational(expression));
    }

    public Rational divide(Rational r) {
        notNull(r, "Cannot divide with null");
        return new Rational(numerator.multiply(r.denominator), denominator.multiply(r.numerator));
    }

    public Rational divide(String expression) {
        return divide(new Rational(expression));
    }

    @Override
    public String toString() {
        String d = denominator.toString();
        return d.equals("1") ? numerator.toString() : numerator.toString() + "/" + d;
    }
}