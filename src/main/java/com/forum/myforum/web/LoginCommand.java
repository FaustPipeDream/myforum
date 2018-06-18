package com.forum.myforum.web;

/**
 * 登陆传递参数实体类
 * @author Indexalice
 * @date 2018/6/18 15:15
 */
public class LoginCommand {

  /**
   * 用户名
   */
  private String userName;

  /**
   *密码
   */
  private String password;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
