package PureStorage.ProducerConsumer;

import java.util.*;

/**
 * Created by hao on 10/18/17.
 */
public class PC {
    private Queue<Integer> queue = new LinkedList<>();
    private final int SIZE = 100;

    public PC() {
    }

    public void add() throws InterruptedException {
        int val = 0;
        while (true) {
            synchronized (this) {
                while (queue.size() == SIZE) {
                    wait();
                }
                List<Integer> res = get_ids();
                queue.addAll(res);
                notify();
                return;
            }
        }
    }

    public Integer get_one_id() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (queue.size() == 0
                        ) {
                    wait();
                }
                int val = queue.poll();
                System.out.println("consumed-" + val);
                notify();
                return val;
            }
        }
    }

    public List<Integer> get_ids() {
        List<Integer> res = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            res.add(random.nextInt(1000));
        }
        return res;
    }
}

