package com.rutas.persitence;

import com.rutas.generic.GenericDao;
import com.rutas.modelo.Usuarios;

public interface LoginDao extends GenericDao<Usuarios> 
{
	public int validarUser(String username, String password);
}
