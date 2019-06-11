package Lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {
    public static void main(String[] args) {
        //传统方法创建一个线程任务的方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"正在工作");
            }
        }).start();

        //Lambda表达式写法，等价于上方代码
        new Thread(() -> System.out.println(Thread.currentThread().getName()+"正在工作")).start();




    }
}
