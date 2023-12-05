package com.pickandgo.demo.Applications;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Marcus Thompson
 */
public interface ApplicationRepository extends JpaRepository<Application, Long>{
    
    List<Application> findByUser_UserId(Long userId);

     public List<Application> findByName(String name);

   @Query("SELECT a FROM Application a WHERE CONCAT(a.name, a.city) LIKE %?1%")
    public List<Application> search(String keyword);
    
}