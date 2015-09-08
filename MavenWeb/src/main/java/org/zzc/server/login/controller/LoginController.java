package org.zzc.server.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzc.base.model.entity.MsgInfo;

/**
 * 登录controller
 * Created by Administrator on 2015/9/8 0008.
 */
@Controller
@RequestMapping("/clientHome")
public class LoginController {

    @RequestMapping({"/", "/home"})
    public String gotoLogin() {
        return "server/login/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public MsgInfo login() {
        MsgInfo msgInfo = new MsgInfo();
        msgInfo.setId(1);
        msgInfo.setMsg("成功");
        return msgInfo;
    }
}
