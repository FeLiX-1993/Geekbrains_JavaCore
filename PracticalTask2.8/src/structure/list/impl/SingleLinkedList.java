package structure.list.impl;

import structure.list.GBIterator;
import structure.list.GBList;
import structure.list.GBNode;

public class SingleLinkedList implements GBList {
    private Node first;
    private int size = 0;

    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val);
        } else {
            add(first, val);
        }
        size++;
    }

    private void add(Node current, String val) {
        if (current.next == null) {
            current.next = new Node(val);
            return;
        }
        add(current.next, val);
    }

    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)) {
            first = first.next;
            size--;
            return true;
        }

        Node prev = first;
        Node current = first.next;
        while(current != null) {
            if (current.val.equals(val)) {
                prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {

        if (index < 0 || index > size -1)
            throw new IndexOutOfBoundsException(index);

        Node current = first;
        for (int j = 0; j < index; j++) {
            current = current.next;
            if (current == null)
                break;
        }

        return (current == null) ? null: current.val;
    }

    @Override
    public GBIterator iterator() {
        return new MyIterator(first);
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "first=" + first +
                '}';
    }

    private static class Node implements GBNode {

        private Node next;
        private String val;

        public Node(String val) {
            this(val, null);
        }

        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String getValue() {
            return val;
        }

        @Override
        public GBNode getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val='" + val + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
}
