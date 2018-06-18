package com.forum.myforum.web;

import com.forum.myforum.domain.User;
import com.forum.myforum.service.UserServiceI;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录控制模块
 * @author Indexalice
 * @date 2018/6/18 15:05
 */
@RestController
public class LoginController {

  private UserServiceI userServiceI;
  @Autowired
  public void setUserServiceI(UserServiceI userServiceI){
    this.userServiceI = userServiceI;
  }

  @RequestMapping(value = {"/","/index.html"})
  public ModelAndView loginPage(){
   return new ModelAndView("login");
  }

  @RequestMapping(value = "/loginCheck.html")
  public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
    boolean isValidUser = userServiceI.hasMatchUser(loginCommand.getUserName(),loginCommand.getPassword());

    if(!isValidUser){
      return new ModelAndView("login","error","用户名或密码错误.");
    }else{
      User user = userServiceI.findUserByUserName(loginCommand.getUserName());
      user.setLastIp((request.getLocalAddr()));
      user.setLastVisit(new Date());
      userServiceI.loginSuccess(user);
      request.getSession().setAttribute("user",user);
      return new ModelAndView("main");
    }
  }
}
