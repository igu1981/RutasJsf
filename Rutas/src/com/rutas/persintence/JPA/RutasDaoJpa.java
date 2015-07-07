package com.rutas.persintence.JPA;


import java.util.List;

import javax.ejb.Stateless;

import com.rutas.generic.GenericDaoJpa;
import com.rutas.modelo.Rutas;
import com.rutas.persitence.RutasDao;

@Stateless
public class RutasDaoJpa extends GenericDaoJpa<Rutas> implements RutasDao{

	

	@Override
	public List<Rutas> listaRutas() {
	
		return findAll();
	}

	@Override
	public List<Rutas> listarutas() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
