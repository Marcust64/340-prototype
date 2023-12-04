package com.pickandgo.demo.PackagesTour;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;


@Controller
public class ViewsController {

    private final TourPackagesService packagesService;

    @Autowired
    public ViewsController(TourPackagesService packagesService) {
        this.packagesService = packagesService;
    }

    @GetMapping("/TourGuide/views/{packageId}")
    public String showPackageDetails(@PathVariable Long packageId, Model model) {
        Optional<TourPackagesDTO> packageOpt = packagesService.getPackageDTO(packageId);
        if (packageOpt.isPresent()) {
            TourPackagesDTO packageDTO = packageOpt.get();
            model.addAttribute("package", packageDTO);
        } else {

        }
        return "TourGuide/views"; 
    }

    

    @GetMapping("/contact")
    public String showContact(){
        return "contact";
    }
    
    


}
