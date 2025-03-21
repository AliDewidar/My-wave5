package com.pioneers.serviceV4.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false , name = "fullname")
    private String fullName;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false , unique = true) //if column of db is different from class field name, use @Column(name = "column_name") of db
    private String email;

    @Column(nullable = false)
    private String gender;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
}
