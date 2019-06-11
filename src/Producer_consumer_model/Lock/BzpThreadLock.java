package Producer_consumer_model.Lock;

import Producer_consumer_model.BaoZi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class BzpThreadLock implements Runnable{

    private BaoZi baoZi;
    private int i=0;
    private Lock lock;//因为线程的唤醒必须使用同一个线程锁，故传入一个Lock类
    private Condition condition;//该类是为了配合Lock控制线程的休眠和唤醒:
    //await()代替wait()，signal()代替notify();

    public BzpThreadLock(BaoZi baoZi, Lock lock, Condition condition) {
        this.baoZi = baoZi;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();//获取锁
                if(baoZi.isFlag()==true){
                    condition.await();//休眠
                }else {
                    if(i%2==0){
                        baoZi.setPi("薄皮");
                        baoZi.setXian("青菜香菇");
                    }else{
                        baoZi.setPi("厚皮");
                        baoZi.setXian("牛肉粉条");
                    }
                    i++;
                    System.out.println("包子铺后厨：");
                    System.out.println("包子铺正在生产"+baoZi.getPi()+"皮"+baoZi.getXian()+"馅的包子");
                    Thread.sleep(3000);
                    baoZi.setFlag(true);
                    System.out.println("包子已经生产了"+baoZi.getPi()+"皮"+baoZi.getXian()+"馅的包子");
                    condition.signal();//唤醒
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();//无论如何最后释放锁
            }
        }

    }
}
