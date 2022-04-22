package com.collections06083;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

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
    @DisplayName("Test peekFirst")
    void peekFirst() {
        String[] elements = new String[]{"#1", "#2", "#3", "#4"};
        for (var el : elements) {
            list.addFirst(el);
        }
        assertEquals(list.peekFirst(), elements[elements.length - 1]);
    }


    @Test
    @DisplayName("Test peekLast after adding elements")
    void peekLast2() {
        String[] elements = new String[]{"#1", "#2", "#3", "#4"};
        for (var el : elements) {
            list.addFirst(el);
        }
        assertEquals(list.peekLast(), elements[0]);
    }

    @Test
    @DisplayName("Test throw in empty list for peekFirst")
    void peekFirstEmptyList() {
        assertEquals(0, list.size());
        var exception = assertThrows(NoSuchElementException.class, () -> list.peekFirst());
        assertEquals("The collection is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test peekLast with empty list")
    void peekLast() {
        assertEquals(0, list.size());
        var exception = assertThrows(NoSuchElementException.class, () -> list.peekLast());
        assertEquals("The collection is empty", exception.getMessage());
    }

    @Test
    void size() {
    }


    @Test
    @DisplayName("Test reverse DoublyLinkedList")
    void reverse1() {
        String[] elements = new String[]{"#1", "#2", "#3", "#4"};
        for (var el : elements) {
            list.addFirst(el);
        }

        list.reverse();

        for (var el : elements) {
            assertEquals(list.getFirst(), el);
        }
    }

    @Test
    @DisplayName("Test double reverse DoublyLinkedList")
    void reverse2() {
        String[] elements = new String[]{"#1", "#2", "#3", "#4"};
        for (var el : elements) {
            list.addFirst(el);
        }

        list.reverse();
        list.reverse();

        for (var el : elements) {
            assertEquals(list.getLast(), el);
        }
    }

    @Test
    @DisplayName("Test reverse DoublyLinkedList with one element")
    void reverse3() {
        String el = "1";
        list.addFirst(el);

        list.reverse();
        assertEquals(list.getFirst(), el);
    }

    @Test
    @DisplayName("Test peek after reverse DoublyLinkedList")
    void reverse4() {
        String[] elements = new String[]{"#1", "#2", "#3", "#4"};
        for (var el : elements) {
            list.addFirst(el);
        }

        list.reverse();

        assertEquals(list.peekFirst(), elements[0]);
        assertEquals(list.peekLast(), elements[elements.length - 1]);
    }

    @Test
    @DisplayName("Test reverse empty DoublyLinkedList ")
    void reverse5() {
        var exception = assertThrows(NoSuchElementException.class, () -> list.reverse());
        assertEquals("The collection is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test hasNext for iterator with empty list")
    void iterator_hasNext1() {
        assertFalse(list.iterator().hasNext());
    }

    @Test
    @DisplayName("Test hasNext for iterator one elements")
    void iterator_hasNext2() {
        list.addFirst("1");
        assertTrue(list.iterator().hasNext());
    }

    @Test
    @DisplayName("Test hasNext for iterator some elements")
    void iterator_hasNext3() {
        list.addFirst("1");
        list.addFirst("1");
        assertTrue(list.iterator().hasNext());
    }

    @Test
    @DisplayName("Test hasNext for iterator after removing elements")
    void iterator_hasNext4() {
        list.addFirst("1");
        assertTrue(list.iterator().hasNext());
        list.getFirst();
        assertFalse(list.iterator().hasNext());
    }

    @Test
    @DisplayName("Test hasPrevious for iterator with empty list")
    void iterator_hasPrevious1() {
        assertFalse(list.iterator().hasPrevious());
    }

    @Test
    @DisplayName("Test hasPrevious for iterator one elements")
    void iterator_hasPrevious2() {
        list.addFirst("1");
        assertTrue(list.iterator().hasPrevious());
    }

    @Test
    @DisplayName("Test hasPrevious for iterator some elements")
    void iterator_hasPrevious3() {
        list.addFirst("1");
        list.addFirst("1");
        assertTrue(list.iterator().hasPrevious());
    }


    @Test
    @DisplayName("Test hasPrevious for iterator after removing elements")
    void iterator_hasPrevious4() {
        list.addFirst("1");
        assertTrue(list.iterator().hasPrevious());
        list.getFirst();
        assertFalse(list.iterator().hasPrevious());
    }

    @Test
    @DisplayName("Test next for iterator for empty list")
    void iterator_next1() {
        var exception = assertThrows(NoSuchElementException.class, () -> list.iterator().next());
        assertEquals("The collection is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test next for iterator for list with elements")
    void iterator_next2() {
        List<String> elements = List.of("#1", "#2", "#3", "#4");
        for (var el: elements) {
            list.addLast(el);
        }

        var it2 = list.iterator();
        for (Iterator<String>  it1 = elements.iterator();
                            it1.hasNext() && it2.hasNext();) {
            assertEquals(it1.next(), it2.next());
        }
        var exception = assertThrows(NoSuchElementException.class, () -> it2.next());
        assertEquals("No next element", exception.getMessage());
    }

    @Test
    @DisplayName("Test previous for iterator for empty list")
    void iterator_previous1() {
        var exception = assertThrows(NoSuchElementException.class, () -> list.iterator().next());
        assertEquals("The collection is empty", exception.getMessage());
    }

    @Test
    @DisplayName("Test previous for iterator for list with elements")
    void iterator_previous2() {
        List<String> elements = List.of("#1", "#2", "#3", "#4");
        for (var el: elements) {
            list.addFirst(el);
        }

        var it2 = list.iterator();
        for (Iterator<String>  it1 = elements.iterator();
             it1.hasNext() && it2.hasPrevious();) {
            assertEquals(it1.next(), it2.previous());
        }
        var exception = assertThrows(NoSuchElementException.class, () -> it2.previous());
        assertEquals("No previous element", exception.getMessage());
    }
}