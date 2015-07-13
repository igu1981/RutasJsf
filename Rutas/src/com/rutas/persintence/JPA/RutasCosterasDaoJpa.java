package com.rutas.persintence.JPA;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.rutas.generic.GenericDaoJpa;
import com.rutas.modelo.RutasCaminado;
import com.rutas.modelo.RutasCosteras;
import com.rutas.persitence.RutasCosterasDao;

@Stateless
public class RutasCosterasDaoJpa  extends GenericDaoJpa<RutasCosteras> implements RutasCosterasDao{

	@Override
	public List<RutasCosteras> listaRutasCosteras() {
		
		return findAll();
	}

	@Override
	public List<RutasCosteras> searchcosteras(String filtBusqueda,
			boolean estado) {
		if(!estado)
		{
			return new ArrayList<RutasCosteras>();
		}
		String query= "SELECT r FROM RutasCosteras r where r.ubicacion like '%" + filtBusqueda + "%'";
		Query q=em.createQuery(query,RutasCaminado.class);
		
		
		return q.getResultList();
		
	}

}
