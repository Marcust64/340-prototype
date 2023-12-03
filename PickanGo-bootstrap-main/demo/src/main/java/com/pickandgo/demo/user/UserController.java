package com.pickandgo.demo.user;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/**
 *
 * @author Marcus Thompson
*/

@Controller
public class UserController {

    @Autowired
    private UserService service;
    

    @Autowired
    private PasswordEncoder passwordEncoder;
    
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

     @PostMapping("/signup")
     public String signUp(User user) {
         
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setTag("USER");
        
        service.saveUser(user);

       return "redirect:/sign";
     }
    /*
    // Method to handle the creation of a new package
    @PostMapping("/signup")
    public String createUser(@RequestParam String email, 
                                @RequestParam String password,
                                @RequestParam String tag,
                                RedirectAttributes redirectAttributes) {
        try {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setTag(tag);
            

            User savedUser = service.saveUser(newUser);
            
            
            redirectAttributes.addFlashAttribute("message", "User created successfully!");

            // Redirect to the home page
            return "redirect:/index";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error creating user");
            return "redirect:/index"; // or wherever you want to redirect in case of error
        }
        */ 

}
