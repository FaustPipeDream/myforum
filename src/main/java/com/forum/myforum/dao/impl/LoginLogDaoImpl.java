package com.forum.myforum.dao.impl;

import com.forum.myforum.dao.LoginLogDaoI;
import com.forum.myforum.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 更新用户登录信息
 * @author Indexalice
 * @date 2018/4/24 22:09
 */
@Repository
public class LoginLogDaoImpl implements LoginLogDaoI {

  private JdbcTemplate jdbcTemplate;

  @Override
  public void saveLoginLog(LoginLog loginLog) {
    String sqlStr = "INSERT INTO t_login_log(user_id,ip,login_datetime) VALUES(?,?,?)";
    Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
    jdbcTemplate.update(sqlStr, args);
  }

  @Autowired
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
}
