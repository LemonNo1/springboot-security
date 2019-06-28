package atshenma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 */
@Controller
public class MainController {

    @RequestMapping("/index")
    public String index(){
        return "product/index";
    }

    @RequestMapping("/noAuth")
    public String noAuth(){
        return "error/403";
    }

    @RequestMapping("/login")
    public String login(){
        return "login.html";
    }
}