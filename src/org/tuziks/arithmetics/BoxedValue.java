package org.tuziks.arithmetics;

public interface BoxedValue<T> {
    boolean isGreater(T that);
    T append(String str);

    @Override
    String toString();
}
