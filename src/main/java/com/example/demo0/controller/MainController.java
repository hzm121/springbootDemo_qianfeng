package com.example.demo0.controller;

import com.example.demo0.entity.Auser;
import com.example.demo0.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : hzm
 * @date : 2020-02-04 15:51
 */
@Controller
public class MainController {
    @RequestMapping(value = {"index","hello"},method = RequestMethod.GET)
    public String index(Model model){
        Auser user = new Auser();
        user.setName("hzm");
        model.addAttribute("user",user);
            return "index";
    }
}
