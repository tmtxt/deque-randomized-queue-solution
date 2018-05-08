import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] q; // store queue data
    private int head;
    private int tail;
    private int capacity;

    public RandomizedQueue() {
        // init the queue as size 1
        this.capacity = 1;
        this.q = (Item[]) new Object[capacity];

        this.head = 0;
        this.tail = 0;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.tail - this.head;
    }

    public void enqueue(Item item) {
        int size = this.size();

        if (size == this.capacity) {
            this.resize(this.capacity * 2);
        }
    }

    public Item dequeue() {
        return null;
    }

    public Item sample() {
        return null;
    }

    public Iterator<Item> iterator() {
        return null;
    }

    private void resize(int newCap) {
        // init new queue
        Item[] newQ = (Item[]) new Object[newCap];

        // copy to new queue
        int newIndex;
        int i;
        for (i = head, newIndex = 0; i < tail; i++, newIndex++) {
            int oldIndex = this.getIndex(i);
            newQ[newIndex] = this.q[oldIndex];
        }

        this.q = newQ;
        this.capacity = newCap;
        this.head = 0;
        this.tail = newIndex;
    }

    private int getIndex(int index) {
        return index % this.capacity;
    }

    public static void main(String[] args) {

    }
}
