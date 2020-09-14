package gachostyle.magazine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class shop {

    @GetMapping("/shop")
    public String gachoHome(){
        return "shop";
    }
}
