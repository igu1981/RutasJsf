package com.rutas.persitence;



import java.util.List;

import com.rutas.generic.GenericDao;

import com.rutas.modelo.Usuarios;



public interface UsuarioDao extends GenericDao<Usuarios>
{
	
	public List<Usuarios> listaUsuarios() ;
		


}
