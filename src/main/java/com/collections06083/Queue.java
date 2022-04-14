package com.collections06083;

public interface Queue<T> extends MyCollection<T>{
    void enqueue(T value);
    T dequeue();

    @Override
    default void add(T value) {
        enqueue(value);
    }
}
