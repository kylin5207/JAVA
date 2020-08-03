package dao;

import domain.Role;

import java.util.List;

public interface RoleDao {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();

    /**
     * 查询所有角色赋予的用户信息
     * @return
     */
    List<Role> findAllUser();

}
