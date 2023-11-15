package com.pickandgo.demo.packages;

// import com.pickandgo.demo.packages.Packages;
// import com.pickandgo.demo.packages.PackagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackagesService {

    @Autowired
    private PackagesRepository packagesRepository;

    // Save a new package
    public Packages savePackage(Packages packages) {
        return packagesRepository.save(packages);
    }

    // Get all packages
    public List<Packages> getAllPackages() {
        return packagesRepository.findAll();
    }

    // Get a package by ID
    public Optional<Packages> getPackageById(Long id) {
        return packagesRepository.findById(id);
    }

    // Update a package
    public Packages updatePackage(Packages packages) {
        return packagesRepository.save(packages);
    }

    // Delete a package
    public void deletePackage(Long id) {
        packagesRepository.deleteById(id);
    }

}
