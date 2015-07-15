package com.rutas.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
	
	 @OneToOne(mappedBy="usuario")
	 private Contactos contacto;
	 
	 
	 
	 @ManyToMany
		@JoinTable(name="usuarios_equipo",
		joinColumns={
		@JoinColumn(name="usuariosid", nullable=false)
		}
		, inverseJoinColumns={
		@JoinColumn(name="equipoid", nullable=false)})
		private List<Equipo> listaequipos;
	 
	 @ManyToMany
		@JoinTable(name="usuarios_usuarios",
		joinColumns={
		@JoinColumn(name="usuariosid", nullable=false)
		}
		, inverseJoinColumns={
		@JoinColumn(name="userunidos", nullable=false)})
		private List<Usuarios> listaamistad;
	
	
	
	
	//---------------------- Constructor --------------------
	
	public Usuarios() 
	{
		super();
		listacarreras = new ArrayList<Carreras>();
		listaamistad=new ArrayList<Usuarios>();
		listaequipos=new ArrayList<Equipo>();
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



	public Contactos getContacto() {
		return contacto;
	}



	public void setContacto(Contactos contacto) {
		this.contacto = contacto;
	}



	public List<Equipo> getListaequipos() {
		return listaequipos;
	}



	public void setListaequipos(List<Equipo> listaequipos) {
		this.listaequipos = listaequipos;
	}



	public List<Usuarios> getListaamistad() {
		return listaamistad;
	}



	public void setListaamistad(List<Usuarios> listaamistad) {
		this.listaamistad = listaamistad;
	}



}
