// package com.pickandgo.demo.Applications;

// import java.util.List;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

// /**
//  *
//  * @author Marcus Thompson
//  */
// public interface ApplicationRepository extends JpaRepository<Application, Long>{
    
//     List<Application> findByUser_UserId(Long userId);

//      public List<Application> findByName(String name);

//    @Query("SELECT p FROM Packages p WHERE CONCAT(p.name, p.city) LIKE %?1%")
//     public List<Application> search(String keyword);
// }


package com.pickandgo.demo.Applications;

import com.pickandgo.demo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByUser(User user);

    List<Application> findByTourPackage_PackageId(Long packageId);

    // public List<Application> findByName(String name);


    @Query("SELECT a FROM Application a WHERE CONCAT(a.tourPackage.name, ' ', a.tourPackage.city) LIKE %?1%")
    public List<Application> search(String keyword);

}
