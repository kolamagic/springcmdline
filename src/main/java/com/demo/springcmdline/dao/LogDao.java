package com.demo.springcmdline.dao;

import com.demo.springcmdline.bean.Log;

/**
 * Created by Alan Huang.
 * Date: 2020-07-09 10:53
 */
public interface LogDao {

    int insertLog(Log log);

    int getLogCount();
}
