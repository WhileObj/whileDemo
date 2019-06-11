package Recursive;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FilenameFilter;
import java.math.BigDecimal;

public class RecursiveDemo {

    public static void main(String[] args) {
        File file=new File("E:\\下载");
        getFile(file);
    }
    private static void getFile(File file) {
        File[] files = file.listFiles((pathname) ->pathname.getName().toLowerCase().endsWith(".txt") || pathname.isDirectory());
        for (File file1:files){
            if(file1.isDirectory()){
                getFile(file1);
            }else if(file1.isFile()){
                System.out.println(file1.getName());
            }
        }
    }
}
