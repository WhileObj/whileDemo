package Producer_consumer_model.Lock;

import Producer_consumer_model.BaoZi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ChThreadLock implements Runnable{

    private BaoZi baoZi;
    private Lock lock;
    private Condition condition;

    public ChThreadLock(BaoZi baoZi, Lock lock, Condition condition) {
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
                    System.out.println("包子铺店内：");
                    System.out.println("吃货线程已经开始吃"+baoZi.getPi()+baoZi.getXian()+"的包子");
                    Thread.sleep(3000);//模拟吃的动作
                    System.out.println("吃货线程已经吃完一个"+baoZi.getPi()+baoZi.getXian()+"的包子");
                    baoZi.setFlag(false);
                    System.out.println("----------------------------------------------------------------");
                    condition.signal();
                }else {
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
