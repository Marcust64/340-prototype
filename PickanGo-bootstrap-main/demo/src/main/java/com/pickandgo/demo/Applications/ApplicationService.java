// package com.pickandgo.demo.Applications;

// import com.pickandgo.demo.PackagesTour.TourPackages;
// import com.pickandgo.demo.packages.Packages;
// import com.pickandgo.demo.user.User;
// import com.pickandgo.demo.user.UserService;
// import java.util.List;
// import java.util.Optional;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Service;

// /**
//  *
//  * @author Marcus Thompson
//  */
// @Service
// public class ApplicationService {

//     @Autowired
//     private ApplicationRepository applicationRepository;
    
//     @Autowired
//     private UserService userService;
    
    
    

//     public void copyTourPackageToApplication(TourPackages tourPackage) {
//         Application application = new Application();
        
//         application.setName(tourPackage.getName());
//         application.setCity(tourPackage.getCity());
//         application.setContact(tourPackage.getContact());
//         application.setCapacity(tourPackage.getCapacity());
//         application.setDescription(tourPackage.getDescription());
//         application.setService(tourPackage.getService());
        
//         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//         String currentUserName = authentication.getName();
//         Optional<User> user = userService.findByEmail(currentUserName);
//         user.ifPresent(application::setUser);


//         // Save the application to the "Applications" repository
//         applicationRepository.save(application);
//     }
    
//     public List<Application> getUserPackages(String keyword, User user) {
//     if (keyword != null) {
//         return applicationRepository.search(keyword);
//     }

//     return applicationRepository.findByUser_UserId(user.getUserId());
//     }
    
//     public Optional<Application> getPackage(long packageId) {
//         return applicationRepository.findById(packageId);
//     }
    
//     public void deletePackage(long packageId) {
//         applicationRepository.deleteById(packageId);
//     }
    
    
    
    
// }



package com.pickandgo.demo.Applications;

import com.pickandgo.demo.PackagesTour.TourPackages;
import com.pickandgo.demo.user.User;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public void saveApplication(Application application) {
        applicationRepository.save(application);
    }

    public List<Application> getUserPackages(User user) {
        return applicationRepository.findByUser(user);
    }

    public Optional<Application> getPackage(long packageId) {
        return applicationRepository.findById(packageId);
    }

    public void deletePackage(long packageId) {
        applicationRepository.deleteById(packageId);
    }

    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }

//     // For getting list
//     public List<String> getUsernamesByPackageId(Long packageId) {
//     List<Application> applications = applicationRepository.findByTourPackage_PackageId(packageId);
//     return applications.stream()
//                        .map(application -> application.getUser().getUsername())
//                        .collect(Collectors.toList());
// }

public String getUsernamesAsStringByPackageId(Long packageId) {
    List<Application> applications = applicationRepository.findByTourPackage_PackageId(packageId);
    return applications.stream()
                       .map(application -> application.getUser().getUsername())
                       .collect(Collectors.joining(", ")); 
}



}
