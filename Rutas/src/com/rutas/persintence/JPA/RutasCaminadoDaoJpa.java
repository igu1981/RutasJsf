package com.rutas.persintence.JPA;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.rutas.generic.GenericDaoJpa;
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

}
