package com.rutas.persintence.JPA;




import javax.ejb.Stateless;

import com.rutas.generic.GenericDaoJpa;
import com.rutas.modelo.Usuarios;
import com.rutas.persitence.UsuarioDao;


@Stateless
public class UsuarioDaoJpa extends GenericDaoJpa<Usuarios> implements UsuarioDao{

	


}
