package com.rutas.persitence;

import java.util.List;

import com.rutas.generic.GenericDao;
import com.rutas.modelo.RutasTrail;


public interface RutasTrailDao extends GenericDao<RutasTrail>
{
	public List<RutasTrail> listaRutasTrail() ;
	public List<RutasTrail> searchTrail(String filtBusqueda,boolean estado);

}
