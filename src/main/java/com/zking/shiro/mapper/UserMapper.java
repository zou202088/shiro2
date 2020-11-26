package com.zking.shiro.mapper;

import com.zking.shiro.model.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 注册
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     *获取用户角色
     * @param username
     * @return
     */
    Set<String> findRoles(String username);

    /**
     * 获取用户权限
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);



}