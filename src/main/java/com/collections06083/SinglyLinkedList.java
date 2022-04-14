package com.collections06083;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Stack<T>, Queue<T> {

    public static void main(String[] args) {
        var list = new SinglyLinkedList<Integer>();
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        for (var el: list) {
            System.out.println(el);
        }
    }

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
    private  Node<T> tail = head;

    private void addToHead(T value) {
        head.next = new Node<T>(value, head.next);
        size++;
    }

    private void addToTail(T value) {
    }

    private T getFromHead() {
        throwsWhenEmpty();
        var res = head.next.value;
        head.next = head.next.next;
        size--;
        if (size == 0) {
            tail = head;
        }
        return res;
    }

    private void throwsWhenEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("The collection is empty");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head.next = head;
        tail = head;
        size = 0;
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
        throwsWhenEmpty();
        return head.next.value;
    }

    @Override
    public void add(T value) {
        addToHead(value);
    }

    @Override
    public Iterator<T> iterator() {
        return new HeadToTailIterator();
    }

    private class HeadToTailIterator implements Iterator<T>{
        Node<T> cursor = head;

        @Override
        public boolean hasNext() {
            return cursor.next != head;
        }

        @Override
        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            cursor = cursor.next;
            return cursor.value;
        }
    }
}
