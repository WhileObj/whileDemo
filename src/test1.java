import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test1 {

    public static void main(String[] args) {
        BaoZi baoZi=new BaoZi();
        Lock lock=new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(new BzpThread(baoZi,lock,condition)).start();
        new Thread(new ChThread(baoZi,lock,condition)).start();

    }
}
