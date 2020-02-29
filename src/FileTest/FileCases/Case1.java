package FileTest.FileCases;

import java.io.File;

/*
     文件搜索案例：搜索.java结尾的文件

     分析:
        1. 目录搜索，无法判断多少级目录，所以使用递归，遍历所有目录。
        2. 遍历目录时，获取的子文件，通过文件名称，判断是否符合条件。
 */
public class Case1 {
    public static void main(String[] args) {

        File file = new File("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code");
        getAllFiles(file);
    }

    public static void getAllFiles(File dir) {
        System.out.println(dir.getName() + " / ");

        File[] files = dir.listFiles();

        for (File file : files) {
            if(file.isFile() && file.getName().endsWith(".java")){
                System.out.print(file.getName() + " , ");
            }
            else if(file.isDirectory()) {
                getAllFiles(file);
            }
        }

    }
}
