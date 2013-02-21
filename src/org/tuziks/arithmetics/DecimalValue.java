package org.tuziks.arithmetics;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class DecimalValue implements BoxedValue<DecimalValue> {
    public boolean ds;
    public BigDecimal value;

    public DecimalValue() {
        this("0");
    }

    public DecimalValue(String val) {
        try {
            value = new BigDecimal(val);
        } catch (NumberFormatException nfe) {
            value = BigDecimal.ZERO;
        }
        ds = false;
    }

    @Override
    public boolean isGreater(DecimalValue that) {
        return value.compareTo(that.value) > 0;
    }

    @Override
    public DecimalValue append(String str) {
        appendDecimalSeparator(str);
        String ps = value.toPlainString();
        if (hasDecimalSeparator() && !(ps + str).contains("."))
            ps += ".";
        value = new BigDecimal(ps + str);
        return this;
    }

    private void appendDecimalSeparator(String str) {
        switch (StringUtils.countMatches(str, ".")) {
            case 0:
                return;
            case 1:
                if (!ds) {
                    ds = true;
                    return;
                }
        }
        throw new IllegalArgumentException("Cannot append more than one decimal separator");
    }

    public boolean hasDecimalSeparator() {
        return ds;
    }

    public String toString() {
        return value.toString();
    }
}
