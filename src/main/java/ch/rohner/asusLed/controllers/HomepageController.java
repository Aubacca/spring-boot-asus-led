package ch.rohner.asusLed.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {

    @RequestMapping("/dashboard")
    public String dashboardpage() {
        return "dashboard.jsp";
    }

    @RequestMapping("/")
    public String homepage() {
        return "home.jsp";
    }
}
