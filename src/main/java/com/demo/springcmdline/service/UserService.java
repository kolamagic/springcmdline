package com.demo.springcmdline.service;

import com.alibaba.fastjson.JSON;
import com.demo.springcmdline.bean.User;
import com.demo.springcmdline.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Alan Huang.
 * Date: 2020-07-08 11:28
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public User findById(Integer userId) {
        logger.info("userLogin called");
        User user = userDao.findById(userId);
        logger.info("find user with " + userId + " return " + JSON.toJSONString(user));
        return user;
    }
}
