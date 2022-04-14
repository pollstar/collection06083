package com.collections06083;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Test size for list is empty")
    void size1() {
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Test size for push list ")
    void size2() {
        list.push("1");
        list.push("1");
        assertEquals(2, list.size());
        assertNotEquals(1, list.size());
        assertNotEquals(0, list.size());
    }

    @Test
    @DisplayName("Test size for pop from list ")
    void size3() {
        list.push("1");
        list.push("1");
        list.pop();
        assertEquals(1, list.size());
        assertNotEquals(2, list.size());
    }

    @Test
    @DisplayName("Test size after to clear list")
    void clear1() {
        list.push("1");
        list.push("1");
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Test empty after to clear list")
    void clear2() {
        list.push("1");
        list.push("1");
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Test size after enqueue ")
    void enqueue1() {
        String[] arr = {"1", "2", "3", "4"};
        for (var el: arr) {
            list.enqueue(el);
        }
        assertEquals(list.size(), arr.length);
        list.enqueue("4");
        assertEquals(list.size(), arr.length+1);
    }

    @Test
    @DisplayName("Test elements enqueue dequeue")
    void enqueue2() {
        String[] arr = {"1", "2", "3", "4"};
        for (var el: arr) {
            list.enqueue(el);
        }
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.dequeue(), arr[i]);
        }
    }

    @Test
    @DisplayName("Test size after dequeue ")
    void dequeue() {
        String[] arr = {"1", "2", "3", "4"};
        for (var el: arr) {
            list.enqueue(el);
        }
        list.dequeue();
        assertEquals(list.size(), arr.length-1);
        list.dequeue();
        assertEquals(list.size(), arr.length-2);
    }

    @Test
    @DisplayName("Test list is empty after dequeue ")
    void dequeue2() {
        String[] arr = {"1", "2", "3", "4"};
        for (var el: arr) {
            list.enqueue(el);
        }
        var size = list.size();
        for (int i = 0; i < size; i++) {
            list.dequeue();
        }
        assertTrue(list.isEmpty());
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
    @DisplayName("Test push - pop")
    void pop3() {
        String[] elements = {"#1", "#2", "#3"};
        for (var el: elements) {
            list.push(el);
        }

        String[] test = new String[list.size()];

        int i = list.size();
        for (var el : list) {
            test[--i] = el;
        }
        assertArrayEquals(elements, test);
    }

    @Test
    @DisplayName("Test peek after push one element")
    void peek1() {
        String element = "#1";
        list.push(element);

        assertEquals(element, list.peek());
    }

    @Test
    @DisplayName("Test peek after push several element")
    void peek2() {
        String[] elements = {"#1", "#2", "#3", "#4"};
        for (var el : elements) {
            list.push(el);
        }

        var test = list.peek();
        assertEquals("#4", list.peek());
    }

    @Test
    @DisplayName("Test peek after push several element and one pop")
    void peek3() {
        String[] elements = {"#1", "#2", "#3", "#4"};
        for (var el : elements) {
            list.push(el);
        }
        list.pop();
        var test = list.peek();
        assertEquals("#3", list.peek());
    }

    @Test
    @DisplayName("Test exception after peek when list is empty")
    void peek4() {
        var exception = assertThrows(NoSuchElementException.class,()-> list.peek());
        assertEquals("The collection is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test exception after peek when list is not empty")
    void peek5() {
        list.push("1");
        assertDoesNotThrow(()->{
            list.peek();
        });
    }

    @Test
    void iterator() {
    }

    @Test
    void iteratorTest() {
    }

    @Test
    void add() {
    }
}