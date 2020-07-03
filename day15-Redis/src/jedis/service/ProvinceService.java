package jedis.service;

import jedis.domain.Province;

import java.util.List;

public interface ProvinceService {

    public List<Province> findAll();
}
