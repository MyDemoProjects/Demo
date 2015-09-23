package org.zzc.server.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzc.server.manager.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * menu controller
 * Created by Administrator on 2015/9/23 0023.
 */
@Controller
@RequestMapping("/managerMenu")
public class MenuController {

    @RequestMapping("/getMenu")
    @ResponseBody
    public void getManagerMenu() {
        List<Menu> menuList = new ArrayList<Menu>();
    }
}
