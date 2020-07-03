package jedis.dao.impl;

import jedis.dao.ProvinceDao;
import jedis.domain.Province;
import jedis.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询所有省份数据的实现类
     * @return 省份列表
     */
    @Override
    public List<Province> findAll() {
        String sql = "select * from province";
        List<Province> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

        return list;
    }
}
