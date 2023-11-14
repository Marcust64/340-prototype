package com.pickandgo.demo.packages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pickandgo.demo.packages.PackagesService;
import com.pickandgo.demo.packages.Packages;

import java.util.List;


@Controller
@Component
public class LibraryController {

    // Autowire your PackagesService if you need to fetch package data
    @Autowired
    private PackagesService packageService;

    @GetMapping("/library")
    public String library(Model model) {
        // Fetch package data and add it to the model
        List<Packages> packages = packageService.getAllPackages();
        model.addAttribute("packages", packages);

        return "library"; // Name of your Thymeleaf template (library.html)
    }

@PostMapping("/library")
public String addPackage(@ModelAttribute("newPackage") Packages newPackage, Model model) {
    // Logic to save the new package
    packageService.savePackage(newPackage);

    // Redirect to the library page to display the updated list of packages
    return "redirect:/library";
}


}
