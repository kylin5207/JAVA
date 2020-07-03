package jedis.dao;

import jedis.domain.Province;

import java.util.List;

public interface ProvinceDao {
    /**
     * 查询所有省份
     * @return 省份列表
     */
    public List<Province> findAll();
}
