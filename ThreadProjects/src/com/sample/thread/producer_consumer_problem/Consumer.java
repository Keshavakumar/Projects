/*
 * Copyright (c) Advanced Driver Information Technology
 */

package com.sample.thread.producer_consumer_problem;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Consumer implements Runnable {

    DataList dataList;

    List<Integer> list = null;

    Consumer(DataList dataList) {
        this.dataList = dataList;
        list = dataList.getDataList();
    }

    public int consume() {

        synchronized (dataList) {
            while (list.size() <= 0) {
                try {
                    System.out.println("Waiting for producer to run . . ");
                    dataList.wait();
                    System.out.println("Wait for producer over");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            int data = list.remove(list.size() - 1);
            System.out.println("Consumed data : Array Size " + list.size());
            dataList.notify();
            return data;

        }
    }

    @Override
    public void run() {
        consume();
    }

}
