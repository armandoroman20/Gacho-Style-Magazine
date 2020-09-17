package gachostyle.magazine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Art {
    @GetMapping("/art")
    public String artPage(){
        return "art";
    }
}
