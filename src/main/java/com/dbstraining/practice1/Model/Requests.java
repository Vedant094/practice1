package com.dbstraining.practice1.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="requests")
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String remarks;

    private String requestType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
