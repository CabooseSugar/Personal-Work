package com.starrockgames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping("/about-us")
    public String aboutUsPage() {
        return "about";
    }

    @GetMapping("/contact-us")
    public String contactUsPage() {
        return "contact";
    }

    @GetMapping("/careers")
    public String careersPage() {
        return "careers";
    }


}
