package RunnableImpPool;

public class RunnableImpPool implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在工作！");
    }
}
