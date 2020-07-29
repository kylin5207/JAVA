package mybatis.sqlSession.proxy;

import mybatis.sqlSession.Mapper;
import mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    //Map的key：全限定类名.方法名
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy() {
    }

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 用于方法增强
     * 调用selectList方法
     * @param o
     * @param method
     * @param objects
     * @return
     * @throws Throwable
     */
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //1. 获取方法名
        String methodName = method.getName();

        //2. 获取方法声明类的类名
        String className = method.getDeclaringClass().getName();

        //3. 拼接key
        String key = className + "." + methodName;

        //4. 获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        if(mapper == null){
            throw new IllegalArgumentException("传入参数有误");
        }
        //5. 调用工具类执行查询所有

        return new Executor().selectList(mapper, conn);
    }
}
