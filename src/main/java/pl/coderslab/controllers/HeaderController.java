package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class HeaderController {

    @GetMapping("/showUserAgent")
    public String showAgentDetails(@RequestHeader("user-agent") String header, Model model){
        model.addAttribute("header",header);
        return "userAgent";
    }
}
