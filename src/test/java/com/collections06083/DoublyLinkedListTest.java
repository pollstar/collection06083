package com.collections06083;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    DoublyLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    @DisplayName("Test size list after adding element in list to first")
    void addFirst1() {
        assertEquals(0, list.size());
        list.addFirst("1");
        assertEquals(1, list.size());
        list.addFirst("2");
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("Test addFirst and getFirst")
    void addFirst2() {
        String[] elements = new String[]{"#1", "#2", "#3", "#4"};
        for (var el : elements) {
            list.addFirst(el);
        }

        for (var i = elements.length - 1; i >= 0; --i) {
            assertEquals(list.getFirst(), elements[i]);
            assertEquals(list.size(), i);
        }
    }

    @Test
    @DisplayName("Test size list after adding element in list to last")
    void addLast1() {
        assertEquals(0, list.size());
        list.addLast("1");
        assertEquals(1, list.size());
        list.addLast("2");
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("Test addLast and getFirst")
    void addLast2() {
        String[] elements = new String[]{"#1", "#2", "#3", "#4"};
        for (var el : elements) {
            list.addLast(el);
        }

        for (var el : elements) {
            assertEquals(list.getFirst(), el);
        }
    }

    @Test
    @DisplayName("Test size after getLast")
    void getFirst() {
        list.addFirst("1");
        list.addFirst("2");

        int size = list.size();
        list.getLast();
        assertEquals(list.size(), --size);
        list.getLast();
        assertEquals(list.size(), --size);
    }


    @Test
    @DisplayName("Test getLast after addFirst")
    void getLast1() {
        String[] elements = new String[]{"#1", "#2", "#3", "#4"};
        for (var el : elements) {
            list.addFirst(el);
        }

        for (var el : elements) {
            assertEquals(list.getLast(), el);
        }
    }

    @Test
    @DisplayName("Test addLast and getLast")
    void addLast3() {
        String[] elements = new String[]{"#1", "#2", "#3", "#4"};
        for (var el : elements) {
            list.addLast(el);
        }

        for (var i = elements.length - 1; i >= 0; --i) {
            assertEquals(list.getLast(), elements[i]);
            assertEquals(list.size(), i);
        }
    }

    @Test
    void peekFirst() {
    }

    @Test
    void peekLast() {
    }

    @Test
    void size() {
    }
}