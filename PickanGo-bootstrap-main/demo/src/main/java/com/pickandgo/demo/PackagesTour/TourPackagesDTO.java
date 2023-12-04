package com.pickandgo.demo.PackagesTour;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TourPackagesDTO {

    private long packageId;
    private String name;
    private String city;
    private String contact;
    private int capacity;
    private String description;
    private String service;



    

    @Override
    public String toString() {
        return "PackageDTO{" +
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
