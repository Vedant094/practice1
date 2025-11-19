package com.dbstraining.practice1.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;



    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Requests> requests;
}


