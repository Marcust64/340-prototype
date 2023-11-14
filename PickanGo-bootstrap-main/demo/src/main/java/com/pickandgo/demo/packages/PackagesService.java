package com.pickandgo.demo.packages;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marcus Thompson
 */
@Service
public class PackagesService {
    @Autowired
    private PackagesRepository repo;

    /**
     * Get all packages.
     *
     * @return the list of products.
     */
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

    /**
     * Get a single package by ID
     *
     * @param packageId
     * @return the product
     */
    public Packages getPackage(long packageId) {
        return repo.getReferenceById(packageId);
    }

    /**
     * Delete a single package by ID
     *
     * @param packageId
     */
    public void deletePackage(long packageId) {
        repo.deleteById(packageId);
    }

    /**
     * Save a package entry.
     *
     * @param packages
     */
    void savePackage(Packages packages) {
        repo.save(packages);
    }
}
