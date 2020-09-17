package gachostyle.magazine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class music {
    @GetMapping("/music")
    public String gachoMusic(){
        return "music";
    }
}
