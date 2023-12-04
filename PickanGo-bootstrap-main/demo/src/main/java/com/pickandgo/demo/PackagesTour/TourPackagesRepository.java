package com.pickandgo.demo.PackagesTour;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author Marcus Thompson
 */
public interface TourPackagesRepository extends JpaRepository<TourPackages, Long> {
    
    List<TourPackages> findByUser_UserId(Long userId);


     public List<TourPackages> findByName(String name);

   @Query("SELECT p FROM Packages p WHERE CONCAT(p.name, p.city) LIKE %?1%")
    public List<TourPackages> search(String keyword);
    
}
