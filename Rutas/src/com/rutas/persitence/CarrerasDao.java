package com.rutas.persitence;

import java.util.Date;
import java.util.List;


import com.rutas.generic.GenericDao;
import com.rutas.modelo.Carreras;
import com.rutas.modelo.Concejos;


public interface CarrerasDao extends GenericDao<Carreras>
{
	
	public List<Concejos> findConcejosFecha(Date fecha);
	
	public List<Concejos> carrerasDesde(Date fecha);
	
	public List<Carreras> searchDao(String filtBusqueda,boolean estado,Date fechalimite);
		


}
