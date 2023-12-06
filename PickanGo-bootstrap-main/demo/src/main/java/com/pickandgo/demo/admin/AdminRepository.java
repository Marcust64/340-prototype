package com.pickandgo.demo.admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<ContactInfo, String> {

    // Custom query method to delete by name
    void deleteByName(String name);

    // You can add more custom query methods here if needed
}



