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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="fecha_publicacion")
	private int fechaPublicacion;
	
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

}
