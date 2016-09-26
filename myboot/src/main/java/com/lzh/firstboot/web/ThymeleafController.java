package com.lzh.firstboot.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 作者： Jonathan
 * 创建时间： 2016/9/26 ${Time}.
 * ThymeleafController的描述：${DESCRIPTION}
 */
@Api("测试Thymeleaf和devtools")
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    @ApiOperation("第一个thymeleaf程序")
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "world") String name,
                           Model model) {
        model.addAttribute("xname", name);
        return "greet";
    }
}
