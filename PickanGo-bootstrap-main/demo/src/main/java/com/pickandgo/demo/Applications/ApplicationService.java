package com.pickandgo.demo.Applications;

import com.pickandgo.demo.user.User;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Marcus Thompson, Kenneth Alvarado
 */

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    /**
     * Saves application in repository
     *
     * @param application
     */
    public void saveApplication(Application application) {
        applicationRepository.save(application);
    }

    /**
     * Gets packages specific to that user
     *
     * @param user
     * @return user
     */
    public List<Application> getUserPackages(User user) {
        return applicationRepository.findByUser(user);
    }

    /**
     * Gets package specific package ID
     *
     * @param packageId
     * @return package
     */
    public Optional<Application> getPackage(long packageId) {
        return applicationRepository.findById(packageId);
    }

    /**
     * Deletes package by Id
     *
     * @param packageId
     */
    public void deletePackage(long packageId) {
        applicationRepository.deleteById(packageId);
    }

    /**
     * Gets Application by Id
     *
     * @param id
     * @return application
     */
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

    /**
     * Kenneth, Finds Username for that specific package id
     *
     * @param packageId
     * @return username
     */
    public String getUsernamesAsStringByPackageId(Long packageId) {
        List<Application> applications = applicationRepository.findByTourPackage_PackageId(packageId);
        return applications.stream()
                .map(application -> application.getUser().getUsername())
                .collect(Collectors.joining(", "));
    }

    /**
     * Searches repository for matching keyword
     *
     * @param keyword
     * @return
     */
    public List<Application> search(String keyword) {
        return applicationRepository.search(keyword);
    }

}
