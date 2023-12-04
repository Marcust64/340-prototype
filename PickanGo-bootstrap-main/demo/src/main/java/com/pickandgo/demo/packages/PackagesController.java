package com.pickandgo.demo.packages;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;


import com.pickandgo.demo.user.User;
import com.pickandgo.demo.user.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class PackagesController {
    
    @Autowired

    private PackagesService packageService;
    @Autowired
    private UserService userService;
 

        @GetMapping("/user/library-user")
        public String getAllPackages(Model model) {
        model.addAttribute("packageList",
                packageService.getAllPackages());
        return "user/library-user";
    }
    

    @GetMapping("/search")
    public String getPackage(Model model, @Param("keyword") String keyword) {
        model.addAttribute("packageList",
                packageService.getAllPackages(keyword));
        model.addAttribute("keyword", keyword);
        return "user/library-user";
    }

    @GetMapping("/user/delete/id={packageId}")
    public String deletePackage(@PathVariable long packageId, Model model) {
        packageService.deletePackage(packageId);
        return "redirect:/user/library-user";
    }

    @GetMapping("/user/create-user")
    public String showCreateForm(){
        return "user/create-user";
    }
    
    @PostMapping("/package/create")
    public String createUserPackage(Packages packages) {
    // Save the package
    packageService.savePackage(packages);

    return "redirect:/user/library-user";
   }

    @GetMapping("/user/update/id={packageId}")
    public String updatePackageForm(@PathVariable long packageId, Model model) {
        model.addAttribute("package",
                packageService.getPackage(packageId));
        return "user/views-user";

    }

    
    @PostMapping("/update/id={packageId}")
    public String upatePackage(@PathVariable long packageId, @ModelAttribute Packages packages) {
        packageService.savePackage(packages);
        return "redirect:/user/library-user";
    }

    
     @GetMapping("/user/contact-user")
    public String showCcontactForm(){
        return "user/contact-user";
    }
   
     @GetMapping("/user/faq-user")
    public String showFaqForm(){
        return "user/faq-user";
    }
    
     @GetMapping("/user/index-user")
    public String showHomePage(){
        return "user/index-user";
    }
    
     @GetMapping("/user/signup-user")
    public String showSignUpForm(){
        return "user/signup-user";
    }
    
     @GetMapping("/user/sign-user")
    public String showSignInForm(){
        return "user/sign-user";
    }


    
    @GetMapping("/user/views-user")
    public String showEditForm(){
        return "user/views-user";
    }
}



