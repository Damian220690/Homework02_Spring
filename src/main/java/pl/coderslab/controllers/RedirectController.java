package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/first")
    public String showFirstPage(){
        return "first";
    }

    @GetMapping("/third")
    public String showThirdPage(){
        return "third";
    }

    @GetMapping("/second")
    public String redirectToSecond(){
        return "redirect:third";
    }

}
