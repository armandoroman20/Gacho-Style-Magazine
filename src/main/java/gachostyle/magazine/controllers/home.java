package gachostyle.magazine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home {

    @GetMapping("/")
    public String gachoHome(){
//        return "Gacho-home";
        return "home-two";
    }
}
