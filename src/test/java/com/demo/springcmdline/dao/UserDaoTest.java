package com.demo.springcmdline.dao;

import com.demo.springcmdline.Application;
import com.demo.springcmdline.bean.User;
import com.demo.springcmdline.test.DbTestUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Alan Huang.
 * Date: 2020-07-08 16:12
 */
public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void setup() {
        Application.getInstance().initialize();
        DbTestUtil.loadDbScript("/user.sql");

        userDao = (UserDao)Application.getInstance().getBean("userDao");
    }


    @Test
    public void test() {
        User user = userDao.findById(1);
        assertNotNull(user);
        assertEquals(user.getUserName(), "aaa");
    }


    @Test
    public void test2() {
        User user = userDao.findById(2);
        assertNotNull(user);
        assertEquals(user.getUserName(), "bbb");
    }


}
