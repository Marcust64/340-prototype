package com.pickandgo.demo.packages;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 *
 * @author Marcus Thompson
 */
public interface PackagesRepository extends JpaRepository<Packages, Long> {
    
  List<Packages> findByUser_UserId(Long userId);

     public List<Packages> findByName(String name);

   @Query("SELECT p FROM Packages p WHERE CONCAT(p.name, p.city) LIKE %?1%")
    public List<Packages> search(String keyword);
    
}
