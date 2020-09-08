package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="localidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Localidad extends Base {
	
	@Column(name = "denominacion")
	private String denominacion;

}
