package com.rutas.persintence.JPA;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.rutas.generic.GenericDaoJpa;
import com.rutas.modelo.RutasCaminado;
import com.rutas.modelo.RutasCosteras;
import com.rutas.modelo.RutasTrail;
import com.rutas.persitence.RutasTrailDao;

@Stateless
public class RutasTrailDaoJpa extends GenericDaoJpa<RutasTrail> implements RutasTrailDao{

	@Override
	public List<RutasTrail> listaRutasTrail() {
		
		return findAll();
	}

	@Override
	public List<RutasTrail> searchTrail(String filtBusqueda, boolean estado) 
	{
		if(!estado)
		{
			return new ArrayList<RutasTrail>();
		}
		String query= "SELECT r FROM RutasTrail r where r.ubicacion like '%" + filtBusqueda + "%'";
		Query q=em.createQuery(query,RutasCaminado.class);
		
		
		return q.getResultList();
	}
}