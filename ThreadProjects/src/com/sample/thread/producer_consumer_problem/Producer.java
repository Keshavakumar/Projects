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
public class Producer implements Runnable {

    DataList dataList;

    List<Integer> list = null;

    Producer(DataList dataList) {
        this.dataList = dataList;
        list = dataList.getDataList();
    }

    public void produce(int data) {

        synchronized (dataList) {

            while (dataList.getSIZE_OF_LIST() <= list.size()) {
                try {
                    System.out.println("Waiting for consumer to run . . ");
                    dataList.wait();
                    System.out.println("Wait for consumer over");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            System.out.println("IF --> " + dataList.getSIZE_OF_LIST() + list.size());
            list.add(data);
            System.out.println("Produced data : Array Size " + list.size());
            dataList.notify();
        }
    }

    @Override
    public void run() {
        produce((int) Math.random());
    }

}
