package com.pickandgo.demo.PackagesTour;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pickandgo.demo.user.User; 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tourpackage")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TourPackages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private long packageId;
    
    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "contact")
    private String contact;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "description")
    private String description;

    @Column(name = "service")
    private String service;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;



    

}
