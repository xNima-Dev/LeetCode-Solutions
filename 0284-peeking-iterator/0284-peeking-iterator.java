import java.util.Iterator;

// Java Iterator interface reference
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        // Pre-fetch the first element
        if (this.iterator.hasNext()) {
            this.nextElement = this.iterator.next();
        } else {
            this.nextElement = null;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    @Override
    public Integer next() {
        Integer current = nextElement;
        // Advance the underlying iterator to update our cache
        if (iterator.hasNext()) {
            nextElement = iterator.next();
        } else {
            nextElement = null;
        }
        return current;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}