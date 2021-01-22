package gachostyle.magazine.controllers;

import gachostyle.magazine.models.Image;
import gachostyle.magazine.repositories.ImageRepository;
import gachostyle.magazine.repositories.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Art {

    private ImageRepository imageDao;
    private Users userDao;


    public Art(Users userDao, ImageRepository imageDao) {
        this.userDao = userDao;
        this.imageDao = imageDao;
    }

    @GetMapping("/art")
    public String artPage(Model model) {

//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("images", new Image());

//        User admin = userDao.getOne(loggedInUser.getId());
//        model.addAttribute("admin", admin);
        return "art";
    }

    @PostMapping("/art")
    public String saveImage()

//    @GetMapping("/art/{id}")
//    public String artForm(@PathVariable("id") long id,Model model) {


//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        User admin = (User) userDao.findByUsername(loggedInUser.getUsername());
//
//        User admin = userDao.getOne(loggedInUser.getId());
//        model.addAttribute("admin", admin);

//        return "art" + admin;
//    }
}
