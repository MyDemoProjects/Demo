package org.zzc.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户信息Controller
 * Created by Administrator on 2015/8/26 0026.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("userInfo")
    public String gotoUserPage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "user/user_info";
    }
}
