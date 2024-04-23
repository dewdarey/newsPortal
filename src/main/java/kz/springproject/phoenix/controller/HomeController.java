package kz.springproject.phoenix.controller;

import kz.springproject.phoenix.model.User;
import kz.springproject.phoenix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String indexPage() {
        return "index";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(value = "/sign-in")
    public String signInPage() {
        return "sign-in";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(value = "/sign-up")
    public String signUpPage() {
        return "sign-up";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profilePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UserDetails userDetails = userService.loadUserByUsername(username);
        if (userDetails instanceof User) {
            User user = (User) userDetails;
            model.addAttribute("user", user);
            return "profile";
        } else {
            return "/";
        }

    }


    @PostMapping(value = "signup")
    public String signUp(@RequestParam(name = "username") String username,
                         @RequestParam(name = "full_name") String fullName,
                         @RequestParam(name = "password") String password,
                         @RequestParam(name = "repeat_password") String repeatPassword,
                         @RequestParam(name = "avatar_url") String avatarUrl) {
        if (password.equals(repeatPassword)) {
            User user = new User();
            user.setUsername(username);
            user.setFullName(fullName);
            user.setPassword(password);
            user.setAvatarUrl(avatarUrl);
            User newUser = userService.addUser(user);
            if (newUser != null) {
                return "redirect:/sign-up?success";
            } else {
                return "redirect:/sign-up?usernameerror";
            }
        } else {
            return "redirect:/sign-up?passworderror";
        }
    }

}
