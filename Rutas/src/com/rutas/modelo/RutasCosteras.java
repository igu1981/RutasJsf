package com.rutas.modelo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;




@Entity
@DiscriminatorValue("costera")
public class RutasCosteras extends Rutas
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoCalzado;
	
	
	
	public RutasCosteras() {
		super();
	}



	public String getTipoCalzado() {
		return tipoCalzado;
	}



	public void setTipoCalzado(String tipoCalzado) {
		this.tipoCalzado = tipoCalzado;
	}
	
	

}
