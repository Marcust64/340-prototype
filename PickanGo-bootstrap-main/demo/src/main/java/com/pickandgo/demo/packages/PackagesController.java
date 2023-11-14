package com.pickandgo.demo.packages;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pickandgo.demo.packages.Packages;
import com.pickandgo.demo.packages.PackagesService;

import java.util.List;


/**
 *
 * @author Marcus Thompson
 */
@Controller
public class PackagesController {
    
    @Autowired
    PackagesService packageService;
 

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
        
        packageService.savePackage(packages);
        return "redirect:/user/library-user";
    }

    @GetMapping("/user/update/id={packageId}")
    public String updatePackageForm(@PathVariable long packageId, Model model) {
        model.addAttribute("package",
                packageService.getPackage(packageId));
        return "user/views-user";

    }

    // Method to handle the creation of a new package
    @PostMapping("/api/packages")
    public ResponseEntity<Packages> createPackage(@RequestBody Packages packages) {
        try {
            Packages newPackage = packageService.savePackage(packages);
            return new ResponseEntity<>(newPackage, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
     
    @GetMapping("/user/views-user")
    public String showEditForm(){
        return "user/views-user";
    }
}
