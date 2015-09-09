package org.zzc.server.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzc.base.model.entity.MsgInfo;
import org.zzc.server.login.entity.SysUser;
import org.zzc.server.login.service.iservice.ISysUserService;

import javax.annotation.Resource;

/**
 * 登录controller
 * Created by Administrator on 2015/9/8 0008.
 */
@Controller
@RequestMapping("/clientHome")
public class LoginController {

    @Resource(name = "sysUserService")
    private ISysUserService sysUserService;

    @RequestMapping({"/", "/home"})
    public String gotoLogin() {
        return "server/login/login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public MsgInfo login(SysUser sysUser) {
        MsgInfo msgInfo = new MsgInfo();
        SysUser queryParam = new SysUser(), resultInfo;
        queryParam.setAccount(sysUser.getAccount());
        resultInfo = sysUserService.getRecordById(queryParam);
        if (resultInfo == null) {
            msgInfo.setMsg("账户不存在");
            return msgInfo;
        }
        resultInfo = null;
        queryParam.setPassword(sysUser.getPassword());
        resultInfo = sysUserService.getRecordById(queryParam);
        if (resultInfo == null) {
            msgInfo.setMsg("密码不正确");
            return msgInfo;
        }
        resultInfo = null;
        queryParam.setStatus("1");
        resultInfo = sysUserService.getRecordById(queryParam);
        if (resultInfo == null) {
            msgInfo.setMsg("账号状态不正常,请联系客服");
            return msgInfo;
        }
        msgInfo.setId(1);
        msgInfo.setMsg("登录成功");
        return msgInfo;
    }
}
