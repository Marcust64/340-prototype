package com.pickandgo.demo.packages;

import com.pickandgo.demo.user.User;
import com.pickandgo.demo.user.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;


import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class PackagesController {
    
    @Autowired
    private PackagesService packageService;
    
    @Autowired
    private UserService userService;
 

        @GetMapping("/user/library-user")
        public String getAllPackages(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Optional<User> user = userService.findByEmail(currentUserName);
        model.addAttribute("packageList", packageService.getUserPackages(null, user.get()));
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
    public String createPackage(@RequestParam String name,
                                @RequestParam String city,
                                 @RequestParam(required = false) Integer capacity,
                                @RequestParam(required = false) String contact,
                                @RequestParam String description,
                                @RequestParam(required = false) String service,
                                RedirectAttributes redirectAttributes) {
    
            Packages newPackage = new Packages();
            newPackage.setName(name);
            newPackage.setCity(city);
            if (capacity != null) {
            newPackage.setCapacity(capacity.intValue());
                }
            newPackage.setContact(contact);
            newPackage.setDescription(description);
            newPackage.setService(service);

            // Set the user who creates the package
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = authentication.getName();
            Optional<User> user = userService.findByEmail(currentUserName);
            user.ifPresent(newPackage::setUser);

            packageService.savePackage(newPackage);


            // Redirect to the library page
            return "redirect:/user/library-user";
        }
 

    @GetMapping("/user/update/id={packageId}")
    public String updatePackageForm(@PathVariable long packageId, Model model) {
        model.addAttribute("package",
                packageService.getPackage(packageId));
        return "user/views-user";

    }

    // Method to handle the creation of a new package
    @PostMapping("/api/packages/create")
    public String createPackage(Packages packages) {

        // Save the package
         packageService.savePackage(packages);

            // Redirect to the library page
            return "redirect:/library";
     
    }

    // Method to retrieve all packages
    @GetMapping("/api/packages")
    public ResponseEntity<List<Packages>> getAllPackages() {
        try {
            List<Packages> packages = packageService.getAllPackages();
            if (packages.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(packages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    // Method to delete a package by ID
    @DeleteMapping("/api/packages/{id}")
    public ResponseEntity<HttpStatus> deletePackage(@PathVariable Long id) {
        try {
            packageService.deletePackage(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
     
    @GetMapping("/user/views-user")
    public String showEditForm(){
        return "user/views-user";
    }

}

