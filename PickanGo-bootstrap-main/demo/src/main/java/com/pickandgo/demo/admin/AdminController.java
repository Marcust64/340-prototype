/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pickandgo.demo.admin;


import com.pickandgo.demo.packages.Packages; 
import jakarta.persistence.*;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.pickandgo.demo.user.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.pickandgo.demo.user.*;
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
 * @author 
 */
@Controller
public class AdminController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AdminServices adminServices;
    
    @GetMapping("/Admin/index")
    public String showHome() {
        return "Admin/index";
    }

    @GetMapping("/Admin/faq-admin")
    public String showFaq() {
        return "Admin/faq-admin";
    }

    @GetMapping("/Admin/contact-admin")
    public String showContact() {
        return "Admin/contact-admin";
    }

    @GetMapping("/Admin/searchresults")
    public String showResults(){
        return "Admin/searchresults";
    }
    @GetMapping("/Admin/views")
    public String showViews(){
        return "Admin/views";
    }
    @GetMapping("/Admin/library")
    public String showLibrary(){
        return "Admin/library";
    }
    @GetMapping("/Admin/pkgview")
    public String showpkgview(){
        return "Admin/pkgview";
    }
    
    @PostMapping("/Admin/contact-admin")
    public String saveContactInfo(@ModelAttribute ContactInfo contactInfo, RedirectAttributes redirectAttributes) {
        // Save contactInfo using AdminServices
        adminServices.saveContactInfo(contactInfo);

        // Add a success message or handle redirects as needed
        redirectAttributes.addFlashAttribute("successMessage", "ContactInfo saved successfully");

        return "redirect:/Admin/contact-admin";
    }

    @ModelAttribute("contactInfoList")
    public Iterable<ContactInfo> getAllContactInfo() {
        // Return all contactInfo using AdminServices
        return adminServices.getAllContactInfo();
    }
    @PostMapping("/deleteContactInfo")
    public String deleteContactInfo() {
        // Implement the logic to delete the contact information
        // Redirect to the page where you want to go after deletion
        return "redirect:/Admin/contact-admin";
    }


    
} 
  