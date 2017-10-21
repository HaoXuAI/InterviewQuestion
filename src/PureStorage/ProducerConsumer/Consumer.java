package PureStorage.ProducerConsumer;

/**
 * Created by hao on 10/18/17.
 */
public class Consumer extends Thread {
    private PC pc;

    public Consumer(PC pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        try {
            pc.get_one_id();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
