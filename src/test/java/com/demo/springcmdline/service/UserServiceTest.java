package com.demo.springcmdline.service;

import com.demo.springcmdline.Application;
import com.demo.springcmdline.bean.User;
import com.demo.springcmdline.dao.LogDao;
import com.demo.springcmdline.test.DbTestUtil;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Alan Huang.
 * Date: 2020-07-09 11:10
 */
public class UserServiceTest {

    @Before
    public void setup() {
        Application.getInstance().initialize();

        DbTestUtil.loadDbScript("/user.sql");
        DbTestUtil.loadDbScript("/log.sql");
    }

    @Test
    public void testRegisterUserOk() {
        LogDao logDao = (LogDao) Application.getInstance().getBean("logDao");
        int logCount1 = logDao.getLogCount();

        UserService userService = (UserService)Application.getInstance().getBean("userService");
        User zhangsan = userService.registerUser("zhangsan", 1);
        assertNotNull(zhangsan);
        assertTrue(zhangsan.getId().intValue() > 0);

        int logCount2 = logDao.getLogCount();
        assertEquals(logCount1+1, logCount2);
    }

    @Test
    public void testRegisterUserFailure() {
        LogDao logDao = (LogDao) Application.getInstance().getBean("logDao");
        int logCount1 = logDao.getLogCount();

        UserService userService = (UserService)Application.getInstance().getBean("userService");
        try {
            User zhangsan = userService.registerUser("zhangsan12345678901234567890123456789012345678901234567890", 1);
            assertNull(zhangsan);
        } catch (Exception ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }

        int logCount2 = logDao.getLogCount();
        assertEquals(logCount1, logCount2);
    }
}
