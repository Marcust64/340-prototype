package com.pickandgo.demo.user;


import com.pickandgo.demo.packages.Packages; 
import jakarta.persistence.*;
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




    // One-to-many relationship with Packages
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Packages> packages = new HashSet<>();

    
    @Override
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
