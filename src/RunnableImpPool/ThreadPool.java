package RunnableImpPool;

import RunnableImpPool.RunnableImpPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        //创建一个含有2个线程的线程池，并用ExecutorService接口接收--面向接口编程
        ExecutorService es = Executors.newFixedThreadPool(2);
        //将线程任务提交给线程池，由线程池分配线程完成任务
            es.submit(new RunnableImpPool());//pool-1-thread-1正在工作！
            es.submit(new RunnableImpPool());//pool-1-thread-1正在工作！
            es.submit(new RunnableImpPool());//pool-1-thread-2正在工作！
        }
}
