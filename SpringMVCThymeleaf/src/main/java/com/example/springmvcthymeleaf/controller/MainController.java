package com.example.springmvcthymeleaf.controller;

import com.example.springmvcthymeleaf.model.Product;
import com.example.springmvcthymeleaf.service.LoginCountService;
import com.example.springmvcthymeleaf.service.LoginProcessor;
import com.example.springmvcthymeleaf.service.ProductService;
import com.example.springmvcthymeleaf.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController {

    @Autowired
    LoginProcessor lp;

    @Autowired
    UserManagementService ums;

    @Autowired
    LoginCountService count;

    @Autowired
    private ProductService ps;

    @RequestMapping("/home")
    public String home(@RequestParam String user,
            @RequestParam (required = false) String role, Model model, int i) {
        model.addAttribute("user", user);
        model.addAttribute("role", role);
        return "index";
    }

    @RequestMapping("/home/{user}")
    public String home(@PathVariable String user, Model model) {
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/")
    public String home(@RequestParam (required = true) String username, @RequestParam String password, Model model) {

        LoginProcessor login = new LoginProcessor(ums);
        login.setUser(username);
        login.setPass(password);

        if (login.isAuthenticated()) {
            model.addAttribute("message", "Successfully authenticated");
            model.addAttribute("user", "Welcome " + ums.getUsername());
            count.clearCount();
            return "authenticated";
        } else {
            count.inc();
        }

        model.addAttribute("message", "Incorrect Login Count #" + count.getCount());

        return "index";

    }



    @RequestMapping("/scopes/request")
    public String getRequestScope(final Model model) {
        model.addAttribute("prev", lp.getCount());
        lp.incCount();
        model.addAttribute("curr", lp.getCount());
        return "index";
    }

    @RequestMapping("/scopes/session")
    public String getSessionScope(final Model model) {
        model.addAttribute("prev", lp.getCount());
        lp.incCount();
        model.addAttribute("curr", lp.getCount());
        return "index";
    }

    @PostMapping("/logout")
    public String logout() {
        ums.setUsername(null);

        return "redirect:/";
    }

    @PostMapping("/authenticated")
    public String auth() {
        if (ums.getUsername() != null) {
            return "authenticated";
        }
        return "redirect:/";
    }


}
