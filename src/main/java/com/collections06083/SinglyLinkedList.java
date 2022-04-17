package com.collections06083;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Stack<T>, Queue<T> {

    public static void main(String[] args) {
        var list = new SinglyLinkedList<Integer>();
        list.enqueue(0);
        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);


        var size = list.size();
        for (var i = 0; i < size; i++) {
            System.out.println(list.dequeue());
        }

        System.out.println();
        list.enqueue(0);
        list.enqueue(1);
        list.enqueue(2);
        list.enqueue(3);
        list.reverse();
        size = list.size();
        for (var i = 0; i < size; i++) {
            System.out.println(list.dequeue());
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
    private final Node<T> head = new Node<>();
    private Node<T> tail = head;

    private void addToHead(T value) {
        head.next = new Node<>(value, head.next);
        if (size == 0) {
            tail = head.next;
        }
        size++;
    }

    private void addToTail(T value) {
        var next = tail;
        tail = new Node<>(value, head);
        next.next = tail;
        size++;
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

    private class HeadToTailIterator implements Iterator<T> {
        Node<T> cursor = head;
        Node<T> prev = head;
        private boolean flagNextByCall = false;

        @Override
        public boolean hasNext() {
            return cursor.next != head;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            prev = cursor;
            cursor = cursor.next;
            flagNextByCall = true;
            return cursor.value;
        }

        @Override
        public void remove() {
            if (!flagNextByCall) {
                throw new IllegalStateException("remove");
            }
            flagNextByCall = false;

            prev.next =  cursor.next;
            cursor = prev.next;
            size--;
        }
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }

        var cursor = head.next;
        var prev = head;
        var next = cursor.next;

        do {
            cursor.next = prev;
            prev = cursor;
            cursor = next;
            next = cursor.next;
        } while (cursor != head);
        head.next = prev;
    }

    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("Index value is out of range");
        }

        int i = 0;
        var h = head;
        while (i != index) {
            h = h.next;
            i++;
        }
        h.next = h.next.next;
        size--;
    }
}
