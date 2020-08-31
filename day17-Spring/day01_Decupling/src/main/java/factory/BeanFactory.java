package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 * Bean:可重用组件
 * JavaBean:用java语言编写的可重用组件
 * javaBean > 实体类
 *
 * 它就是创建service和dao对象的
 */

public class BeanFactory {
    //1. 定义一个properties对象
    private static Properties props;

    //定义一个Map，用于存放我们要创建的对象。我们把它称之为容器
    private static Map<String, Object> beans;

    //2. 使用静态代码块为Properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();

            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);

            //实例化容器
            beans = new HashMap<String, Object>();
            Enumeration keys = props.keys();
            //遍历枚举
            while(keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //存入容器
                beans.put(key, value);
            }

        } catch (IOException | ClassNotFoundException e) {
                throw new ExceptionInInitializerError("初始化properties失败！");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据beanName的名称，获取bean对象(单例)
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

}
