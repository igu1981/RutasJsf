package com.rutas.persintence.JPA;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.rutas.generic.GenericDaoJpa;
import com.rutas.modelo.Usuarios;
import com.rutas.persitence.LoginDao;

@Stateless
public class LoginDaoJpa extends GenericDaoJpa<Usuarios> implements LoginDao
{
	
	@Override
	public int validarUser(String username, String password) 
	{
		
		String query= "Select usuariosid from usuarios where username = ?1 and password = ?2 ";
		Query q=em.createNativeQuery(query);
		q.setParameter(1, username);
		q.setParameter(2, password);
		
		try {
			return (Integer) q.getSingleResult();
			
		} catch (Exception e) {
			
			return -1;
			
		}
	}

	
}
