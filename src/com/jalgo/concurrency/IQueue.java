package com.jalgo.concurrency;

public interface IQueue<TItem> {
    void put(TItem item) throws InterruptedException;
    TItem get() throws InterruptedException;
    int getCapacity();
}
