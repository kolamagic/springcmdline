package com.demo.springcmdline.dao;

import com.demo.springcmdline.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Alan Huang.
 * Date: 2020-07-08 11:26
 */
public interface UserDao {

    User findById(@Param("userId") Integer userId);

    int insertUser(User user);
}
