package org.tuziks.arithmetics;

import java.math.BigInteger;

import static org.tuziks.arithmetics.Utils.gcd;
import static org.tuziks.arithmetics.Utils.notNull;

public class RationalValue implements BoxedValue<RationalValue> {
    public final BigInteger numerator;
    public final BigInteger denominator;
    private static final int NUMERATOR = 0;
    private static final int DENOMINATOR = 1;

    public RationalValue() {
        this("");
    }

    public RationalValue(String expression) {
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

    public RationalValue(String numerator, String denominator) {
        this(new BigInteger(numerator), new BigInteger(denominator));
    }

    public RationalValue(BigInteger numerator, BigInteger denominator) {
        notNull(numerator, "Numerator cannot be null");
        notNull(denominator, "Denominator cannot be null");
        if (denominator.compareTo(BigInteger.ZERO) == 0)
            throw new IllegalArgumentException("Denominator cannot be 0");
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    @Override
    public boolean isGreater(RationalValue r) {
        notNull(r, "Cannot compare to null");
        return r == null ? true : numerator.multiply(r.denominator).compareTo(r.numerator.multiply(denominator)) > 0;
    }

    public boolean isGreater(String expression) {
        return isGreater(new RationalValue(expression));
    }

    public RationalValue neg() {
        return new RationalValue(numerator.multiply(new BigInteger("-1")), denominator);
    }

    public RationalValue add(RationalValue r) {
        notNull(r, "Cannot add null");
        return new RationalValue(numerator.multiply(r.denominator).add(r.numerator.multiply(denominator)), denominator.multiply(r.denominator));
    }

    public RationalValue add(String expression) {
        return add(new RationalValue(expression));
    }

    public RationalValue subtract(RationalValue r) {
        notNull(r, "Cannot subtract null");
        return add(r.neg());
    }

    public RationalValue subtract(String expression) {
        return subtract(new RationalValue(expression));
    }

    public RationalValue multiply(RationalValue r) {
        notNull(r, "Cannot multiply with null");
        return new RationalValue(numerator.multiply(r.numerator), denominator.multiply(r.denominator));
    }

    public RationalValue multiply(String expression) {
        return multiply(new RationalValue(expression));
    }

    public RationalValue divide(RationalValue r) {
        notNull(r, "Cannot divide with null");
        return new RationalValue(numerator.multiply(r.denominator), denominator.multiply(r.numerator));
    }

    public RationalValue divide(String expression) {
        return divide(new RationalValue(expression));
    }

    @Override
    public RationalValue append(String str) {


        return this;
    }

    @Override
    public String toString() {
        String d = denominator.toString();
        return d.equals("1") ? numerator.toString() : numerator.toString() + "/" + d;
    }
}