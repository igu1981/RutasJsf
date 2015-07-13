package com.rutas.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable{


	//---------------------- Atributos --------------------
	private static final long serialVersionUID = 1L;
	@Id
	private Long usuariosid;
	private String username;
	private String password;
	
	@ManyToMany(mappedBy="listausuarios")
	private List<Carreras> listacarreras;
	
	
	
	
	//---------------------- Constructor --------------------
	
	public Usuarios() 
	{
		super();
		listacarreras = new ArrayList<Carreras>();
	}
	//---------------------- Getters y Setters --------------------



	public Long getUsuariosid() {
		return usuariosid;
	}




	public void setUsuariosid(Long usuariosid) {
		this.usuariosid = usuariosid;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}



	public List<Carreras> getListacarreras() {
		return listacarreras;
	}



	public void setListacarreras(List<Carreras> listacarreras) {
		this.listacarreras = listacarreras;
	}



	@Override
	public String toString() {
		return "Usuarios [usuariosid=" + usuariosid + ", username=" + username
				+ ", password=" + password + ", listacarreras=" + listacarreras
				+ "]";
	}



}
