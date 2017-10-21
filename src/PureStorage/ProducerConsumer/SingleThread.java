package PureStorage.ProducerConsumer;

import java.util.*;

/**
 * Created by hao on 10/17/17.
 */
public class SingleThread {


    Queue<Integer> queue;

    public SingleThread() {
        queue = new LinkedList<>();
    }

    public Integer get_one_id() {
        if (queue.isEmpty()) {
            List<Integer> ids = get_ids();
            for (Integer id : ids) {
                queue.add(id);
            }
        }
        return queue.poll();
    }

    static List<Integer> get_ids() {

        List<Integer> res = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            res.add(random.nextInt(1000));
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         return res;
    }

    public static void main(String[] args) {
        SingleThread singleThread = new SingleThread();
        for (int i = 0; i < 200; i++) {
            System.out.println(i + ", " + singleThread.get_one_id());
        }
    }
}
