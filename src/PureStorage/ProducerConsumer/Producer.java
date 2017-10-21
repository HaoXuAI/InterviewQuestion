package PureStorage.ProducerConsumer;

/**
 * Created by hao on 10/18/17.
 */
public class Producer extends Thread {
    private PC pc;

    public Producer(PC pc) {
        this.pc = pc;
    }

    @Override
    public void run() {
        try {
            pc.add();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
