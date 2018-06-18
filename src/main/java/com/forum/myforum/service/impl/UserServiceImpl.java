package com.forum.myforum.service.impl;

import com.forum.myforum.dao.LoginLogDaoI;
import com.forum.myforum.dao.UserDaoI;
import com.forum.myforum.domain.LoginLog;
import com.forum.myforum.domain.User;
import com.forum.myforum.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户相关服务调用
 * @author Indexalice
 * @date 2018/4/24 22:20
 */
@Service
public class UserServiceImpl implements UserServiceI {

  private UserDaoI userDao;
  private LoginLogDaoI loginLogDao;

  @Autowired
  public void setUserDao(UserDaoI userDao) {
    this.userDao = userDao;
  }

  @Autowired
  public void setLoginLogDao(LoginLogDaoI loginLogDao) {
    this.loginLogDao = loginLogDao;
  }

  @Override
  public boolean hasMatchUser(String userName, String password) {
    int matchCount = userDao.getMatchCount(userName, password);
    return matchCount > 0;
  }

  @Override
  public User findUserByUserName(String userName) {
    return userDao.findUserByUserName(userName);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void loginSuccess(User user){
    user.setCredits(5+user.getCredits());
    LoginLog loginLog = new LoginLog();
    loginLog.setUserId(user.getUserId());
    loginLog.setIp(user.getLastIp());
    loginLog.setLoginDate(user.getLastVisit());
    userDao.updateLoginInfo(user);
    loginLogDao.saveLoginLog(loginLog);
  }
}
