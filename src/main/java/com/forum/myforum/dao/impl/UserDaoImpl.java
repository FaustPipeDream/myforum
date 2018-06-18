package com.forum.myforum.dao.impl;

import com.forum.myforum.dao.UserDaoI;
import com.forum.myforum.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Indexalice
 * @date 2018/4/15 10:42
 */
@Repository
public class UserDaoImpl implements UserDaoI {

  private JdbcTemplate jdbcTemplate;

  @Override
  public int getMatchCount(String userName, String password) {
    String sqlStr = " SELECT count(*) FROM t_user WHERE user_name =? and password=? ";
    return jdbcTemplate.queryForObject(sqlStr, int.class, new Object[]{userName, password});
  }

  @Override
  public User findUserByUserName(String userName) {
    String findUserSql = "SELECT * FROM t_user WHERE user_name =?  ";
    final User user = new User();
    jdbcTemplate.query(findUserSql, new Object[]{userName},
        resultSet -> {
          user.setUserId((resultSet.getInt("user_id")));
          user.setUserName(userName);
          user.setCredits(resultSet.getInt("credits"));
        });
    return user;
  }

  @Override
  public void updateLoginInfo(User user) {
    String sqlStr = "UPDATE t_user SET last_visit=?,last_ip=?,credits=? WHERE user_id=?";
    jdbcTemplate.update(sqlStr,
        new Object[]{user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()});
  }

  @Autowired
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
}
