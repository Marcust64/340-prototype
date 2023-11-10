package com.pickandgo.demo.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Marcus Thompson
 */

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findByEmail(String email);
}
