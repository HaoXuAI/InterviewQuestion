package PureStorage.ProducerConsumer;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static PureStorage.ProducerConsumer.SingleThread.get_ids;


/**
 * Created by hao on 10/17/17.
 */
public class MultiThread {

    static class BlockingQueue {
        private Queue<Integer> queue;
        private int threshold = 100;

        BlockingQueue() {
            queue = new LinkedList<>();

            List<Integer> ids = get_ids();
            queue.addAll(ids);
        }

        synchronized void put() throws InterruptedException {
            while (true) {
                while (queue.size() > threshold) {
                    wait();
                }

                List<Integer> ids = get_ids();
                queue.addAll(ids);
            }
        }

        synchronized Integer take() throws InterruptedException {
            while (true) {
                while (queue.size() == 0) {
                    wait();
                }
                Integer result = queue.poll();
                notifyAll();
                return result;
            }
        }

    }

    static class Producer extends Thread {
        private BlockingQueue bq;

        Producer(BlockingQueue bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            try {
                bq.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer extends Thread {
        private BlockingQueue bq;

        Consumer(BlockingQueue bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    Integer res = bq.take();
                    System.out.println(i + ", " + res);
                }
                for (int i = 100; i < 200; i++) {
                    Integer res = bq.take();
                    System.out.println(i + ", " + res);
                }
                for (int i = 200; i < 300; i++) {
                    Integer res = bq.take();
                    System.out.println(i + ", " + res);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue bq = new BlockingQueue();
        Producer producer = new Producer(bq);
        Consumer consumer = new Consumer(bq);

        producer.start();
        consumer.start();

    }



}
