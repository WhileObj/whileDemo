package File;

import java.io.File;
import java.lang.reflect.Constructor;

public class FileDemo {
    public static void main(String[] args) {
        //与系统有关的路径分隔符（win下是";"，linux下是":"）
        String pathSeparator = File.pathSeparator; //字符串
        char pathSeparatorChar = File.pathSeparatorChar; //字符

        //与系统有关的名称分隔符（win下是"\"，linux下是"/"）
        String separator = File.separator; //字符串
        char separatorChar = File.separatorChar; //字符

        File file=new File("E:\\下载");
        for (String a:file.list()) {
            System.out.println(a);
        }
    }
}
