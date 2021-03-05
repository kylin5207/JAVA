package FileTest.FileCases;

import java.io.File;
import java.io.FileFilter;

/*
    文件过滤器优化
        java.io.FileFilter是一个接口，是File的过滤器。
            该接口的对象可以传递给File类的 listFiles(FileFilter) 作为参数， 接口中只有一个方法。
                boolean accept(File pathname):测试pathname是否应该包含在当前的File目录中，符合返回True

        注意：
            需要我们自己实现接口，可以考虑使用lambda表达式
 */

class FileFilterImpl implements FileFilter {

    @Override
    public boolean accept(File file) {
        if(file.isDirectory()) { //如果是文件夹，也返回true，继续遍历文件夹
            return true;
        }
        else if(file.getName().endsWith(".java"))
            return true; //如果是java文件，则返回true
        else
            return false;
    }
}

public class Case2 {
    public static void main(String[] args) {

        File file = new File("//Users//shangmengqi//Desktop//kylin//JAVAStudy//day01-code");
        getAllFiles(file);
    }

    public static void getAllFiles(File dir) {
        System.out.println(dir.getName() + " / ");

//        File[] files = dir.listFiles(new FileFilterImpl());

//        使用lambda表达式
        File[] files = dir.listFiles((File d, String name) -> new File(d,name).isDirectory() || name.endsWith(".java"));

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
