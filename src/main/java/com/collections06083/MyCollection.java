package com.collections06083;

public interface MyCollection<T> extends Iterable<T> {
    void add(T value);
    int size();
    void clear();

    default boolean isEmpty(){
        return size() == 0;
    }
}
