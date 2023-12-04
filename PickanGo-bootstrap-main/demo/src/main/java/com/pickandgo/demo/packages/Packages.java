package com.pickandgo.demo.packages;

<<<<<<< HEAD
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pickandgo.demo.user.User; 
=======
import com.pickandgo.demo.user.User;
>>>>>>> b07a571e2591c7a134b5d70a3f22ca35efd077c6
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "package")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Packages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private long packageId;
    
<<<<<<< HEAD
=======
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
    
>>>>>>> b07a571e2591c7a134b5d70a3f22ca35efd077c6
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



    

    // @Override
    // public String toString() {
    //     return "Package{" +
    //         "packageId=" + packageId +
    //         ", name='" + name + '\'' +
    //         ", city='" + city + '\'' +
    //         ", contact='" + contact + '\'' +
    //         ", capacity=" + capacity +
    //         ", description='" + description + '\'' +
    //         ", service='" + service + '\'' +
    //         ", user=" + (user != null ? user.toString() : "null") + // Modify toString to include user
    //         '}';
    // }

}
