package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
