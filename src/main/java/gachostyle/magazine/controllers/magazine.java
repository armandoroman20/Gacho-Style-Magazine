package gachostyle.magazine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class magazine {

    @GetMapping("/magazine")
    public String gachoRead(){
        return "magazine";
    }
}
