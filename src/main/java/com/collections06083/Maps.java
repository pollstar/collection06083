package com.collections06083;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Maps {
    public static void main(String[] args) {
        Map<String, Integer> map = new CustomHashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("2", 22);
        for (var entry : map) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println(map.get("3"));
        System.out.println(map.contains("4"));

        map.remove("3");
        for (var entry : map) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println(map.get("3"));
        System.out.println(map.contains("4"));
    }
}

interface Entry<K, V> {
    K getKey();
    V getValue();
}

interface Map<K, V> extends Iterable<Entry<K, V>> {
    int size();
    default boolean isEmpty() { return size() == 0; }
    V put(K key, V value);
    V get(K key);
    boolean contains(K key);
    V remove(K key);

    Iterator<Entry<K, V>> iterator();
}

class CustomHashMap<K, V> implements Map<K, V> {
    private static int INITIAL_CAPACITY = 8;
    private int size = 0;
    private Node<K, V>[] bins = new Node[INITIAL_CAPACITY];

    @Override
    public int size() {
        return size;
    }

    @Override
    public V put(K key, V value) {
        var entry = getNode(key);
        if (entry != null) {
            var res = entry.getValue();
            entry.setValue(value);
            return res;
        }
        addNode(new Node(key, value));
        return null;
    }

    private void addNode(Node node) {
        size++;
        int bin = getBin(node.hash);
        node.next = bins[bin];
        bins[bin] = node;
    }

    @Override
    public V get(K key) {
        var entry = getEntry(key);
        return entry != null ? entry.getValue() : null;
    }

    @Override
    public boolean contains(K key) {
        return getEntry(key) != null;
    }

    @Override
    public V remove(K key) {
        int hash = key.hashCode();
        int bin = getBin(hash);
        var node = bins[bin];
        var prev = node;

        while (node != null) {
            if (node.hash == hash && node.key.equals(key)) {
                V v = node.getValue();
                if (node == prev) {
                    bins[bin] = null;
                } else {
                    prev.next = node.next;
                }
                size--;
                return v;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    private Node<K, V> getNode(K key) {
        int hash = key.hashCode();
        int bin = getBin(hash);
        var node = bins[bin];

        while (node != null) {
            if (node.hash == hash && node.key.equals(key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private int getBin(int hash) {
        return hash % bins.length;
    }

    public Entry<K, V> getEntry(K key) {
        return getNode(key);
    }

    private static class Node<K1, V1> implements Entry<K1, V1>{
        final int hash;
        final K1 key;
        V1 value;
        Node<K1, V1> next;

        public Node(K1 key, V1 value) {
            this.key = key;
            this.value = value;
            this.hash = key.hashCode();
        }

        @Override
        public K1 getKey() {
            return key;
        }

        @Override
        public V1 getValue() {
            return value;
        }

        void setValue(V1 value) {
            this.value = value;
        }
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new EntryIterator();
    }

    private class EntryIterator implements Iterator<Entry<K, V>> {
        int bin = 0;
        Node<K, V> cursor = bins[bin];
        @Override
        public boolean hasNext() {
            while (bin < bins.length - 1 && cursor == null) {
                cursor = bins[++bin];
            }
            return cursor != null;
        }

        @Override
        public Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            var res = cursor;
            cursor = cursor.next;
            return res;
        }
    }
}
