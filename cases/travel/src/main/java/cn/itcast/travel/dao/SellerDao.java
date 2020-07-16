package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

public interface SellerDao {
    /**
     * 根据sid查询seller对象
     * @param sid
     * @return
     */
    public Seller findById(int sid);
}
