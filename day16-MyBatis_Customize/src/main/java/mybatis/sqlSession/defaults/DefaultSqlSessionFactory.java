package mybatis.sqlSession.defaults;

import mybatis.sqlSession.Configuration;
import mybatis.sqlSession.SqlSession;
import mybatis.sqlSession.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration config;

    public DefaultSqlSessionFactory(Configuration config) {
        this.config = config;
    }

    /**
     * 用于创建一个新的SqlSession
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(config);
    }
}
