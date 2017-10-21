package PureStorage.ProducerConsumer;

/**
 * Created by hao on 10/18/17.
 */
public class Main {
    public static void main(String[] args) {
        PC pc = new PC();
        Producer producer = new Producer(pc);
        Consumer consumer = new Consumer(pc);

        producer.start();
        consumer.start();
    }
}
