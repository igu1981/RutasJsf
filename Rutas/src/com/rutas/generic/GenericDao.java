package com.rutas.generic;

import java.util.List;

import com.rutas.modelo.Rutas;

public interface GenericDao<T> 
{

	T create(T t);

	void delete(Object id);

	T find(Object id);

	List<T> findAll();

	T update(T t);

	List<Rutas> listarutas();

	

}
