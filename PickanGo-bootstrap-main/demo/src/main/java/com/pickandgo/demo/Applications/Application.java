package com.pickandgo.demo.Applications;

import com.pickandgo.demo.user.User;
import com.pickandgo.demo.PackagesTour.TourPackages;
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


/**
 *
 * @author Marcus Thompson
 */

@Entity
@Table(name = "applications")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Application {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private long packageId;
    
    // @Column(name = "name")
    // private String name;

    // @Column(name = "city")
    // private String city;

    // @Column(name = "contact")
    // private String contact;

    // @Column(name = "capacity")
    // private int capacity;

    // @Column(name = "description")
    // private String description;

    // @Column(name = "service")
    // private String service;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "package_id", referencedColumnName = "package_id")
    private TourPackages tourPackage;

    public void setTourPackage(TourPackages tourPackage) {
        this.tourPackage = tourPackage;
    }
}
