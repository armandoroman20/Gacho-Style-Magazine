package gachostyle.magazine.controllers;

import gachostyle.magazine.models.Image;
import gachostyle.magazine.models.User;
import gachostyle.magazine.repositories.ImageRepository;
import gachostyle.magazine.repositories.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class Art {

    private ImageRepository imageDao;
    private Users userDao;


    public Art(Users userDao, ImageRepository imageDao) {
        this.userDao = userDao;
        this.imageDao = imageDao;
    }

//    @GetMapping("/art")
//    public String artPage(Model model) {
//
//        model.addAttribute("artImages", imageDao.findAll());
////        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        model.addAttribute("newImage", new Image());
//
////        User admin = userDao.getOne(loggedInUser.getId());
////        model.addAttribute("admin", admin);
//        return "art";
//    }




//    @GetMapping("/art/{id}")
//    public String artForm(@PathVariable("id") long id,Model model) {


//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        User admin = (User) userDao.findByUsername(loggedInUser.getUsername());
//
//        User admin = userDao.getOne(loggedInUser.getId());
//        model.addAttribute("admin", admin);

//        return "art" + admin;
//    }


    @GetMapping("/art")
    public String showCreateForm(Model model) {
        model.addAttribute("artImages", imageDao.findAll());
        model.addAttribute("image", new Image());

        return "/art";
    }


    @PostMapping("/art")
    public String create(
            @RequestParam(name = "description") String description, @ModelAttribute Image newImage, Model model
    ) {
        Image image = new Image();
        image.setDescription(description);
        imageDao.save(image);
        model.addAttribute("newImage", image);

        // save the ad...
        return "art";
    }
}
