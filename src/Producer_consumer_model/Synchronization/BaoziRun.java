package Producer_consumer_model.Synchronization;

import Producer_consumer_model.BaoZi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BaoziRun {

    public static void main(String[] args) {
        BaoZi baoZi=new BaoZi();
        Lock lock=new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new BzpThread(baoZi,lock,condition)).start();
        new Thread(new ChThread(baoZi,lock,condition)).start();


    }
}
