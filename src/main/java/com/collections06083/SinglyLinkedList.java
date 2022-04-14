package com.collections06083;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Stack<T>, Queue<T> {

    private static class Node<V> {
        V value;
        Node<V> next;

        public Node() {
            next = this;
        }

        public Node(V value, Node<V> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int size = 0;
    private final Node<T> head = new Node<T>();

    private void addToHead(T value) {
        head.next = new Node<T>(value, head.next);
        size++;
    }

    private void addToTail(T value) {}

    private T getFromHead(){
        return null;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        // TODO:
    }

    @Override
    public void enqueue(T value) {
        addToTail(value);
    }

    @Override
    public T dequeue() {
        return getFromHead();
    }

    @Override
    public void push(T value) {
        addToHead(value);
    }

    @Override
    public T pop() {
        return getFromHead();
    }

    @Override
    public T peek() {
        // TODO:
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void add(T value) {
        // TODO:
    }
}
