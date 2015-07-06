package com.rutas.persitence;

import com.rutas.generic.GenericDao;
import com.rutas.modelo.Rutas;

public interface LoginDao extends GenericDao<Rutas> 
{
	public int validarUser(String username, String password);
}
