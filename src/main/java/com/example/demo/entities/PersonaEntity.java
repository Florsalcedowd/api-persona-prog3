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

@Entity
@Table(name = "persona")
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
	
	public PersonaEntity() {
		
	}

	public PersonaEntity(String nombre, String apellido, int dni, DomicilioEntity domicilio, List<LibroEntity> libros) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.libros = libros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public DomicilioEntity getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(DomicilioEntity domicilio) {
		this.domicilio = domicilio;
	}

	public List<LibroEntity> getLibros() {
		return libros;
	}

	public void setLibros(List<LibroEntity> libros) {
		this.libros = libros;
	}
	
}
