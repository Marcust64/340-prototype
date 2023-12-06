package com.pickandgo.demo.PackagesTour;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import com.pickandgo.demo.Applications.ApplicationService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ViewsController {

    private final TourPackagesService packagesService;
    private final ApplicationService applicationService; 

    @Autowired
    public ViewsController(TourPackagesService packagesService, ApplicationService applicationService) {
        this.packagesService = packagesService;
        this.applicationService = applicationService; 
    }

    // @GetMapping("/TourGuide/views/{packageId}")
    // public String showPackageDetails(@PathVariable Long packageId, Model model) {
    //     Optional<TourPackagesDTO> packageOpt = packagesService.getPackageDTO(packageId);
    //     if (packageOpt.isPresent()) {
    //         TourPackagesDTO packageDTO = packageOpt.get();
    //         model.addAttribute("package", packageDTO);

    //         List<String> usernames = applicationService.getUsernamesByPackageId(packageId);
    //         model.addAttribute("usersApplied", usernames);
    //     } else {
    //     }
    //     return "TourGuide/views"; 
    // }

    @GetMapping("/TourGuide/views/{packageId}")
public String showPackageDetails(@PathVariable Long packageId, Model model) {
    Optional<TourPackagesDTO> packageOpt = packagesService.getPackageDTO(packageId);
    if (packageOpt.isPresent()) {
        TourPackagesDTO packageDTO = packageOpt.get();
        model.addAttribute("package", packageDTO);

        String usernames = applicationService.getUsernamesAsStringByPackageId(packageId);
        model.addAttribute("usernames", usernames);
        //model.addAttribute("usersApplied", usernames);
    } else {
        // Package not found scenario
    }
    return "TourGuide/views"; 
}


    @GetMapping("/TourGuide/pkgview/{packageId}")
    public String showSearchView(@PathVariable Long packageId, Model model) {
        Optional<TourPackagesDTO> packageOpt = packagesService.getPackageDTO(packageId);
        if (packageOpt.isPresent()) {
            TourPackagesDTO packageDTO = packageOpt.get();
            model.addAttribute("package", packageDTO);
        } else {

        }
        return "TourGuide/pkgview";
    }

    
 
    

 
    
    


}
