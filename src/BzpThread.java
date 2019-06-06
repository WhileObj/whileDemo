import javax.sound.midi.Soundbank;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BzpThread implements Runnable{

    private BaoZi baoZi;
    private int i=0;
    private Lock lock;
    private Condition condition;

    public BzpThread(BaoZi baoZi, Lock lock, Condition condition) {
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
                    condition.await();
                }else {
                    if(i%2==0){
                        baoZi.setPi("薄皮");
                        baoZi.setXian("青菜香菇");
                    }else{
                        baoZi.setPi("厚皮");
                        baoZi.setXian("牛肉粉条");
                    }
                    i++;
                    System.out.println("包子铺正在生产"+baoZi.getPi()+"皮"+baoZi.getXian()+"馅的包子");
                    Thread.sleep(3000);
                    baoZi.setFlag(true);
                    System.out.println("包子已经生产了"+baoZi.getPi()+"皮"+baoZi.getXian()+"馅的包子");
                    condition.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}
