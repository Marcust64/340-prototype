package com.pickandgo.demo.packages;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Override
    public String toString() {
        return "Package{" +
            "packageId=" + packageId +
            ", name='" + name + '\'' +
            ", city='" + city + '\'' +
            ", contact='" + contact + '\'' +
            ", capacity=" + capacity +
            ", description='" + description + '\'' +
            ", service='" + service + '\'' +
            '}';
    }
}