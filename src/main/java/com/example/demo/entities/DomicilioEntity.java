package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="domicilio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="calle")
	private String calle;
	
	@Column(name="numero")
	private int numero;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "fk_localidad")
	private LocalidadEntity localidad;

}
