package com.forum.myforum.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 登陆信息实体
 * @author Indexalice
 * @date 2018/4/15 10:34
 */
public class LoginLog implements Serializable {

  /**
   * 登录信息ID
   */
  private int loginLogId;
  /**
   * 用户ID
   */
  private int userId;
  /**
   * 登录IP
   */
  private String ip;
  /**
   * 登录日期
   */
  private Date loginDate;

  public int getLoginLogId() {
    return loginLogId;
  }

  public void setLoginLogId(int loginLogId) {
    this.loginLogId = loginLogId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public Date getLoginDate() {
    return loginDate;
  }

  public void setLoginDate(Date loginDate) {
    this.loginDate = loginDate;
  }
}
