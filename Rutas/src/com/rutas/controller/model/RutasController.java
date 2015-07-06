package com.rutas.controller.model;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.rutas.persitence.RutasDao;

@ManagedBean(name = "rutasBean")
@SessionScoped
public class RutasController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	protected RutasDao rutasDao;

}

