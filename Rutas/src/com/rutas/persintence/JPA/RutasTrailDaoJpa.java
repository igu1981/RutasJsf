package com.rutas.persintence.JPA;

import java.util.List;

import javax.ejb.Stateless;

import com.rutas.generic.GenericDaoJpa;
import com.rutas.modelo.RutasTrail;
import com.rutas.persitence.RutasTrailDao;

@Stateless
public class RutasTrailDaoJpa extends GenericDaoJpa<RutasTrail> implements RutasTrailDao{

	@Override
	public List<RutasTrail> listaRutasTrail() {
		
		return findAll();
	}
}