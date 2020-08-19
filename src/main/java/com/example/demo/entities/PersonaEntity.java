package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="dni")
	private int dni;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private DomicilioEntity domicilio;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(
    		name= "persona_libro",
    		joinColumns= @JoinColumn(name= "persona_id"),
    		inverseJoinColumns = @JoinColumn(name = "libro_id"))
	private List<LibroEntity> libros = new ArrayList<LibroEntity>();
	
}
