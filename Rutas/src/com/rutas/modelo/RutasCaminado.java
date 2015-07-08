package com.rutas.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("caminando")
public class RutasCaminado extends Rutas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoCalzado;
	
	
	
	
	public RutasCaminado() {
		super();
	}
	
	public String getTipoCalzado() {
		return tipoCalzado;
	}
	public void setTipoCalzado(String tipoCalzado) {
		this.tipoCalzado = tipoCalzado;
	}
	
	
	

}
