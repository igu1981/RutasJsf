package com.rutas.persintence.JPA;




import javax.ejb.Stateless;
import javax.persistence.Query;
import com.rutas.generic.GenericDaoJpa;
import com.rutas.modelo.Rutas;
import com.rutas.persitence.LoginDao;


@Stateless
public class UsuarioDaoJpa extends GenericDaoJpa<Rutas> implements LoginDao{

	@Override
	public int validarUser(String username, String password) 
	{
		
		String query= "Select idusuarios from usuarios where username = ?1 and password = ?2 ";
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
