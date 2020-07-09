package com.demo.springcmdline.test;

import com.demo.springcmdline.Application;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Alan Huang.
 * Date: 2020-07-09 08:31
 */
public class DbTestUtil {

    public static boolean loadDbScript(String fileName) {
        try {
            String sqlFilePath = DbTestUtil.class.getResource(fileName).toURI().toString().substring(5);
            SqlSessionFactory sessionFactory = (SqlSessionFactory)Application.getInstance().getBean("sessionFactory");
            SqlSession sqlSession = sessionFactory.openSession();
            Connection connection = sqlSession.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("runscript from '" + sqlFilePath + "'");
            statement.close();
            connection.close();
            sqlSession.close();
            return true;
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
