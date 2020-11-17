package structure.list.impl;

import structure.list.GBIterator;
import structure.list.GBList;
import structure.list.GBNode;

public class DoublyLinkedList implements GBList {

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public void add(String val) {

        if (first == null) {
            first = new Node(val);
            last = first;
            size++;
            return;
        }

        Node prevLast = last;
        last = new Node(val, prevLast);
        prevLast.next = last;
        size++;
    }

    @Override
    public boolean remove(String val) {

        if (first.val.equals(val)) {
            first = first.next;
            if (first.next == null)
                last = first;
            size--;
            return true;
        }

        Node prev = first;
        Node current = first.next;
        while (current != null) {
            if (current.val.equals(val)) {
                prev.next = current.next;
                if (prev.next == null)
                    last = prev;
                else
                    prev.next.prev = prev;
                size--;
                return true;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public String get(int index) {

        if (index < 0 || index > size -1)
            throw new IndexOutOfBoundsException(index);

        Node current;
        if (index >= size/2) {
            //C конца
            current = last;
            for (int j = 0; j < size - index - 1; j++) {
                current = current.prev;
                if (current == null)
                    break;
            }
        } else {
            //С начала
            current = first;
            for (int j = 0; j < index; j++) {
                current = current.next;
                if (current == null)
                    break;
            }
        }

        return (current == null) ? null: current.val;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public GBIterator iterator() {
       return new MyIterator(first);
    }

    private static class Node implements GBNode {

        private Node prev;
        private Node next;
        private String val;

        public Node(String val) {
            this(val, null, null);
        }

        public Node(String val, Node prev) {
            this(val, prev, null);
        }

        public Node(String val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
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
                    ", prev=" + (prev == null ? null : prev.val) +
                    ", next=" + (next == null ? null : next.val) +
                    '}';
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        GBIterator iterator = iterator();
        while (iterator.hasNext())
            sb.append(iterator.next() + " ");
        sb.append(String.format("first is %s ", first));
        sb.append(String.format("last is %s", last));
        return sb.toString();
    }
}
