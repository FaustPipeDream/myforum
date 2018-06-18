package com.forum.myforum.service;


import com.forum.myforum.domain.User;

/**
 * @author Indexalice
 * @date 2018/4/24 22:20
 */
public interface UserServiceI {

  /**
   * 检测用户名和密码
   * @param userName 用户名
   * @param password 密码
   * @return true:用对应用户名与密码的用户 false:无相应用户
   */
  boolean hasMatchUser(String userName, String password);

  /**
   * 通过用户名查找用户
   * @param userName 用户名
   * @return 用户实体类
   */
  User findUserByUserName(String userName);

  /**
   * 登陆成功后更新信息
   * @param user
   */
  void loginSuccess(User user);
}
