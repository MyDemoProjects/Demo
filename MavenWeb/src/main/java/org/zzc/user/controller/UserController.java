package org.zzc.user.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zzc.user.entity.User;
import org.zzc.user.service.iservice.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户信息Controller
 * Created by Administrator on 2015/8/26 0026.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Resource(name = "userService")
    IUserService userService;

    @RequestMapping("/userInfo")
    public String gotoUserPage(ModelMap modelMap, User user, HttpServletRequest request, HttpServletResponse response) {
        user = userService.getRecordById(user);
        logger.info(user);
        return "user/user_info";
    }

}
