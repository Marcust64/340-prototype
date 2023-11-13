package com.pickandgo.demo.user;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author Marcus Thompson
*/

@Controller
public class UserController {

    @Autowired
    private UserService service;
    

    @Autowired
    //private PasswordEncoder passwordEncoder;
    
    @GetMapping("/sign")
    public String showSignInForm() {
//        User sample = new User(1, "s@com", "ADMIN", "123");
//        sample.setPassword(passwordEncoder.encode(sample.getPassword()));
//        service.saveUser(sample);        
        return "sign";
    }

    @PostMapping("/sign")
    public String signIn(@ModelAttribute("user") User user) {
        service.findByEmail(user.getEmail());
        System.out.println("HERE");
        return "redirect:/index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {        
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(User user) {
        System.out.println("!!!!!");
       // user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setTag("USER");

        //service.saveUser(user);
        return "redirect:/sign";
    }

}
