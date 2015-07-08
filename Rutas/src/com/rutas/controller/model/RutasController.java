package com.rutas.controller.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.rutas.modelo.Concejos;
import com.rutas.modelo.Rutas;
import com.rutas.modelo.RutasCaminado;
import com.rutas.persitence.ConcejosDao;
import com.rutas.persitence.RutasCaminandoDao;
import com.rutas.persitence.RutasCosterasDao;
import com.rutas.persitence.RutasTrailDao;

@ManagedBean(name = "rutasBean")
@SessionScoped
public class RutasController implements Serializable {

	
	//---------------------- Atributos --------------------
	private static final long serialVersionUID = 1L;
	private Long rutasId;
	private int distancia;
	private String dificultad;
	private String concejo;
	private Date fecha;
	private Rutas rutaselecionada;
	
	@EJB
	protected RutasCaminandoDao rutascaminandoDao;
	@EJB
	protected RutasCosterasDao rutascosterasDao;
	@EJB
	protected RutasTrailDao rutastrailDao;
	@EJB
	protected ConcejosDao concejosDao;

	
	
	//--------------------- Constructor ----------------------
	public RutasController() {
		super();
	}

	//--------------------- Getters y Setters ----------------------
	
	

	public Long getRutasId() {
		return rutasId;
	}



	public void setRutasId(Long rutasId) {
		this.rutasId = rutasId;
	}



	public int getDistancia() {
		return distancia;
	}



	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}



	public String getDificultad() {
		return dificultad;
	}



	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}



	public String getConcejo() {
		return concejo;
	}



	public void setConcejo(String concejo) {
		this.concejo = concejo;
	}


	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Rutas getRutaselecionada() {
		return rutaselecionada;
	}

	public void setRutaselecionada(Rutas rutaselecionada) {
		this.rutaselecionada = rutaselecionada;
	}
	public RutasCaminandoDao getRutascaminandoDao() {
		return rutascaminandoDao;
	}

	public void setRutascaminandoDao(RutasCaminandoDao rutascaminandoDao) {
		this.rutascaminandoDao = rutascaminandoDao;
	}

	public RutasCosterasDao getRutascosterasDao() {
		return rutascosterasDao;
	}

	public void setRutascosterasDao(RutasCosterasDao rutascosterasDao) {
		this.rutascosterasDao = rutascosterasDao;
	}

	public RutasTrailDao getRutastrailDao() {
		return rutastrailDao;
	}

	public void setRutastrailDao(RutasTrailDao rutastrailDao) {
		this.rutastrailDao = rutastrailDao;
	}
	
	//--------------------- Metodos ----------------------
	
	public List<Concejos> tablaRutas()
	{
		return concejosDao.findConcejosFecha(fecha);
	}
	
	public void viewRutas() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		try {
			ctx.getExternalContext().redirect("/Rutas/faces/publico/comun/eventos-calendario.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Date newDate()
	{
		return new Date();
	}
	
	public List<Concejos> tablaRutasDesde()
	{
		return concejosDao.rutasDesde(fecha);
	}
	
	public List<RutasCaminado>listaRutasCaminado()
	{
		return rutascaminandoDao.findAll();
	}

	

	
}

