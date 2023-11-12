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

/**
 *
 * @author Marcus Thompson
 */

@Entity
@Table(name = "package")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Packages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long packageId;
    private String name;
    private String city;
    private String description;

}
