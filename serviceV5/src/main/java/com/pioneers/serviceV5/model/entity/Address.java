package com.pioneers.serviceV5.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
public class Address {
    @Id
//    @GeneratedValue(strategy = GenerationType.UUID) // or create it in AddressMapper
    private UUID id;

    @Column(nullable = false)
    private String continent;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(name = "building_number", nullable = false)
    private Integer buildingNumber;

    @Column(nullable = false)
    private Integer floor;

    @Column(name = "apartment_number", nullable = false)
    private Integer apartmentNumber;

    @OneToMany(mappedBy = "address") // mappedBy = "address" is the name of the field in the Student class that represents the relationship
    private List<Student> students;
}
