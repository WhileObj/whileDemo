import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChThread implements Runnable{
    private BaoZi baoZi;

    private Lock lock;
    private Condition condition;

    public ChThread(BaoZi baoZi, Lock lock, Condition condition) {
        this.baoZi = baoZi;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if(baoZi.isFlag()==true){
                    System.out.println("吃货正在吃"+baoZi.getPi()+"皮"+baoZi.getXian()+"馅的包子");
                    Thread.sleep(3000);
                    System.out.println("吃货已经吃完"+baoZi.getPi()+"皮"+baoZi.getXian()+"馅的包子");
                    baoZi.setFlag(false);
                    condition.signal();
                }else{
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
