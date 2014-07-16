

package com.sample.thread.producer_consumer_problem;

/**
 *
 */
public class MainClass {

    public static void main(String[] args) {

        DataList dataList = new DataList();

        Thread producer1 = new Thread(new Producer(dataList));
        Thread producer2 = new Thread(new Producer(dataList));
        Thread producer3 = new Thread(new Producer(dataList));
        Thread producer4 = new Thread(new Producer(dataList));
        Thread producer5 = new Thread(new Producer(dataList));
        Thread producer6 = new Thread(new Producer(dataList));
        Thread consumer1 = new Thread(new Consumer(dataList));
        Thread consumer2 = new Thread(new Consumer(dataList));
        Thread consumer3 = new Thread(new Consumer(dataList));
        Thread consumer4 = new Thread(new Consumer(dataList));

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        producer6.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();

    }

}
