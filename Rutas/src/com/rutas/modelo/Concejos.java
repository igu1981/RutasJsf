package com.rutas.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * Entity implementation class for Entity: Concejo
 *
 */
@Entity
@Table(name="concejo")
public class Concejos implements Serializable{
	
	/**
	 * 
	 */
	//---------------------- Atributos --------------------
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long concejoid;
	private String nombre;
	
	 @OneToMany(mappedBy="concejo")
	 private List<Rutas> listaRutas;

	//--------------------- Constructor ----------------------
	
	public Concejos() {
		super();
	}

	//--------------------- Getters y Setters ----------------------
	
	public Long getConcejoid() {
		return concejoid;
	}

	public void setConcejosid(Long concejoid) {
		this.concejoid = concejoid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Rutas> getListaRutas() {
		return listaRutas;
	}

	public void setListaRutas(List<Rutas> listaRutas) {
		this.listaRutas = listaRutas;
	}

	@Override
	public String toString() {
		return "Concejos [concejosid=" + concejoid + ", nombre=" + nombre
				+ ", listaRutas=" + listaRutas + "]";
	}
	


	
	
	
	

}
