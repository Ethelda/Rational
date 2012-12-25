package org.tuziks.arithmetics;

import java.math.BigInteger;

public class IntegerValue implements BoxedValue<IntegerValue> {
    public BigInteger value;
    public IntegerValue(String val) {
        value = new BigInteger(val);
    }

    @Override
    public boolean isGreater(IntegerValue that) {
        return value.compareTo(that.value) > 0;
    }
}
