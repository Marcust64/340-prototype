// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
//  */
// package com.pickandgo.demo.Applications;

// import com.pickandgo.demo.PackagesTour.TourPackages;
// import com.pickandgo.demo.PackagesTour.TourPackagesService;
// import com.pickandgo.demo.user.User;
// import com.pickandgo.demo.user.UserService;
// import java.util.Map;
// import java.util.Optional;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.repository.query.Param;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;

// /**
//  *
//  * @author Marcus Thompson
//  */
// @Controller
// public class ApplicationController {
    
//     @Autowired
//     private ApplicationService service;
    
//     @Autowired
//     private TourPackagesService TourPackagesService;
    
//     @Autowired
//     private UserService userService;
    
    
//     @PostMapping("/application")
//     public String applyForPackage(@RequestParam Long packageId) {
   
//             TourPackages tourPackage = TourPackagesService.findByPackageId(packageId);

//                 service.copyTourPackageToApplication(tourPackage);

               
//                  return "user/searchresults-user";
//     }
    
//     @GetMapping("/user/searchresults-user")
//     public String showSearchForm(){
    
//     return "user/searchresults-user";
//     }
    
//     @GetMapping("/application/display")
//         public String getAllPackages(Model model) {
//         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//         String currentUserName = authentication.getName();
//         Optional<User> user = userService.findByEmail(currentUserName);
//         model.addAttribute("packageList", service.getUserPackages(null, user.get()));
//         return "user/applications-user";
//     }
        
//     @GetMapping("/application/id={packageId}")
//     public String getUpdatePackageForm(@PathVariable long packageId, Model model) {
//     Optional<Application> applicationOptional = service.getPackage(packageId);
    
//     applicationOptional.ifPresent(application -> {
        
//         model.addAttribute("package", application);
//     });
//     return "user/applications-views";
//     }
    
//     @GetMapping("/application/delete/id={packageId}")
//     public String deletePackage(@PathVariable long packageId, Model model) {
//         service.deletePackage(packageId);
//         return "redirect:/application/display";
//     }
    
//     @GetMapping("application/search")
//     public String getPackage(Model model, @Param("keyword") String keyword) {
//         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//         String currentUserName = authentication.getName();
//         Optional<User> user = userService.findByEmail(currentUserName);
//         model.addAttribute("packageList", service.getUserPackages(null, user.get()));
//         model.addAttribute("keyword", keyword);
//         return "user/applications-user";
//     }
    
    
        
// }


package com.pickandgo.demo.Applications;

import com.pickandgo.demo.PackagesTour.TourPackages;
import com.pickandgo.demo.PackagesTour.TourPackagesService;
import com.pickandgo.demo.user.User;
import com.pickandgo.demo.user.UserService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    @Autowired
    private TourPackagesService tourPackagesService;

    @Autowired
    private UserService userService;

    @PostMapping("/application")
    public String applyForPackage(@RequestParam Long packageId, Authentication authentication) {
        User user = userService.findByEmail(authentication.getName())
                               .orElseThrow(() -> new RuntimeException("User not found"));
        TourPackages tourPackage = tourPackagesService.findByPackageId(packageId);


        Application application = new Application();
        application.setUser(user);
        application.setTourPackage(tourPackage);
        service.saveApplication(application);

        return "user/searchresults-user";
    }

    @GetMapping("/user/searchresults-user")
    public String showSearchForm() {
        return "user/searchresults-user";
    }

    // @GetMapping("/application/display")
    // public String getAllPackages(Model model, Authentication authentication) {
    //     User user = userService.findByEmail(authentication.getName())
    //                            .orElseThrow(() -> new RuntimeException("User not found"));
    //     model.addAttribute("packageList", service.getUserPackages(user));
    //     return "user/applications-user";
    // }

    @GetMapping("/application/display")
public String displayUserApplications(Model model, Authentication authentication) {
    String userEmail = authentication.getName();
    User currentUser = userService.findByEmail(userEmail).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    List<Application> userApplications = service.getUserPackages(currentUser);
    model.addAttribute("applications", userApplications);
    return "user/applications-user";
}


@GetMapping("/application/id={id}")
public String viewApplication(Model model, @PathVariable Long id) {
    Application app = service.getApplicationById(id);
    model.addAttribute("app", app);
    return "user/applications-views";
}

    @GetMapping("/application/delete/id={packageId}")
    public String deletePackage(@PathVariable long packageId) {
        service.deletePackage(packageId);
        return "redirect:/application/display";
    }

}

