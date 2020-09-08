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

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Libro extends Base {
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="fecha_publicacion")
	private int fechaPublicacion;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="paginas")
	private int paginas;
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
    		name= "libro_autor",
    		joinColumns= @JoinColumn(name= "libro_id"),
    		inverseJoinColumns = @JoinColumn(name = "autor_id"))
	private List<Autor> autores;

}
