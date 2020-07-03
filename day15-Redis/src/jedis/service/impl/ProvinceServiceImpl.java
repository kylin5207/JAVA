package jedis.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jedis.dao.ProvinceDao;
import jedis.dao.impl.ProvinceDaoImpl;
import jedis.domain.Province;
import jedis.service.ProvinceService;
import jedis.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {

        return dao.findAll();
    }

    /**
     * 使用Redis缓存
     * @return json数据
     */
    @Override
    public String findAllJson(){
        //1. 先从redis中查询数据
        //1.1 获取redis的客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        //2判断province_json是否为null
        if(province_json == null || province_json.length() == 0){
            //redis中没数据 ，从数据库中查询
            System.out.println("redis中没有数据，要查询数据库咯");
            List<Province> list = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //将数据存入redis
            jedis.set("province", province_json);
            //归还连接
            jedis.close();
        }
        else{
            //redis中有数据，则直接查询缓存
            System.out.println("redis中有数据，直接查询缓存");
        }

        return province_json;
    }
}
