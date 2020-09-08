package com.example.demo.dtos;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO extends BaseDTO {
    private String nombre;
    private String apellido;
    private String biografia;
}
