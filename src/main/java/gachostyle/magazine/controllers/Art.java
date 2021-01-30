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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
//        User loggedIn = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("loggedIn", loggedIn);
//        model.addAttribute("test", userDao.findAll());
        model.addAttribute("artImages", imageDao.findAll());
        model.addAttribute("image", new Image());

        return "/art";
    }


//    @PostMapping("/art")
//    public String create(
//            @RequestParam(name = "description") String description, @ModelAttribute Image newImage, Model model
//    ) {
//        Image image = new Image();
//        image.setDescription(description);
//        imageDao.save(image);
//        model.addAttribute("newImage", image);
//
//        // save the Image ...
//        return "redirect:/art";
//    }

    @GetMapping("/post")
    public String showPostForm(Image image) {
        return "art";
    }

    @PostMapping("/addpost")
    public String addPost(@Valid Image image, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "art";
        }

        imageDao.save(image);
        return "redirect:/art";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("image", imageDao.getOne(id));
        Image image = imageDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid image Id:" + id));
        model.addAttribute("image", image);
        return "art";
    }

    @PostMapping("/update/{id}")
    public String updatePost(@PathVariable("id") Long id, @Valid Image image,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            image.setId(id);
            return "art";
        }

        imageDao.save(image);
        return "redirect:/art";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Long id, Model model) {
        Image image = imageDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid image Id:" + id));
        imageDao.delete(image);
        return "redirect:/art";
    }
}
