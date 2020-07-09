package com.demo.springcmdline.bean;

/**
 * Created by Alan Huang.
 * Date: 2020-07-09 10:52
 */
public class Log {

    private String level;
    private String message;
    private Integer userid;
    private Integer created;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }
}
