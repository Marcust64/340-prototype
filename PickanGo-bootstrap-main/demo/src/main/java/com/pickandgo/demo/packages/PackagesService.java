package com.pickandgo.demo.packages;

import com.pickandgo.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Marcus Thompson
 */
@Service
public class PackagesService {

    @Autowired
    private PackagesRepository repo;

    /**
     * Saves specific package
     *
     * @return the list of packages
     */
    public Packages savePackage(Packages packages) {
        return repo.save(packages);
    }

    /**
     * Get all packages.
     *
     * @return the list of packages
     */
    public List<Packages> getAllPackages() {
        return repo.findAll();
    }

    /**
     * Get all packages that match the keyword
     *
     * @param keyword
     * @return the list of packages
     */
    public List<Packages> getAllPackages(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    /**
     * Gets all packages that matches the user
     *
     * @param keyword
     * @param user
     * @return list of packages for the user
     */
    public List<Packages> getUserPackages(String keyword, User user) {
        if (keyword != null) {
            return repo.search(keyword);
        }

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
     * Deletes a package by ID
     *
     * @param packageId
     */
    public void deletePackage(long packageId) {
        repo.deleteById(packageId);
    }

    /**
     *
     * @param userId
     * @return
     */
    public List<Packages> getPackagesForUser(Long userId) {
        return repo.findByUser_UserId(userId);
    }

    /**
     * Searches packages matching keyword
     *
     * @param keyword
     * @return packages that match
     */
    public List<Packages> search(String keyword) {
        return repo.search(keyword);
    }
}
