package com.pickandgo.demo.Applications;

import com.pickandgo.demo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 *
 * @author Marcus Thompson
 */
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByUser(User user);

    List<Application> findByTourPackage_PackageId(Long packageId);

    @Query("SELECT a FROM Application a WHERE CONCAT(a.tourPackage.name, ' ', a.tourPackage.city) LIKE %?1%")

    public List<Application> search(String keyword);

}
