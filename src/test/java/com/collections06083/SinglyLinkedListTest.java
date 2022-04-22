package com.collections06083;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    SinglyLinkedList<String> list;

    @BeforeEach
    void setUp() {
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
        for (var el : arr) {
            list.enqueue(el);
        }
        assertEquals(list.size(), arr.length);
        list.enqueue("4");
        assertEquals(list.size(), arr.length + 1);
    }

    @Test
    @DisplayName("Test elements enqueue dequeue")
    void enqueue2() {
        String[] arr = {"1", "2", "3", "4"};
        for (var el : arr) {
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
        for (var el : arr) {
            list.enqueue(el);
        }
        list.dequeue();
        assertEquals(list.size(), arr.length - 1);
        list.dequeue();
        assertEquals(list.size(), arr.length - 2);
    }

    @Test
    @DisplayName("Test list is empty after dequeue ")
    void dequeue2() {
        String[] arr = {"1", "2", "3", "4"};
        for (var el : arr) {
            list.enqueue(el);
        }
        var size = list.size();
        for (int i = 0; i < size; i++) {
            list.dequeue();
        }
        assertTrue(list.isEmpty());
    }

    @Test
    void push1() {
        String element = "#1";
        list.push(element);

        assertEquals(element, list.peek());
    }

    @Test
    @DisplayName("Test size after push three elements")
    void push2() {
        String[] elements = {"#1", "#2", "#3"};
        for (var el : elements) {
            list.push(el);
        }
        assertEquals(elements.length, list.size());
    }

    @Test
    void pop2() {
        String[] elements = {"#1", "#2", "#3"};
        for (var el : elements) {
            list.push(el);
        }

        assertEquals(elements[elements.length - 1], list.pop());
        assertEquals(elements.length - 1, list.size());
    }

    @Test
    @DisplayName("Test push - pop")
    void pop3() {
        String[] elements = {"#1", "#2", "#3"};
        for (var el : elements) {
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
        var exception = assertThrows(NoSuchElementException.class, () -> list.peek());
        assertEquals("The collection is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test exception after peek when list is not empty")
    void peek5() {
        list.push("1");
        assertDoesNotThrow(() -> {
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

    @Test
    @DisplayName("Test reverse with elements")
    void reverse1() {
        List<String> elements = List.of("#1", "#2", "#3");
        for (var el : elements) {
            list.push(el);
        }
        list.reverse();
        int count = 0;
        for (Iterator<String> it1 = elements.iterator(), it2 = list.iterator();
             it1.hasNext() && it2.hasNext();
        ) {
            count++;
            assertEquals(it1.next(), it2.next());
        }
        assertEquals(elements.size(), count);
        assertEquals(elements.size(), list.size());
    }

    @Test
    @DisplayName("Test reverse empty item")
    void reverse2() {
        list.reverse();
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Test reverse list with one item")
    void reverse3() {
        String s = "#1";
        list.enqueue(s);
        list.reverse();
        assertEquals(1, list.size());
        assertEquals(s, list.dequeue());
    }

    @Test
    @DisplayName("Remove from empty list")
    void remove1() {
        var exception = assertThrows(IllegalArgumentException.class, () -> list.remove(0));
        assertEquals("Index value is out of range", exception.getMessage());
    }

    @Test
    @DisplayName("Remove element")
    void remove2() {
        List<String> elements = List.of("#1", "#2", "#3");
        for (var el : elements) {
            list.push(el);
        }
        list.remove(1);
        assertEquals(elements.get(2), list.pop());
        assertEquals(elements.get(0), list.pop());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Remove element with index 0")
    void remove3() {
        List<String> elements = List.of("#1", "#2", "#3");
        for (var el : elements) {
            list.push(el);
        }
        list.remove(0);
        assertEquals(elements.get(1), list.pop());
        assertEquals(elements.get(0), list.pop());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Remove last element")
    void remove4() {
        List<String> elements = List.of("#1", "#2", "#3");
        for (var el : elements) {
            list.push(el);
        }
        list.remove(list.size() - 1);
        assertEquals(elements.get(2), list.pop());
        assertEquals(elements.get(1), list.pop());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Remove one element over iterator ")
    void remove_Iterator1() {
        List<String> elements = List.of("#1", "#2", "#3");
        for (var el : elements) {
            list.push(el);
        }

        String s = new String();
        for (var el = list.iterator(); el.hasNext(); ) {
            s = el.next();
            if (s.equals(elements.get(1))) {
                el.remove();
            }
        }

        assertEquals(2, list.size());
        assertEquals(elements.get(2), list.pop());
        assertEquals(elements.get(0), list.pop());
        assertEquals(0, list.size());
    }


    @Test
    @DisplayName("Remove some elements over iterator ")
    void remove_Iterator5() {
        List<String> elements = List.of("#1", "#2", "#3");
        for (var el : elements) {
            list.push(el);
        }

        String s = new String();
        for (var el = list.iterator(); el.hasNext(); ) {
            s = el.next();
            if (s.equals(elements.get(1)) || s.equals(elements.get(2))) {
                el.remove();
            }
        }

        assertEquals(1, list.size());
        assertEquals(elements.get(0), list.pop());
        assertEquals(0, list.size());
    }


    @Test
    @DisplayName("Remove odd Integer elements over iterator ")
    void remove_Iterator6() {
        SinglyLinkedList<Integer> elements = new SinglyLinkedList<>();
        for (int i = 0; i < 20; i++) {
            elements.push(i);
        }
        int size = elements.size();

        for (var el = elements.iterator(); el.hasNext(); ) {
            if (el.next() % 2 != 0) {
                el.remove();
            }
        }

        for (var el : elements) {
            System.out.println(el);
            assertTrue(el % 2 == 0);
        }

        assertEquals(elements.size(), size / 2);
    }

    @Test
    @DisplayName("Remove element over iterator with one element")
    void remove_Iterator2() {
        String el = "#1";
        list.push(el);

        String s = new String();
        for (var l = list.iterator(); l.hasNext(); ) {
            s = l.next();
            if (s.equals(el)) {
                l.remove();
            }
        }

        assertEquals(0, list.size());
        var exception = assertThrows(NoSuchElementException.class, () -> list.pop());
        assertEquals("The collection is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test throw IllegalStateException")
    void remove_Iterator3() {
        String el = "#1";
        list.push(el);

        var l = list.iterator();

        assertEquals(1, list.size());
        var exception = assertThrows(IllegalStateException.class, () -> l.remove());
        assertEquals("remove", exception.getMessage());
    }

    @Test
    @DisplayName("Test throw IllegalStateException for remove in iterator")
    void remove_Iterator4() {
        list.push("1");
        list.pop();
        var l = list.iterator();

        assertEquals(0, list.size());
        var exception = assertThrows(IllegalStateException.class, () -> l.remove());
        assertEquals("remove", exception.getMessage());
    }
}