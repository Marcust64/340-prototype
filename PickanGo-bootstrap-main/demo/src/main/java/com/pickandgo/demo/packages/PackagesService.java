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
    private PackagesRepository repo;


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
}

    /**
     * Save a package entry.
     *
     * @param packages
     */
     /*
     void savePackage(Packages packages) {
        repo.save(packages);
     }
  
    Get a package by ID
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
*/