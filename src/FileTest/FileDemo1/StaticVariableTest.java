package FileTest.FileDemo1;

import java.io.File;
import java.io.IOException;

/*
    File类有四个静态的成员对象：
        public static String pathSeparator:  与系统有关的路径分隔符（字符串形式）
        public static char pathSeparator:    与系统有关的路径分隔符
        public static String separator:      与系统有关的默认的名称分隔符（字符串形式）
        public static char separator:        与系统有关的默认的名称分隔符

    判断方法：
        boolean isFile(): 判断File是否是文件
        boolean isDirectory(): 判断File是否是文件夹
        boolean exists(): 判断文件是否存在

    创建/删除方法：
        public boolean createNewFile() :当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。 public boolean delete() :删除由此File表示的文件或目录。
        public boolean mkdir() :创建由此File表示的目录。
        public boolean mkdirs() :创建由此File表示的目录，包括任何必需但不存在的父目录

    目录遍历：
        public String[] list() :返回一个String数组，表示该File目录中的所有子文件或目录。
        public File[] listFiles() :返回一个File数组，表示该File目录中的所有的子文件或目录

 */
public class StaticVariableTest {
    public static void main(String[] args) throws IOException {

        System.out.println("------查看相关分隔符--------");

        String pathSeparator = File.pathSeparator;
        System.out.println("系统默认路径分隔符：" + pathSeparator);

        String separator = File.separator;
        System.out.println("系统默认名称分隔符：" + separator);

        System.out.println("-------File构造方法测试---------");

        File file1 = new File("a.txt"); //在当前项目目录下创建a.txt文件
        System.out.println(file1);
        System.out.println("相对路径：" + file1.getPath());
        System.out.println("绝对路径：" + file1.getAbsolutePath());

        File file2 = new File("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/FileTest/FileDemo1","StaticVariableTest.java"); //指定父目录，创建该文件
        System.out.println(file2.toString()); //重写了toString()方法
        System.out.println("相对路径：" + file2.getPath());
        System.out.println("绝对路径：" + file2.getAbsolutePath());
        System.out.println("文件名：" + file2.getName());
        System.out.println("文件大小：" + file2.length() + "B");

        System.out.println("-------File判断相关的方法测试-------");
        File file3 = new File("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/FileTest/FileDemo1");
        if(file3.exists()) {
            System.out.println("file3是否是目录 ? " + file3.isDirectory());
        }

        File file4 = new File("b.java");
        System.out.println("b.java是否存在 ? " + file4.exists());

        System.out.println("-------File删除与创建方法测试-------");
        File currentdirfile = new File("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/FileTest/FileDemo1");
        if(currentdirfile.exists()) {
            File file = new File(currentdirfile,"a.txt");
            file.createNewFile();
            System.out.println("删除文件a.txt：" + file.delete());
        }

        System.out.println("-------File目录遍历------");
        File dirfile = new File("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code");
        if(dirfile.exists()){
            String[] filenames = dirfile.list();

            System.out.println("[");
            for (String filename : filenames) {
                System.out.println(filename);
            }
            System.out.println("]");
        }
    }
}
