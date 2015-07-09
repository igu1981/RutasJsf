package com.rutas.controller.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.rutas.modelo.Concejos;
import com.rutas.modelo.Rutas;
import com.rutas.modelo.RutasCaminado;
import com.rutas.modelo.RutasCosteras;
import com.rutas.modelo.RutasTrail;
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
	private String itinerario;
	private int desnivel;
	private String ubicacion;
	private String descripcion;
	private String concejo;
	private int duracion;
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
	public RutasController() 
	{
		super();
		dificultad="";
		distancia=0;
		ubicacion="";
		descripcion="";
		concejo="";
		duracion=0;
		itinerario="";
		
		
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
	
	public String getItinerario() {
		return itinerario;
	}

	public void setItinerario(String itinerario) {
		this.itinerario = itinerario;
	}

	public int getDesnivel() {
		return desnivel;
	}

	public void setDesnivel(int desnivel) {
		this.desnivel = desnivel;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
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

	public List<RutasCosteras>listaRutasCosteras()
	{
		return rutascosterasDao.findAll();
	}
	
	public List<RutasTrail>listaRutasTrail()
	{
		return rutastrailDao.findAll();
	}
	public String rutasCaminando()
	{
		return "/publico/comun/rutas-caminando.xhtml?faces-redirect=true";
	}
	public String rutasCosteras()
	{
		return "/publico/comun/rutas-costeras.xhtml?faces-redirect=true";
	}
	public String rutasTrail()
	{
		return "/publico/comun/rutas-trail.xhtml?faces-redirect=true";
	}
	
	public String añadirRutaCaminando()
	{
		RutasCaminado rc = new RutasCaminado();
		rc.setDesnivel(desnivel);
		rc.setDificultad(dificultad);
		rc.setDistancia(distancia);
		rc.setUbicacion(ubicacion);
		rc.setDescripcion(descripcion);
		rc.setDescripcion(descripcion);
		rc.setFecha(fecha);
		rc.setItinerario(itinerario);
		
		
		rutascaminandoDao.create(rc);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Ruta tipo caminando Añadida!!."));
		dificultad="";
		distancia=0;
		ubicacion="";
		descripcion="";
		concejo="";
		duracion=0;
		itinerario="";
		
		return "/publico/comun/rutas-caminando.xhtml?faces-redirect=true";
	}
	
	public String busquedaRutasCaminando()
	{
		return "/publico/comun/rutas-caminando.xhtml?faces-redirect=true";
	}

	

	
	
}

