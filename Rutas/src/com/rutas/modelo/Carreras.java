package com.rutas.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="carreras")
public class Carreras implements Serializable{


	//---------------------- Atributos --------------------
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long carrerasid;
	private String itinerario;
	private int distancia;
	private int duracion;
	private String dificultad;
	private int desnivel;
	private Date fechalimite;
	private String ubicacion;
	private String descripcion;
	
	
	@ManyToMany
	@JoinTable(name="carreras_usuarios",
	joinColumns={
	@JoinColumn(name="carrerasid", nullable=false)
	}
	, inverseJoinColumns={
	@JoinColumn(name="usuariosid", nullable=false)})
	private List<Usuarios> listausuarios;

	
	//---------------------- Constructor --------------------
	public Carreras() 
	{
		super();
	}

	//---------------------- Getters y Setters --------------------
	
	public Long getCarrerasid() {
		return carrerasid;
	}


	public void setCarrerasid(Long carrerasid) {
		this.carrerasid = carrerasid;
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


	public Date getFechalimite() {
		return fechalimite;
	}


	public void setFechalimite(Date fechalimite) {
		this.fechalimite = fechalimite;
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

	public List<Usuarios> getListausuarios() {
		return listausuarios;
	}

	public void setListausuarios(List<Usuarios> listausuarios) {
		this.listausuarios = listausuarios;
	}


	
	
	
	
	
	
	
	

}
