package com.collections06083;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CustomHashMapTest {
    CustomHashMap<Integer, Integer> map;

    @BeforeEach
    void init() {
        map = new CustomHashMap<>();
    }

    @Test
    void size() {
        assertEquals(0, map.size());

        int count = 100;
        for (var i = 0; i < count; i++) {
            map.put(i, i);
        }
        assertEquals(count, map.size());

        for (var i = count; i < count + 100; i++) {
            map.put(i, i);
        }
        assertEquals(count + 100, map.size());
    }

    @Test
    void put() {
        for (var i = 0; i < 100; i++) {
            map.put(i, i);
        }

        for (var i = 0; i < 100; i++) {
            assertEquals(i, map.get(i));
        }
    }

    @Test
    void get() {
        for (var i = 0; i < 100; i++) {
            map.put(i, i);
        }

        for (var i = 101; i < 200; i++) {
            assertNull(map.get(i));
        }
    }

    @Test
    void contains() {
        for (var i = 0; i < 100; i++) {
            map.put(i, i);
        }

        for (var i = 0; i < 100; i++) {
            assertTrue(map.contains(i));
        }

        for (var i = 101; i < 200; i++) {
            assertFalse(map.contains(i));
        }
    }

    @Test
    void remove() {
        for (var i = 0; i < 100; i++) {
            map.put(i, i);
        }

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                map.remove(i);
            }
        }

        for (var i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                assertFalse(map.contains(i));
            }
            if (i % 2 != 0) {
                assertTrue(map.contains(i));
            }
        }

        for (var i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                assertNull(map.get(i));
            }
        }
    }

    @Test
    void getEntry() {
    }

    @Test
    void iterator() {
    }
}