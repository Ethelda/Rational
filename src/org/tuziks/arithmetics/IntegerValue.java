package org.tuziks.arithmetics;

import java.math.BigInteger;

public class IntegerValue implements BoxedValue<IntegerValue> {
    public BigInteger value;

    public IntegerValue() {
        this("0");
    }

    public IntegerValue(String val) {
        value = new BigInteger(val);
    }

    @Override
    public boolean isGreater(IntegerValue that) {
        return value.compareTo(that.value) > 0;
    }

    @Override
    public IntegerValue append(String str) {
        value = new BigInteger(toString() + str);
        return this;
    }

    @Override
    public String toString() {
        return value.toString(10);
    }

}
