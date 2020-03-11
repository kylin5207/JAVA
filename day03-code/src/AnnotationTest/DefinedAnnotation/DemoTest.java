package AnnotationTest.DefinedAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 在程序使用(解析)注解:获取注解中定义的属性值
 *      1. 获取注解定义的位置的对象 (Class，Method, Field)
 *      2. 获取指定的注解
 *          getAnnotation(Class) //其实就是在内存中⽣成了一个该注解接口的⼦类实现对象
 *                public class ProImpl implements Pro{
 *                 public String className(){
 *                         return "AnnotationTest.DefinedAnnotation.Demo";
 *                }
 *               public String methodName(){
 *                         return "show";
 *                          }
 *          }
 *      3. 调用注解中的抽象⽅法获取配置的属性值
 */
@Pro(className = "AnnotationTest.DefinedAnnotation.Demo", methodName = "show")
public class DemoTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //1. 解析注解
        Class<DemoTest> demotestclass = DemoTest.class;

        //2. 获取指定的注解
        Pro annotation = demotestclass.getAnnotation(Pro.class);

        //3. 调用注解中的抽象⽅法获取配置的属性值
        String classname = annotation.className();
        String methodname = annotation.methodName();
        System.out.println(classname + ", " + methodname);

        //4.  使⽤用反射技术来加载类⽂件进内存
        Class cls = Class.forName(classname);

        //5. 创建对象
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodname);

        //6. 执⾏⽅法
        method.invoke(obj);

    }
}
