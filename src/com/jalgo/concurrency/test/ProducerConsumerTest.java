package com.jalgo.concurrency.test;

import com.jalgo.concurrency.IQueue;
import com.jalgo.concurrency.LockingQueue;
import com.jalgo.concurrency.SynchronizedQueue;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ProducerConsumerTest {
    @Test
    public void producerConsumerLockingQueue() {
        producerConsumerCore(new LockingQueue<Integer>(1000));
        producerConsumerCore(new LockingQueue<Integer>(100000));
    }

    @Test
    public void producerConsumerSynchronizedQueue() {
        producerConsumerCore(new SynchronizedQueue<Integer>(1000));
        producerConsumerCore(new SynchronizedQueue<Integer>(100000));
    }

    private static void producerConsumerCore(IQueue<Integer> queue) {
        Integer[] items = new Integer[queue.getCapacity()];
        for (int i = 0; i < items.length; i++) {
            items[i] = i;
        }
        assertFalse("Initial array values do not equal to -1", Arrays.stream(items).anyMatch(item -> item == -1));
        var tester = new Object() {
            int index = 0;
            Exception exception;
        };

        Runnable producer = () -> {
            while (tester.index < items.length) {
                try {
                    queue.put(items[tester.index++]);
                } catch (Exception e) {
                    tester.exception = e;
                }
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();

        Runnable consumer = () -> {
            while (true) {
                try {
                    items[queue.get()] = -1;
                } catch (Exception e) {
                    tester.exception = e;
                }
            }
        };
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();

        while (!Arrays.stream(items).allMatch(item -> item == -1)) {
        }
        assertNull("No exception has been thrown", tester.exception);
        assertTrue("Threads resets initial array values to -1", Arrays.stream(items).allMatch(item -> item == -1));
    }
}
