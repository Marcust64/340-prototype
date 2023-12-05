package com.pickandgo.demo.PackagesTour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TourPackagesService {

    @Autowired
    private TourPackagesRepository repo;
    

    // Convert a Packages entity to a PackagesDTO
    public TourPackagesDTO convertToDTO(TourPackages packages) {
        return new TourPackagesDTO(
            packages.getPackageId(),
            packages.getName(),
            packages.getCity(),
            packages.getContact(),
            packages.getCapacity(),
            packages.getDescription(),
            packages.getService()
        );
    }

        // Convert DTO to entity
        public TourPackages convertToEntity(TourPackagesDTO dto) {
            TourPackages packages = new TourPackages();
            packages.setPackageId(dto.getPackageId());
            packages.setName(dto.getName());
            packages.setCity(dto.getCity());
            packages.setContact(dto.getContact());
            packages.setCapacity(dto.getCapacity());
            packages.setDescription(dto.getDescription());
            packages.setService(dto.getService());
            return packages;
        }

    // Save a new package
    public TourPackages savePackage(TourPackages packages) {
        return repo.save(packages);
    }

    //  Get all packages as DTOs
    public List<TourPackagesDTO> getAllPackagesDTO() {
        return repo.findAll().stream()
                   .map(this::convertToDTO)
                   .collect(Collectors.toList());
    }

    // Get all packages and convert to DTOs
    public List<TourPackagesDTO> getAllPackagesDTO(String keyword) {
        if (keyword != null) {
            return repo.search(keyword).stream()
                       .map(this::convertToDTO)
                       .collect(Collectors.toList());
        }
        return getAllPackagesDTO();
    }

    // Get a single package by ID and convert to DTO
    public Optional<TourPackagesDTO> getPackageDTO(long packageId) {
        return repo.findById(packageId)
                   .map(this::convertToDTO);
    }
    
    //Marcus add
     public TourPackages findByPackageId(long packagesId) {
        return repo.findByPackageId(packagesId);
     }
    

    // Delete a single package by ID
    public void deletePackage(long packageId) {
        repo.deleteById(packageId);
    }

    public List<TourPackagesDTO> getPackagesForCurrentUser(Long userId) {
        List<TourPackages> packages = repo.findByUser_UserId(userId);
        return packages.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    

    
public TourPackages updatePackage(TourPackagesDTO updatedPackageDTO) {
    Optional<TourPackages> existingPackageOpt = repo.findById(updatedPackageDTO.getPackageId());

    if (existingPackageOpt.isPresent()) {
        TourPackages existingPackage = existingPackageOpt.get();

        // Update fields
        existingPackage.setName(updatedPackageDTO.getName());
        existingPackage.setCity(updatedPackageDTO.getCity());
        existingPackage.setContact(updatedPackageDTO.getContact());
        existingPackage.setDescription(updatedPackageDTO.getDescription());
        existingPackage.setService(updatedPackageDTO.getService());

        
        return repo.save(existingPackage);
    } else {
        throw new RuntimeException("Package not found with id: " + updatedPackageDTO.getPackageId());
    }
}


}
