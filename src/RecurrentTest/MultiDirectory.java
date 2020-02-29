package RecurrentTest;

/*
    递归打印多级目录
 */

import java.io.File;

public class MultiDirectory {
    public static void main(String[] args) {

        File file = new File("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code");
        if(file.exists()){
            getAllFiles(file);
        }

    }

    public static void getAllFiles(File dir){
        System.out.println(dir.getName() + " : ");

        File[] files = dir.listFiles();

        for (File file : files) {
            if(file.isFile()) {
                System.out.print(file.getName());
            }
            else if(file.isDirectory()) {
                getAllFiles(file);
                System.out.println();
            }
        }
    }
}
