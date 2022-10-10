package com.devluis.microservices.motorcycles.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_motorcycle")
@Getter
@Setter
@RequiredArgsConstructor
public class Motocycle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    private String model;
    private Long userId;
}
