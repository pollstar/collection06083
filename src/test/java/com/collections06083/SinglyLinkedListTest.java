package com.collections06083;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    SinglyLinkedList<String> list;

    @BeforeEach
    void setUp () {
        list = new SinglyLinkedList<>();
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
    }

    @Test
    void enqueue() {
    }

    @Test
    void dequeue() {
    }

    @Test
    void push() {
        String element = "#1";
        list.push(element);

        assertEquals(element, list.peek());
    }

    @Test
    void pop() {
        String[] elements = {"#1", "#2", "#3"};
        for (var el: elements) {
            list.push(el);
        }
        assertEquals(elements.length, list.size());
    }

    @Test
    void pop2() {
        String[] elements = {"#1", "#2", "#3"};
        for (var el: elements) {
            list.push(el);
        }

        assertEquals(elements[elements.length-1], list.pop());
        assertEquals(elements.length-1, list.size());
    }

    @Test
    void peek() {
    }

    @Test
    void peek2() {
        var exception = assertThrows(NoSuchElementException.class,()->{
            list.peek();
        });
        assertEquals("The collection is empty", exception.getMessage());
    }

    @Test
    void iterator() {
    }

    @Test
    void add() {
    }
}