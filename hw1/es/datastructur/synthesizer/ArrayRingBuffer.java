package es.datastructur.synthesizer;

import java.util.Iterator;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement es.datastructur.synthesizer.BoundedQueue<T>

public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    public void enqueue(T x) {
        if (fillCount() == capacity())
            throw new RuntimeException("Ring buffer overflow");
        rb[last] = x;
        last = (last + 1) % capacity();
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T dequeue() {
        if (fillCount() == 0)
            throw new RuntimeException("Ring buffer underflow");
        T item = rb[first];
        first = (first + 1) % capacity();
        fillCount--;
        return item;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T peek() {
        if (fillCount() == 0)
            throw new RuntimeException("Ring buffer underflow");
        T item = rb[first];
        return item;
    }

    private class ArrayRingBufferIterator implements Iterator<T> {
        int currPos;
        int count;

        public ArrayRingBufferIterator() {
            currPos = first;
            count = 0;
        }

        public boolean hasNext() {
            return count < fillCount();
        }

        public T next() {
            T item = rb[currPos];
            currPos = (currPos + 1) % capacity();
            count++;
            return item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        if (o == this)
            return true;
        ArrayRingBuffer<T> other = (ArrayRingBuffer<T>) o;
        if (other.fillCount() != this.fillCount())
            return false;
        Iterator<T> thisIterator = this.iterator();
        Iterator<T> oIterator = other.iterator();
        while (thisIterator.hasNext()) {
            if (thisIterator.next() != oIterator.next())
                return false;
        }
        return true;
    }
}
