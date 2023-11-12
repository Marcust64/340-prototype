package com.pickandgo.demo.packages;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


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
/*
    @GetMapping("/search")
    public String getPackage(Model model, @Param("keyword") String keyword) {
        model.addAttribute("packageList",
                packageService.getAllPackages(keyword));
        model.addAttribute("keyword", keyword);
        return "user/library-user";
    }
*/
    @GetMapping("/user/id={packageId}")
    public String getPackage(@PathVariable long packageId, Model model) {
        model.addAttribute("product",
                packageService.getPackage(packageId));
        return "product/views-user";
    }
/*
    @GetMapping("/user/delete/id={packageId}")
    public String deletePackage(@PathVariable long packageId, Model model) {
        packageService.deletePackage(packageId);
        return "redirect:user/library-user";
    }
*/
    @GetMapping("/user/create-user")
    public String showCreateForm(){
        return "user/create-user";
    }
    
    @PostMapping("/package/create")
    public String createPackage(Packages packages) {
        
        packageService.savePackage(packages);
        return "redirect:/user/library-user";
    }
/*
    @PostMapping("/update")
    public String upateProduct(Packages packages) {
        packageService.savePackage(packages);
        return "redirect:/product/all";
    }

    @GetMapping("/new-product")
    public String newProductForm(Model model) {
        return "product/new-product";
    }
*/
    @GetMapping("/update/id={packageId}")
    public String updateProductForm(@PathVariable long packageId, Model model) {
       // model.addAttribute("product",
                //packageService.getPackage(packageId));
        return "user/views-user";
    }
     
}
