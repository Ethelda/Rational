package org.tuziks.arithmetics;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.math.BigDecimal;

public class DecimalValue implements BoxedValue<DecimalValue> {
    public BigDecimal value;
    public DecimalValue(String val) {
        value = new BigDecimal(val);
    }

    @Override
    public boolean isGreater(DecimalValue that) {
        return value.compareTo(that.value) > 0;
    }
}
