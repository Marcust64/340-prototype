package com.pickandgo.demo.user;

import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Marcus Thompson, Kenneth Alvarado, Duncan Normant
 */
@Controller
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/faq-admin")
    public String showUsers(Model model) {
        List<User> userList = service.getAllUsers();
        System.out.println("User List Size: " + userList.size()); // Print the size of the user list
        model.addAttribute("userList", userList);
        return "faq-admin";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Long userId) {
        service.deleteUser(userId);
        return "redirect:/users";
    }

    @GetMapping("/sign")
    public String showSignInForm() {
        return "sign";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        return "signup";
    }

    @GetMapping("/index")
    public String showIndexForm(Model model) {
        return "index";
    }

    @GetMapping("/searchresults")
    public String showResults() {
        return "searchresults";
    }

    @GetMapping("/faq")
    public String showFaq() {

        return "faq";
    }

    @GetMapping("/views")
    public String showView() {

        return "views";
    }

    @GetMapping("/contact")
    public String showContact(@RequestParam String param) {
        return "contact";
    }

    @PostMapping("/signup")
    public String signUp(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        service.saveUser(user);

        return "redirect:/sign";
    }

    @GetMapping("/403")
    public String show403Form(Model model) {
        return "403";
    }

}
