package Producer_consumer_model.Lock;

import Producer_consumer_model.BaoZi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BaoZiRun {
        public static void main(String[] args) {
            BaoZi baoZi=new BaoZi();
            Lock lock=new ReentrantLock();
            Condition condition = lock.newCondition();//配合Lock控制唤醒和休眠

            new Thread(new BzpThreadLock(baoZi,lock,condition)).start();
            new Thread(new ChThreadLock(baoZi,lock,condition)).start();
        }
}
