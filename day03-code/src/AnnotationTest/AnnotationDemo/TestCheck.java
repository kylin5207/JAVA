package AnnotationTest.AnnotationDemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 * 主方法执行后，会自动执行被检测的所有方法（加了Check注解的方法）判断方法是否有异常，记录到文件中
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {

        //1. 创建Calculator对象
        Calculator calculator = new Calculator();

        //2. 获取计算器对象的字节码文件对象
        Class calculatorclass = calculator.getClass();

        //3. 获取所有public方法
        Method[] methods = calculatorclass.getMethods();

        int num = 0; //异常次数累计器

        //如果出现异常，就写入bug.txt中
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/shangmengqi/Desktop/kylin/JAVA学习/day03-code/src/AnnotationTest/AnnotationDemo/bug.txt"));

        //遍历方法数组
        for (Method method : methods) {
            //判断方法是否有Check注解
            if(method.isAnnotationPresent(Check.class)) {
                //需要校验的方法是否有异常
                try {
                    method.invoke(calculator, 1, 0);
                } catch (Exception e) {
                    num ++ ;

                    bw.write(method.getName() + "方法出现异常");
                    bw.newLine();
                    bw.write("异常名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因：" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("-----------------");
                    bw.newLine();
                }
            }
        }

        if(num > 0) {
            bw.newLine();
            bw.write("此次一共出现" + num + "个异常");
        }
        else {
            bw.write("通过所有测试");
        }

        System.out.println(num);
        bw.close();
    }
}
