package com.rutas.persitence;

import java.util.Date;
import java.util.List;

import com.rutas.generic.GenericDao;
import com.rutas.modelo.Concejos;


public interface ConcejosDao extends GenericDao<Concejos>
{
	
	public List<Concejos> findConcejosFecha(Date fecha);
	
	public List<Concejos> rutasDesde(Date fecha);
		


}
