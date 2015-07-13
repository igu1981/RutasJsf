package com.rutas.persintence.JPA;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.rutas.generic.GenericDaoJpa;
import com.rutas.modelo.Concejos;
import com.rutas.persitence.ConcejosDao;

@Stateless
public class ConcejoDaoJpa extends GenericDaoJpa<Concejos> implements ConcejosDao{

	
	@Override
	public List<Concejos> findConcejosFecha(Date fecha) 
	{
		
		String query= "SELECT c FROM Concejos c inner join c.listaRutas r where r.fecha = :fecha";
		TypedQuery<Concejos> q=em.createQuery(query,Concejos.class);
		q.setParameter("fecha",fecha);
		
		return q.getResultList();
	}
	
	@Override
	public List<Concejos> rutasDesde(Date fecha) 
	{
		
		String query= "SELECT c FROM Concejos c inner join c.listaRutas r where r.fecha >= :fecha";
		TypedQuery<Concejos> q=em.createQuery(query,Concejos.class);
		q.setParameter("fecha",fecha);
		
		return q.getResultList();
	}
	


}
