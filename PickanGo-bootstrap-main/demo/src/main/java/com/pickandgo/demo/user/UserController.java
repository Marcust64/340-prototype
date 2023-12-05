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

    @GetMapping("/searchresults")
    public String showResults(){
        return "searchresults";
    }

    @GetMapping("/faq")
    public String showFaq(){

        return "faq";
    }

   @GetMapping("/views")
    public String showView(){

        return "views";
    }

     @PostMapping("/signup")
     public String signUp(User user) {
         
        user.setPassword(passwordEncoder.encode(user.getPassword()));

       // user.setTag("USER");
        
        service.saveUser(user);

       return "redirect:/sign";
     }
     
     @GetMapping("/403")
    public String show403Form(Model model) {        
        return "403";
    }



}
