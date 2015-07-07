package com.rutas.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Rutas
 *
 */
@Entity
@Table(name="rutas")
public class Rutas implements Serializable {

	
	//---------------------- Atributos --------------------
	
	@Id
	@Column(name="idrutas")
	private Long rutasId;
	private String itinerario;
	private int distancia;
	private int duracion;
	private String dificultad;
	private int desnivel;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	private String ubicacion;
	private String descripcion;
	
	
	 @ManyToOne 
	 @JoinColumn(name="concejoid")
	 private Concejos concejo;
	
	
	private static final long serialVersionUID = 1L;

	
	//--------------------- Constructor ----------------------
	
	public Rutas() {
		super();
	}


	//--------------------- Getters y Setters ----------------------
	
	public Long getRutasId() {
		return rutasId;
	}


	public void setRutasId(Long rutasId) {
		this.rutasId = rutasId;
	}


	public String getItinerario() {
		return itinerario;
	}


	public void setItinerario(String itinerario) {
		this.itinerario = itinerario;
	}


	public int getDistancia() {
		return distancia;
	}


	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public String getDificultad() {
		return dificultad;
	}


	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}


	public int getDesnivel() {
		return desnivel;
	}


	public void setDesnivel(int desnivel) {
		this.desnivel = desnivel;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Concejos getConcejo() {
		return concejo;
	}


	public void setConcejo(Concejos concejo) {
		this.concejo = concejo;
	}  
		
   
}
