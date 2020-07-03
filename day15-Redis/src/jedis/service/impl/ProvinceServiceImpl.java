package jedis.service.impl;

import jedis.dao.ProvinceDao;
import jedis.dao.impl.ProvinceDaoImpl;
import jedis.domain.Province;
import jedis.service.ProvinceService;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {

        return dao.findAll();
    }
}
