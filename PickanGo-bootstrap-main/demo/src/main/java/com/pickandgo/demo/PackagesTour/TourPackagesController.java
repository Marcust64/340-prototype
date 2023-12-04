package com.pickandgo.demo.PackagesTour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.pickandgo.demo.user.User;
import com.pickandgo.demo.user.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class TourPackagesController {

    @Autowired
    private TourPackagesService packageService;

    @Autowired
    private UserService userService;


    @PostMapping("/api/packages/create")
    public String createPackage(@RequestParam String name,
                                @RequestParam String city,
                                @RequestParam int capacity,
                                @RequestParam String contact,
                                @RequestParam String description,
                                @RequestParam String service,
                                RedirectAttributes redirectAttributes) {
        try {
            TourPackages newPackage = new TourPackages();
            newPackage.setName(name);
            newPackage.setCity(city);
            newPackage.setCapacity(capacity);
            newPackage.setContact(contact);
            newPackage.setDescription(description);
            newPackage.setService(service);

            // Set the user who creates the package
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = authentication.getName();
            Optional<User> user = userService.findByEmail(currentUserName);
            user.ifPresent(newPackage::setUser);

            packageService.savePackage(newPackage);
            redirectAttributes.addFlashAttribute("message", "Package created successfully!");
            return "redirect:/TourGuide/library";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error creating package");
            return "redirect:/TourGuide/library";
        }
    }

    
    @GetMapping("/api/packages")
public ResponseEntity<List<TourPackagesDTO>> getAllPackages() {
    List<TourPackagesDTO> packages = packageService.getAllPackagesDTO();
    return ResponseEntity.ok(packages);
}
    
    @DeleteMapping("/api/packages/{id}")
    public ResponseEntity<HttpStatus> deletePackage(@PathVariable Long id) {
        try {
            packageService.deletePackage(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

// Updating package in Views page
    @PostMapping("/api/packages/update")
    public ResponseEntity<?> updatePackage(@RequestBody TourPackagesDTO packageDTO) {
        try {
            TourPackages updatedPackage = packageService.updatePackage(packageDTO);
            return ResponseEntity.ok(updatedPackage); // Return the updated package
     } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}


}
