package mybatis.sqlSession;

import mybatis.sqlSession.defaults.DefaultSqlSessionFactory;
import mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    /**
     * 根据字节输入流，构建SqlSessionFactory工厂
     * @param in
     * @return
     */
    public SqlSessionFactory build(InputStream in){
        Configuration config = XMLConfigBuilder.loadConfiguration(in);
        return new DefaultSqlSessionFactory(config);
    }
}
