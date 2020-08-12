package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class LibroEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="anio")
	private int anio;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="paginas")
	private int paginas;
	
	// @Column(name="autor")
	// private String autor;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
    		name= "libro_autor",
    		joinColumns= @JoinColumn(name= "libro_id"),
    		inverseJoinColumns = @JoinColumn(name = "autor_id"))
	private List<AutorEntity> autores;

	public LibroEntity() {
		
	}

	public LibroEntity(String titulo, int anio, String genero, int paginas, List<AutorEntity> autores) {
		this.titulo = titulo;
		this.anio = anio;
		this.genero = genero;
		this.paginas = paginas;
		this.autores = autores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public List<AutorEntity> getAutores() {
		return autores;
	}

	public void setAutores(List<AutorEntity> autores) {
		this.autores = autores;
	}

}
