/*
 * Copyright (c) Advanced Driver Information Technology
 */

package com.sample.thread.producer_consumer_problem.semaphore;

/**
 *
 */
public class MainClass {

    public static void main(String[] args) {

        ProcuctQueue pq = new ProcuctQueue();
        Producer p = new Producer(pq);
        Consumer c = new Consumer(pq);

    }

}
