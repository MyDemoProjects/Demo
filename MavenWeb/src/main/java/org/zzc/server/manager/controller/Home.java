package org.zzc.server.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zzc.base.controller.BaseController;
import org.zzc.server.login.entity.SysUser;
import org.zzc.server.login.service.iservice.ISysUserService;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015/9/9 0009.
 */
@Controller
@RequestMapping("clientManager")
public class Home extends BaseController {

    @Resource
    private ISysUserService sysUserService;

    /*@ModelAttribute("sysUser")*/
    @RequestMapping({"/", "/index"})
    public String home(SysUser sysUser, ModelMap modelMap) {
        logger.info("跳转到后台管理...");
        sysUser = sysUserService.getRecordById(sysUser);
       /* modelMap.addAttribute("sysUser", sysUser);*/
        modelMap.put("sysUser", sysUser);
        return "server/manager/home";
    }
}
