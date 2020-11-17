package structure.list.impl;
import structure.list.GBIterator;
import structure.list.GBNode;

public class MyIterator implements GBIterator {

    private GBNode current;

    public MyIterator(GBNode current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public String next() {
        String val = current.getValue();
        current = current.getNext();
        return val;
    }

}
