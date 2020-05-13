package es.datastructur.synthesizer;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        Queue<Integer> t = new ArrayDeque<>();
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(3);
        assertTrue(arb.isEmpty());
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        assertTrue(arb.isFull());
        assertEquals((Integer) 1, arb.dequeue());
        assertFalse(arb.isFull());
        assertEquals((Integer) 2, arb.peek());
        arb.enqueue(4);
        assertTrue(arb.isFull());
    }

    @Test
    public void iteratorTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        for (int i = 0; i < 10; i++)
            arb.enqueue(i);
        arb.dequeue();
        Integer j = 1;
        for (Integer i : arb) {
            assertEquals(j, arb.dequeue());
            j++;
        }
    }

    @Test
    public void equalsTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(11);
        for (int i = 0; i < 10; i++)
            arb.enqueue(i);
        assertTrue(arb.equals(arb));
        ArrayRingBuffer<Integer> brb = new ArrayRingBuffer<>(10);
        for (int i = 0; i < 10; i++)
            brb.enqueue(i);
        assertTrue(arb.equals(brb));
        arb.enqueue(11);
        assertFalse(arb.equals(brb));
    }
}