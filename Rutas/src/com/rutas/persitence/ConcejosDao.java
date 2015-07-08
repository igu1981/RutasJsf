package com.rutas.persitence;

import java.util.Date;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.rutas.generic.GenericDao;
import com.rutas.modelo.Concejos;


public interface ConcejosDao extends GenericDao<T>
{
	
	public List<Concejos> findConcejosFecha(Date fecha);
	
	public List<Concejos> rutasDesde(Date fecha);
		


}
