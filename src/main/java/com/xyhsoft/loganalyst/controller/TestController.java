package com.xyhsoft.loganalyst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping
    public ModelAndView method1(){
        return new ModelAndView("test","msg","oops!!");
    }
}
