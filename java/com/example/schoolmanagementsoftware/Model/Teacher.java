package com.example.schoolmanagementsoftware.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(10)")
    private String name;
    @Column(columnDefinition = "varchar(10)")
    private Integer  age;
    @Column(columnDefinition = "varchar(10)")
    private String email;
    @Column(columnDefinition = "varchar(10)")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;

}
