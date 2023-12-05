package com.pickandgo.demo.packages;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Optional<User> user = userService.findByEmail(currentUserName);
        model.addAttribute("packageList", packageService.getUserPackages(null, user.get()));
        return "user/library-user";
    }
    

    @GetMapping("/search")
    public String getPackage(Model model, @Param("keyword") String keyword) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        Optional<User> user = userService.findByEmail(currentUserName);
        
         List<Packages> searchResults = packageService.search(keyword);
         
         model.addAttribute("packageList", searchResults);
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
                                @RequestParam String description,
                                RedirectAttributes redirectAttributes) {
    
            Packages newPackage = new Packages();
            newPackage.setName(name);
            newPackage.setCity(city);
            newPackage.setDescription(description);

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
    Optional<Packages> packageOptional = packageService.getPackage(packageId);
    model.addAttribute("package", packageOptional.orElse(null));
    return "user/views-user";
    }

    @PostMapping("/update/id={packageId}")
    public String updatePackage(@PathVariable long packageId, @ModelAttribute Packages packages) {

    Optional<Packages> packageOptional = packageService.getPackage(packageId);
    packageOptional.ifPresent(existingPackage -> {
    existingPackage.setName(packages.getName());
    existingPackage.setCity(packages.getCity());
    existingPackage.setDescription(packages.getDescription());
    
    packageService.savePackage(existingPackage);
    });
    return "redirect:/user/library-user";
    }

    
    @GetMapping("/user/contact-user")
    public String showContactForm(){
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

    @GetMapping("/user/views-user")
    public String showEditForm(){
        return "user/views-user";
    }

}
