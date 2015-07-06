package com.rutas.controller.model;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "agenda")
@SessionScoped
public class AgendaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date calendario;
	
	
	
	public Date getCalendario() {
		return calendario;
	}
	public void setCalendario(Date calendario) {
		this.calendario = calendario;
	}
	
	
	

}
