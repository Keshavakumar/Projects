/*
 * Copyright (c) Advanced Driver Information Technology
 */

package com.sample.thread.producer_consumer_problem.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class ProcuctQueue {

    private int SIZE_OF_LIST = 2;

    protected List<Integer> DATA_LIST = new ArrayList<Integer>(getSIZE_OF_LIST());

    Semaphore producer = new Semaphore(1);

    Semaphore consumer = new Semaphore(0);

    public void produce(int data) {
        try {
            producer.acquire();
            DATA_LIST.add(data);
            System.out.println("Produced data : Array Size " + DATA_LIST.size());
            consumer.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProcuctQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int consume() {
        int data = 0;
        try {
            consumer.acquire();
            data = DATA_LIST.remove(DATA_LIST.size() - 1);
            System.out.println("Consumed data : Array Size " + DATA_LIST.size());
            producer.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProcuctQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    /**
     * @return the DATA_LIST
     */
    public List getDataList() {
        return DATA_LIST;
    }

    /**
     * @param dataList the DATA_LIST to set
     */
    public void setDataList(List dataList) {
        this.DATA_LIST = dataList;
    }

    /**
     * @return the SIZE_OF_LIST
     */
    public int getSIZE_OF_LIST() {
        return SIZE_OF_LIST;
    }

}
