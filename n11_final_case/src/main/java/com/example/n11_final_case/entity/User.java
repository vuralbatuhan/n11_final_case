package com.example.n11_final_case.entity;

/*
 * @author batuhanvural
 */

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name",nullable = false,length = 30)
    private String name;

    @Column(name = "surname",nullable = false,length = 30)
    private String surname;

    @Column(name = "age",nullable = false)
    private int age;

    @Column(name = "latitude",nullable = false)
    private double latitude;

    @Column(name = "longitude",nullable = false)
    private double longitude;

}
