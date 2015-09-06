package org.zzc.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * test controller
 * Created by Administrator on 2015/9/1 0001.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("gotoIndexTest")
    public String gotoIndexView() {
        return "test/index_test";
    }
}
