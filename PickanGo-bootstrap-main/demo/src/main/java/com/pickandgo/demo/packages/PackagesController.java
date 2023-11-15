package com.pickandgo.demo.packages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/packages")
public class PackagesController {
    
    @Autowired
    private PackagesService packageService;

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

    // Method to delete a package by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePackage(@PathVariable Long id) {
        try {
            packageService.deletePackage(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
