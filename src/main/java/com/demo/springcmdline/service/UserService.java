package com.demo.springcmdline.service;

import com.alibaba.fastjson.JSON;
import com.demo.springcmdline.bean.Log;
import com.demo.springcmdline.bean.User;
import com.demo.springcmdline.dao.LogDao;
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

    @Autowired
    private LogDao logDao;

    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public User findById(Integer userId) {
        logger.info("userLogin called");
        User user = userDao.findById(userId);
        logger.info("find user with " + userId + " return " + JSON.toJSONString(user));
        return user;
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public User registerUser(String username, Integer balance) {
        Log log = new Log();
        log.setLevel("INFO");
        log.setMessage("user '" + username + "' registered");
        log.setUserid(0);
        log.setCreated((int)(System.currentTimeMillis()/1000L));
        int ret2 = logDao.insertLog(log);
        if (ret2 != 1) {
            logger.error("insert log failed");
            return null;
        }

        User newUser = new User();
        newUser.setUserName(username);
        newUser.setBalance(balance);
        newUser.setCreated((int)(System.currentTimeMillis()/1000L));
        newUser.setUpdated(newUser.getCreated());

        int ret = userDao.insertUser(newUser);
        if (ret != 1) {
            logger.error("insert user failed");
            return null;
        }

        logger.info("user '" + username + "' register succeed.");
        return newUser;
    }


}
