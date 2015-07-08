package com.rutas.persintence.JPA;

import java.util.List;

import javax.ejb.Stateless;

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

}
