package com.collections06083;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Deque<T> {
    private static class Node<V> {
        V value;
        Node<V> next;
        Node<V> prev;

        public Node() {
            next = this;
            prev = this;
        }

        public Node(V value, Node<V> next, Node<V> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private final Node<T> head = new Node<>();
    private int size = 0;

    @Override
    public void addFirst(T value) {
        var oldFirst = head.next;
        var newFirst = new Node<>(value, oldFirst, head);
        head.next = newFirst;
        oldFirst.prev = newFirst;
        size++;
    }

    @Override
    public void addLast(T value) {
        var oldLast = head.prev;
        var newLast = new Node<>(value, head, oldLast);
        head.prev = newLast;
        oldLast.next = newLast;
        size++;
    }

    @Override
    public T getFirst() {
        throwsWhenEmpty();
        var firstNode = head.next;
        var secondNode = firstNode.next;

        head.next = secondNode;
        secondNode.prev = head;

        size--;
        return firstNode.value;
    }

    @Override
    public T getLast() {
        throwsWhenEmpty();

        var secondNode = head.prev;
        var firstNode = secondNode.prev;

        head.prev = firstNode;
        firstNode.next = head;

        size--;
        return secondNode.value;
    }

    @Override
    public T peekFirst() {
        throwsWhenEmpty();
        return head.next.value;
    }

    @Override
    public T peekLast() {
        throwsWhenEmpty();
        return head.prev.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        head.next = head;
        head.prev = head;
    }

    @Override
    public ListIterator<T> iterator() {
        return new DirectIterator();
    }

    public ListIterator<T> reverseIterator() {
        return new ReverseIterator();
    }

    private class DirectIterator implements ListIterator<T> {
        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public T previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }

    private class ReverseIterator implements ListIterator<T> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public T previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }

    public void reverse() {
        throwsWhenEmpty();

        var cursor = head;
        var next = cursor.next;
        var prev = cursor.prev;

        do {
            cursor.prev = next;
            cursor.next = prev;
            cursor = next;
            next = cursor.next;
            prev = cursor.prev;
        } while (cursor != head);
    }

    private void throwsWhenEmpty() {
        if (size == 0) {
            throw new NoSuchElementException("The collection is empty");
        }
    }
}