package com.forum.myforum.dao;


import com.forum.myforum.domain.LoginLog;

/**
 * @author Indexalice
 * @date 2018/4/24 22:09
 */
public interface LoginLogDaoI {

  /**
   * 保存登录日志
   *
   * @param loginLog 登录信息实体类
   */
  void saveLoginLog(LoginLog loginLog);
}
