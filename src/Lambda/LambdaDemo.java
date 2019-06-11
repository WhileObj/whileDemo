package Lambda;

import javafx.scene.input.TouchEvent;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {
    public static void main(String[] args) {

        //***************************************无参无返回值***************************************

        //传统方法创建一个线程任务的方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"正在工作");
            }
        }).start();

        //Lambda表达式写法，等价于上方代码
        new Thread(() -> System.out.println(Thread.currentThread().getName()+"正在工作")).start();

        //***************************************有参有返回值***************************************

        Persion[] persions={
                new Persion("张三",18),
                new Persion("李四",19),
                new Persion("王五",20)
        };

//        /**
//         * 传统写法
//         */
//        Arrays.sort(persions, new Comparator<Persion>() {
//            @Override
//            public int compare(Persion o1, Persion o2) {
//                return o2.getAge()-o1.getAge();
//            }
//        });

        //带参数和返回值的Lambda表达式
        Arrays.sort(persions,(o1,o2)->o2.getAge()-o1.getAge());

        for (Persion persion : persions) {
            System.out.println("姓名:"+persion.getName()+",年龄"+persion.getAge());
        }
    }
}
