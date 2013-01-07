package org.tuziks.arithmetics;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    @Override
    public IntegerValue append(String str) {
        throw new NotImplementedException();
    }

    @Override
    public String toString() {
        throw new NotImplementedException();
    }


}
