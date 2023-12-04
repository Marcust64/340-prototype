package com.pickandgo.demo.user;
<<<<<<< HEAD

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pickandgo.demo.packages.Packages; // Import your Packages entity
import jakarta.persistence.*;
=======
import com.pickandgo.demo.packages.Packages;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
>>>>>>> b07a571e2591c7a134b5d70a3f22ca35efd077c6
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "tag")
    private String tag;

    @Column(name = "password")
    private String password;

<<<<<<< HEAD



    // One-to-many relationship with Packages
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Packages> packages = new HashSet<>();


    @Override
=======
    // One-to-many relationship with Packages
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Packages> packages = new HashSet<>();
    
>>>>>>> b07a571e2591c7a134b5d70a3f22ca35efd077c6
    public String toString() {
        return "User{" +
           "userId=" + userId +
           ", email='" + email + '\'' +
           ", username='" + username + '\'' +
           ", tag='" + tag + '\'' +
           // Avoid including 'packages' in toString to prevent potential performance issues with lazy loading
           '}';
    }
}
