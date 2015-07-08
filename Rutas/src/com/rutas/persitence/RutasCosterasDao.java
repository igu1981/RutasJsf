package com.rutas.persitence;

import java.util.List;

import com.rutas.generic.GenericDao;
import com.rutas.modelo.RutasCosteras;

public interface RutasCosterasDao extends GenericDao<RutasCosteras>
{

	public List<RutasCosteras> listaRutasCosteras() ;
}
