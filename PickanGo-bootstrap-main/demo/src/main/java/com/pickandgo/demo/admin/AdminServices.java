/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pickandgo.demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServices {

    @Autowired
    private AdminRepository adminRepository;

    public void saveContactInfo(ContactInfo contactInfo) {
        adminRepository.save(contactInfo);
    }

    public Iterable<ContactInfo> getAllContactInfo() {
        return adminRepository.findAll();
    }

    public void deleteContactInfoByName(String name) {
        adminRepository.deleteByName(name);
    }
}


