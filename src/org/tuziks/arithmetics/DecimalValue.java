package org.tuziks.arithmetics;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class DecimalValue implements BoxedValue<DecimalValue> {

    public BigDecimal value;
    public DecimalValue(String val) {
        value = new BigDecimal(val);

    }

    @Override
    public boolean isGreater(DecimalValue that) {
        return value.compareTo(that.value) > 0;
    }

    @Override
    public DecimalValue append(String str) {
        BigDecimal v = new BigDecimal("0" + str);
        BigInteger vu = v.unscaledValue();

        long l = vu.toString().length();
        if (l > Integer.MAX_VALUE)
            throw new IllegalArgumentException("Argument too big, max length: " + (Integer.MAX_VALUE - 1));


        BigDecimal f = value.subtract(value.setScale(0, RoundingMode.FLOOR));

        // jāpievieno aiz komata, ja:
        if (f.compareTo(BigDecimal.ZERO) != 0)
        {

        }
        else
        {
            if (vu.compareTo(BigInteger.ZERO) > 0) {
                value = value
                    .multiply(new BigDecimal("1" + StringUtils.repeat("0", (int)l)).setScale(0, RoundingMode.FLOOR))
                    .add(v);
            }
        }
        return this;
    }

    public String toString() {
        return value.toString();
    }
}

