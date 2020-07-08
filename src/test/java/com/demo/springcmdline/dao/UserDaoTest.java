package com.demo.springcmdline.dao;

import com.alibaba.fastjson.JSON;
import com.demo.springcmdline.Application;
import com.demo.springcmdline.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Alan Huang.
 * Date: 2020-07-08 16:12
 */
public class UserDaoTest {

    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void setup() throws SQLException {
        Application.getInstance().initialize();
        SqlSessionFactory sessionFactory = (SqlSessionFactory)Application.getInstance().getBean("sessionFactory");
        userDao = (UserDao)Application.getInstance().getBean("userDao");

        sqlSession = sessionFactory.openSession();
        Connection connection = sqlSession.getConnection();
        Statement statement = connection.createStatement();

        boolean ok = statement.execute("runscript from 'classpath:/user.sql'");
        statement.close();

        System.out.println("execute sql ok? " + ok);
        connection.commit();

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User byId = mapper.findById(1);
        System.out.println(JSON.toJSONString(byId));

        sqlSession.close();

//        sqlSession = sessionFactory.openSession();
//        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        User byId = mapper.findById(1);
//        System.out.println(JSON.toJSONString(byId));
//        sqlSession.close();
    }

    @Test
    public void test() {
//        User user = userDao.findById(1);
//        assertNotNull(user);
//        assertEquals(user.getUserName(), "aaa");
    }


}
