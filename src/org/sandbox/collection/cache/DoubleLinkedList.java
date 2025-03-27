package org.sandbox.collection.cache;

public class DoubleLinkedList<K, V> {

    private Node<K, V> head;
    private Node<K, V> tail;

    void addToHead(Node<K, V> node) {
        if (node == null) {
            throw new IllegalArgumentException("The node to remove cannot be null");
        }
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
            head.prev = null;
        }
    }

    boolean isEmpty() {
        return head == null;
    }

    void remove(Node<K, V> node) {
        if (node == null) {
            throw new IllegalArgumentException("The node to remove cannot be null");
        }
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove anything from an empty list");
        }
        if (node == head) {
            head = node.next;
            if (head != null) head.prev = null;
        }
        if (node == tail) {
            tail = node.prev;
            if (tail != null) tail.next = null;
        } else {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
        }
    }

    K removeTail() {
        if (tail == null) {
            throw new IllegalStateException("Cannot remove the tail of an empty list");
        } else {
            K tailKey = tail.key;
            remove(tail);
            return tailKey;
        }
    }

    int size() {
        int size = 0;
        Node<K, V> node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    Node<K, V> getHead() {
        return head;
    }

    Node<K, V> getTail() {
        return tail;
    }

    static class Node<K, V> {

        private final K key;
        private V value;
        private Node<K, V> prev;
        private Node<K, V> next;

        Node(final K key, final V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        void setValue(final V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node<?, ?>)) {
                return false;
            }
            Node<?, ?> anotherNode = (Node<?, ?>) obj;
            return (key.equals(anotherNode.key) && value.equals(anotherNode.value));
        }

        @Override
        public int hashCode() {
            int hashCode = key.hashCode();
            hashCode += 31 * value.hashCode();
            hashCode += 31 * prev.hashCode();
            hashCode += 31 * next.hashCode();
            return hashCode;
        }
    }
}
