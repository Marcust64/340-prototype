// package com.pickandgo.demo.packages;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;

// import com.pickandgo.demo.packages.PackagesService;
// import com.pickandgo.demo.packages.Packages;

// import java.util.List;


// @Controller
// @Component
// public class LibraryController {

//     // Autowire your PackagesService if you need to fetch package data
//     @Autowired
//     private PackagesService packageService;

//     @GetMapping("/library")
//     public String library(Model model) {
//         // Fetch package data and add it to the model
//         List<Packages> packages = packageService.getAllPackages();
//         model.addAttribute("packages", packages);

//         return "library"; // Name of your Thymeleaf template (library.html)
//     }

// // @PostMapping("/library")
// // public String addPackage(@ModelAttribute("newPackage") Packages newPackage, Model model) {
// //     // Logic to save the new package
// //     packageService.savePackage(newPackage);

// //     // Redirect to the library page to display the updated list of packages
// //     return "redirect:/library";
// // }


// // --------------------------------------------------
// // Tour Guide Controller

// @GetMapping("/TourGuide/index")
// public String showHome(){
//     return "TourGuide/index";
// }


//     @GetMapping("/TourGuide/library")
//     public String tourLibrary(Model model) {
//         // Fetch package data and add it to the model
//         List<Packages> packages = packageService.getAllPackages();
//         model.addAttribute("packages", packages);

//         return "TourGuide/library"; // Name of your Thymeleaf template (library.html)
//     }

// @PostMapping("/TourGuide/library")
// public String addPackage(@ModelAttribute("newPackage") Packages newPackage, Model model) {
//     // Logic to save the new package
//     packageService.savePackage(newPackage);

//     // Redirect to the library page to display the updated list of packages
//     return "redirect:/TourGuide/library";
// }



// }


package com.pickandgo.demo.PackagesTour;

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

@Controller
public class TourController {

    @Autowired
    private final TourPackagesService packageService;

    @Autowired
    private UserService userService;

    @Autowired
    public TourController(TourPackagesService packageService) {
        this.packageService = packageService;
    }


    @GetMapping("/TourGuide/index")
    public String showHome() {
        return "TourGuide/index";
    }

    @GetMapping("/TourGuide/library")
    public String library(Model model, Principal principal) {
        if (principal != null) {
            Optional<User> currentUser = userService.findByEmail(principal.getName());
            if (currentUser.isPresent()) {
                Long userId = currentUser.get().getUserId();
                List<TourPackagesDTO> userPackages = packageService.getPackagesForCurrentUser(userId);
                model.addAttribute("packages", userPackages);
            } else {
                // Handle the case where the user is not found
            }
        } else {
            // Handle the case where the user is not logged in
        }
        return "TourGuide/library";
    }

    @PostMapping("/TourGuide/library")
    public String addPackage(@ModelAttribute("newPackage") TourPackagesDTO newPackageDTO, Model model) {
        // Convert DTO to entity before saving
        TourPackages newPackage = packageService.convertToEntity(newPackageDTO);
        packageService.savePackage(newPackage);
        return "redirect:/TourGuide/library";
    }


}

