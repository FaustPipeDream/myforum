package com.forum.myforum.dao;


import com.forum.myforum.domain.User;

/**
 * @author Indexalice
 * @date 2018/4/15 10:39
 */
public interface UserDaoI {

  /**
   * 检测用户名与密码是否匹配
   *
   * @param userName 用户名
   * @param password 密码
   * @return 1:匹配 0:不匹配
   */
  int getMatchCount(String userName, String password);

  /**
   * 通过用户名查询用户
   *
   * @param userName 用户名
   * @return 用户实体类
   */
  User findUserByUserName(String userName);

  /**
   * 用户登录后更新用户信息
   *
   * @param user 用户实体类
   */
  void updateLoginInfo(User user);
}
