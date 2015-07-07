package com.rutas.persitence;

import java.util.List;

import com.rutas.generic.GenericDao;
import com.rutas.modelo.Rutas;



public interface RutasDao extends GenericDao<Rutas>{
	
	public List<Rutas> listaRutas() ;

}
