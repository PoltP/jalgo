package com.jalgo.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockingQueue<TItem> implements IQueue<TItem> {
    private final ReentrantLock locker = new ReentrantLock();
    private final Condition conditionNotEmpty = locker.newCondition();
    private final Condition conditionNotFull = locker.newCondition();

    private Queue<TItem> queue;
    private int capacity;

    public LockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<TItem>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void put(TItem item) throws InterruptedException {
        this.locker.lock();
        try {
            while (this.queue.size() == this.capacity) {
                this.conditionNotFull.await();
            }
            this.queue.offer(item);
            this.conditionNotEmpty.signalAll();
        } finally {
            this.locker.unlock();
        }
    }

    public TItem get() throws InterruptedException {
        this.locker.lock();
        try {
            while (this.queue.size() == 0) {
                this.conditionNotEmpty.await();
            }
            TItem item = this.queue.poll();
            this.conditionNotFull.signalAll();
            return item;
        } finally {
            this.locker.unlock();
        }
    }
}
