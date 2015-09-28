package org.zzc.server.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zzc.base.controller.BaseController;
import org.zzc.server.login.entity.SysUser;
import org.zzc.server.login.service.iservice.ISysUserService;
import org.zzc.server.manager.entity.Menu;

import javax.annotation.Resource;
import java.util.List;

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
        logger.info(sysUser);
        List<Menu> firstMenu = sysUser.getMenus();
        for(Menu m : firstMenu) {
            logger.info("************************");
            logger.info("一级菜单：" + m.getMenuName());
            if(m.getSubMenus().size() > 0) {
                for(Menu mn : m.getSubMenus()) {
                    logger.info("二级菜单：" + mn.getMenuName());
                }
            }
            logger.info("************************");
        }
       /* modelMap.addAttribute("sysUser", sysUser);*/
        modelMap.put("sysUser", sysUser);
        return "server/manager/home";
    }
}
