package com.rutas.persitence;


import java.util.List;
import com.rutas.generic.GenericDao;
import com.rutas.modelo.RutasCaminado;

public interface RutasCaminandoDao extends GenericDao<RutasCaminado> 
{
	
	public List<RutasCaminado> listaRutasCaminado() ;
	public List<RutasCaminado> searchcaminando(String filtBusqueda,boolean estado);
	
	

}
