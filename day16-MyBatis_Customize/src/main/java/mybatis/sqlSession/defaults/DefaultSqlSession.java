package mybatis.sqlSession.defaults;

import mybatis.sqlSession.Configuration;
import mybatis.sqlSession.SqlSession;
import mybatis.sqlSession.proxy.MapperProxy;
import mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {
    private Configuration config;
    private Connection conn;

    public DefaultSqlSession(Configuration config) {
        this.config = config;
        this.conn = DataSourceUtil.getConnection(config);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(config.getMappers(), conn));
    }

    /**
     * 用于释放资源
     */
    public void close() {
        if(conn != null){
            try{
                conn.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
