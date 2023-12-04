package com.pickandgo.demo.packages;

import com.pickandgo.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackagesService {

    @Autowired
    private PackagesRepository repo;
    


//     /**
//      * Get all packages.
//      *
//      * @return the list of products.
//      */

//     // Save a new package
//     public Packages savePackage(Packages packages) {
//         return repo.save(packages);
//     }

//     // Get all packages

//     public List<Packages> getAllPackages() {
//         return repo.findAll();
//     }


//     /**
//      * Get all packages that match the keyword.
//      *
//      * @param keyword the search term.
//      * @return the list of products.
//      */
//    public List<Packages> getAllPackages(String keyword) {
//         if (keyword != null) {
//             return repo.search(keyword);
//         }
//         return repo.findAll();
//     }

//     /**
//      * Get a single package by ID
//      *
//      * @param packageId
//      * @return the product
//      */
//     public Packages getPackage(long packageId) {
//         return repo.getReferenceById(packageId);
//     }

//     /**
//      * Delete a single package by ID
//      *
//      * @param packageId
//      */
//     public void deletePackage(long packageId) {
//         repo.deleteById(packageId);
//     }


    /**
     * Get all packages.
     *
     * @return the list of products.
     */

    // Save a new package
    public Packages savePackage(Packages packages) {
        return repo.save(packages);
    }

    // Get all packages

    public List<Packages> getAllPackages() {
        return repo.findAll();
    }


    /**
     * Get all packages that match the keyword.
     *
     * @param keyword the search term.
     * @return the list of products.
     */
   public List<Packages> getAllPackages(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }
   
   public List<Packages> getUserPackages(String keyword, User user) {
    if (keyword != null) {
        return repo.search(keyword);
    }

    // Modify this line to filter packages by user ID
    return repo.findByUser_UserId(user.getUserId());
}

    /**
     * Get a single package by ID
     *
     * @param packageId
     * @return the product
     */
    public Optional<Packages> getPackage(long packageId) {
        return repo.findById(packageId);
    }

    /**
     * Delete a single package by ID
     *
     * @param packageId
     */
    public void deletePackage(long packageId) {
        repo.deleteById(packageId);
    }
    
    public List<Packages> getPackagesForUser(Long userId) {
        return repo.findByUser_UserId(userId);
    }
}






