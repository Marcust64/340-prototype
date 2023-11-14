package com.pickandgo.demo.packages;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/packages")
public class PackagesController {
    
    @Autowired
    PackagesService packageService;
 
   

    // Method to handle the creation of a new package
    @PostMapping
    public ResponseEntity<Packages> createPackage(@RequestBody Packages packages) {
        try {
            Packages newPackage = packageService.savePackage(packages);
            return new ResponseEntity<>(newPackage, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Method to retrieve all packages
    @GetMapping
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
     
}
