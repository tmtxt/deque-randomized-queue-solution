import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    public Deque() {
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        Node oldFirst = this.first;
        Node newNode = new Node();
        newNode.item = item;

        if (oldFirst != null) {
            newNode.next = oldFirst;
            oldFirst.prev = newNode;
        } else {
            this.last = newNode;
        }

        this.first = newNode;
        this.size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        Node oldLast = this.last;
        Node newNode = new Node();
        newNode.item = item;

        if (oldLast != null) {
            newNode.prev = oldLast;
            oldLast.next = newNode;
        } else {
            this.first = newNode;
        }

        this.last = newNode;
        this.size++;
    }

    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("Deque is empty");
        }

        Node first = this.first;
        Node last = this.last;

        Node next = first.next;
        this.first = next;

        if (first == last) {
            this.last = null;
        } else {
            next.prev = null;
        }

        this.size--;
        return first.item;
    }

    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("Deque is empty");
        }

        Node first = this.first;
        Node last = this.last;

        Node prev = last.prev;
        this.last = prev;

        if (first == last) {
            this.first = null;
        } else {
            prev.next = null;
        }

        this.size--;
        return last.item;
    }

    private class Node {
        Item item;
        Node next;
        Node prev;

        @Override
        public String toString() {
            return item.toString();
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String[] args) {
        Deque<String> d = new Deque<String>();
        System.out.println(d.size());

        d.addFirst("hello");
        d.addFirst("def");
        d.addLast("fuck");
        d.addLast("you");

        System.out.println(d.size());
        System.out.println(d.first);
        System.out.println(d.first.next);
        System.out.println(d.first.next.next);
        System.out.println(d.first.next.next.next);

        System.out.println("----");
        d.removeFirst();
        d.removeLast();
        System.out.println(d.first);
        System.out.println(d.first.next);
        System.out.println(d.first.next.next);
    }
}
