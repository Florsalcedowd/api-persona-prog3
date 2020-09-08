package com.example.demo.dtos;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO implements Serializable {
    private Long id;
}
