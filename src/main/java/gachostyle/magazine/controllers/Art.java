package gachostyle.magazine.controllers;

import gachostyle.magazine.models.User;
import gachostyle.magazine.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class Art {

    private Users userDao;


    public Art(Users userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/art")
    public String artPage() {
        return "art";
    }


    @GetMapping("/art/{id}")
    public String artForm(@PathVariable("id") long id,Model model) {


        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User admin = userDao.getOne(loggedInUser.getId());
        model.addAttribute("admin", admin);

        return "art" + admin;
    }
}
