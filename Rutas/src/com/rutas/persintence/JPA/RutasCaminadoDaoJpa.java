package com.rutas.persintence.JPA;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.rutas.generic.GenericDaoJpa;
import com.rutas.modelo.Rutas;
import com.rutas.modelo.RutasCaminado;
import com.rutas.persitence.RutasCaminandoDao;

@Stateless
public class RutasCaminadoDaoJpa extends GenericDaoJpa<RutasCaminado> implements RutasCaminandoDao{

	
	@Override
	public List<RutasCaminado> listaRutasCaminado() 
	{
		return findAll();
	}

	@Override
	public List<RutasCaminado> searchcaminando(String filtBusqueda, boolean estado) 
	{
		if(!estado)
		{
			return new ArrayList<RutasCaminado>();
		}
		String query= "SELECT r FROM RutasCaminado r where r.ubicacion like '%" + filtBusqueda + "%'";
		Query q=em.createQuery(query,RutasCaminado.class);
		
		
		return q.getResultList();
		
		
	}

	@Override
	public List<Rutas> filtrobusqueda(String filtBusqueda, boolean estado) 
	{
		if(!estado || filtBusqueda == null || filtBusqueda.isEmpty())
		{
			return new ArrayList<Rutas>();
		}
		
		String query= "SELECT rc FROM RutasCaminado rc where rc.tipoCalzado regexp :filtro or rc.itinerario regexp :filtro";
		
//		String query= "SELECT rc FROM RutasCaminado rc where rc.tipoCalzado regexp '" + filtBusqueda + "' or rc.itinerario regexp '" + filtBusqueda + "' "
//				      + "or rc.distancia regexp '" + filtBusqueda + "' or rc.duracion regexp '" + filtBusqueda + "' or rc.dificultad regexp '" + filtBusqueda + "'"
//				      		+ " or rc.desnivel regexp '" + filtBusqueda + "' or rc.fecha regexp '" + filtBusqueda + "' or rc.ubicacion regexp '" + filtBusqueda + "' or rc.concejo regexp '" + filtBusqueda + "'";
		Query q=em.createQuery(query,RutasCaminado.class);
		q.setParameter("filtro", filtBusqueda);
		
		
		return q.getResultList();
		
	}

}
