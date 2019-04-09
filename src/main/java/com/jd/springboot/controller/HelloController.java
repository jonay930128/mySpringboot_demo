package com.jd.springboot.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * 请填写类的描述
 *
 * @author wangruxing
 * @date 2018-04-08 11:55
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/success",method = RequestMethod.GET)
    public String success(Model model){
        model.addAttribute("hello","hello thymeleaf");
        List<String> list = Arrays.asList("a", "b", "c");
        model.addAttribute("list",list);
        return "success";
    }

    @ApiOperation(value="hello", notes="测试")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    @RequestMapping(value = "/testError",method = RequestMethod.GET)
    @ResponseBody
    public String error() throws Exception{
        throw new Exception("测试错误");
    }
}
