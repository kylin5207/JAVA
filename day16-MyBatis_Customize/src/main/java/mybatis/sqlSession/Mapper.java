package mybatis.sqlSession;

/**
 * 用于封装执行的Sql语句和结果类型的全限定类名
 */
public class Mapper {
    private String sql; //SQL语句
    private String resultType; //实体类类名

    public Mapper() {
    }

    public Mapper(String sql, String resultType) {
        this.sql = sql;
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
