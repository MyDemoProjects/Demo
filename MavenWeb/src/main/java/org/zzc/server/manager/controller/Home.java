package org.zzc.server.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zzc.server.login.entity.SysUser;
import org.zzc.server.login.service.iservice.ISysUserService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015/9/9 0009.
 */
@Controller
@RequestMapping("clientManager")
public class Home {

    @Resource
    private ISysUserService sysUserService;

    /*@ModelAttribute("sysUser")*/
    @RequestMapping({"/", "/index"})
    public String home(SysUser sysUser, ModelMap modelMap) {
        sysUser = sysUserService.getRecordById(sysUser);
       /* modelMap.addAttribute("sysUser", sysUser);*/
        modelMap.put("sysUser", sysUser);
        return "server/manager/home";
    }
}
