import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        int size = this.size();

        if (size == this.capacity) {
            this.resize(this.capacity * 2);
        }

        int index = this.getIndex(this.tail);
        this.q[index] = item;
        this.tail++;
    }

    public Item dequeue() {
        int size = this.size();
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        // get item from random index
        int randomIndex = StdRandom.uniform(this.head, this.tail);
        int index = this.getIndex(randomIndex);
        Item item = this.q[index];

        // move the last item to the removed item index
        int lastIndex = this.getIndex(this.tail - 1);
        if (randomIndex != this.tail - 1) { // only perform
            Item lastItem = this.q[lastIndex];
            this.q[index] = lastItem;
        }

        // remove the last item
        this.q[lastIndex] = null;
        this.tail--;

        return item;
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
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        System.out.println(queue.size());
        System.out.println(Arrays.toString(queue.q));
        System.out.println("--");

        System.out.println("enqueue hello");
        queue.enqueue("hello");
        System.out.println(queue.size());
        System.out.println(Arrays.toString(queue.q));
        System.out.println(queue.head);
        System.out.println(queue.tail);

        System.out.println("enqueue abc");
        queue.enqueue("abc");
        System.out.println(queue.size());
        System.out.println(Arrays.toString(queue.q));
        System.out.println(queue.head);
        System.out.println(queue.tail);

        System.out.println("enqueue def");
        queue.enqueue("def");
        System.out.println(queue.size());
        System.out.println(Arrays.toString(queue.q));
        System.out.println(queue.head);
        System.out.println(queue.tail);

        System.out.println("---");
        System.out.println("dequeue");
        System.out.println(queue.dequeue());
        System.out.println(Arrays.toString(queue.q));
        System.out.println(queue.head);
        System.out.println(queue.tail);
    }
}
