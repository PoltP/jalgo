package com.jalgo.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class SynchronizedQueue<TItem> implements IQueue<TItem> {
    private Queue<TItem> queue;
    private int capacity;

    public SynchronizedQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<TItem>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public synchronized void put(TItem item) throws InterruptedException {
        while (this.queue.size() == this.capacity) {
            this.wait();// waits calling notify from get
        }
        this.queue.offer(item);
        this.notifyAll();
    }

    public synchronized TItem get() throws InterruptedException {
        while (this.queue.size() == 0) {
            this.wait();// waits calling notify from put
        }
        TItem item = this.queue.poll();
        this.notifyAll();
        return item;
    }
}
