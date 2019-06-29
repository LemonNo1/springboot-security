package atshenma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/deleteOrder")
    public String delete() {
        return "deleteOrder";
    }

    @RequestMapping("/updateOrder")
    public String update() {
        return "updateOrder";
    }

    @RequestMapping("/showOrder")
    public String list() {
        return "showOrder";
    }

    @RequestMapping("/addOrder")
    public String add() {
        return "addOrder";
    }
}
