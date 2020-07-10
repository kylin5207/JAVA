package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    /**
     * 查找所有类别的Service
     * @return
     */
    @Override
    public List<Category> findAll() {
        //1. 从redis中查询
        Jedis jedis = JedisUtil.getJedis();
//        Set<String> categories =  jedis.zrange("category", 0, -1);
        //查询sortedSet中的分数cid和cname
        Set<Tuple> categories = jedis.zrangeWithScores("category", 0, -1);

        List<Category> categoryList = null;
        //2. 判断查询的集合是否为空
        if(categories == null || categories.size() == 0){
            System.out.println("----从数据库中查询------");
            //空，第一次访问，则从数据库中查询
            categoryList = categoryDao.findAll();
            //将数据存入redis 使用sortedSet排序查询
            for (int i = 0; i < categoryList.size(); i++) {
                jedis.zadd("category", categoryList.get(i).getCid(), categoryList.get(i).getCname());
            }
        }
        else{
            //不为空，将set数据存入list
            System.out.println("----从redis中查询------");
            categoryList = new ArrayList<Category>();
            for (Tuple tuple : categories) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int)tuple.getScore());
                categoryList.add(category);
            }
        }
        return categoryList;
    }
}
