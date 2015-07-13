package com.rutas.persintence.JPA;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.rutas.generic.GenericDaoJpa;
import com.rutas.modelo.Carreras;
import com.rutas.modelo.Concejos;
import com.rutas.persitence.CarrerasDao;

@Stateless
public class CarrerasDaoJpa extends GenericDaoJpa<Carreras> implements CarrerasDao{

	
	@Override
	public List<Concejos> findConcejosFecha(Date fecha) 
	{
		
		String query= "SELECT c FROM Concejos c inner join c.listaCarreras r where r.fechalimite = :fecha";
		TypedQuery<Concejos> q=em.createQuery(query,Concejos.class);
		q.setParameter("fecha",fecha);
		
		return q.getResultList();
	}
	
	@Override
	public List<Concejos> carrerasDesde(Date fecha) 
	{
		
		String query= "SELECT c FROM Concejos c inner join c.listaCarreras r where r.fechalimite >= :fecha";
		TypedQuery<Concejos> q=em.createQuery(query,Concejos.class);
		q.setParameter("fecha",fecha);
		
		return q.getResultList();
	}

	@Override
	public List<Carreras> searchDao(String filtBusqueda, boolean estado,Date fechalimite) {

		if(!estado)
		{
			return new ArrayList<Carreras>();
		}
		String query= "SELECT c FROM Carreras c where c.ubicacion like '%" + filtBusqueda + "%'  AND c.fechalimite>=:fecha";
		Query q=em.createQuery(query,Carreras.class);
		q.setParameter("fecha", fechalimite);
		
		return q.getResultList();
		
	}
	


}
