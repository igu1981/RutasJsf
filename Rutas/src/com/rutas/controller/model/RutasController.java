package com.rutas.controller.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.rutas.modelo.Carreras;
import com.rutas.modelo.Concejos;
import com.rutas.modelo.Rutas;
import com.rutas.modelo.RutasCaminado;
import com.rutas.modelo.RutasCosteras;
import com.rutas.modelo.RutasTrail;
import com.rutas.modelo.Usuarios;
import com.rutas.persitence.CarrerasDao;
import com.rutas.persitence.ConcejosDao;
import com.rutas.persitence.RutasCaminandoDao;
import com.rutas.persitence.RutasCosterasDao;
import com.rutas.persitence.RutasTrailDao;
import com.rutas.persitence.UsuarioDao;



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
	private String tipocalzado;
	private String filtBusqueda;
	boolean estado;
	private Rutas rutaselecionada;
	private Rutas selectedRutas;
	private RutasTrail selectedRutasTrail;
	private List<RutasCosteras> filteredCosteras;
	private LoginConctroller loginBean;
	private Carreras carreras;
	private Usuarios usuarios;
	
	@EJB
	protected RutasCaminandoDao rutascaminandoDao;
	@EJB
	protected RutasCosterasDao rutascosterasDao;
	@EJB
	protected RutasTrailDao rutastrailDao;
	@EJB
	protected ConcejosDao concejosDao;
	@EJB
	protected CarrerasDao carrerasDao;
	@EJB
	protected UsuarioDao usuarioDao;


	
	
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
		tipocalzado="";
		
		filtBusqueda="";
		
		
	}
	
	
	@PostConstruct
	public void prepareData()
	{
		FacesContext ctx = FacesContext.getCurrentInstance();
		loginBean = (LoginConctroller) ctx.getApplication().getELResolver().getValue(ctx.getELContext(), null, "Login");
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
	public String getTipocalzado() {
		return tipocalzado;
	}

	public void setTipocalzado(String tipocalzado) {
		this.tipocalzado = tipocalzado;
	}
	public Rutas getSelectedRutas() {
		return selectedRutas;
	}

	public void setSelectedRutas(Rutas selectedRutas) {
		this.selectedRutas = selectedRutas;
	}

	public RutasTrail getSelectedRutasTrail() {
		return selectedRutasTrail;
	}

	public void setSelectedRutasTrail(RutasTrail selectedRutasTrail) {
		this.selectedRutasTrail = selectedRutasTrail;
	}

	public List<RutasCosteras> getFilteredCosteras() {
		return filteredCosteras;
	}

	public void setFilteredCosteras(List<RutasCosteras> filteredCosteras) {
		this.filteredCosteras = filteredCosteras;
	}

	public Carreras getCarreras() {
		return carreras;
	}


	public void setCarreras(Carreras carreras) {
		this.carreras = carreras;
	}

	public Usuarios getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public String getFiltBusqueda() {
		return filtBusqueda;
	}


	public void setFiltBusqueda(String filtBusqueda) {
		this.filtBusqueda = filtBusqueda;
	}

	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
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
	
	public List<Concejos> tablaCarrerasDesde()
	{
		return carrerasDao.carrerasDesde(fecha);
	}
	

	public List<Concejos> concejoFecha()
	{
		return concejosDao.findConcejosFecha(fecha);
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
	    rc.setFecha(fecha);
		rc.setItinerario(itinerario);
		rc.setTipoCalzado(tipocalzado);
		
		
		rutascaminandoDao.create(rc);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Ruta tipo caminando Añadida!!."));
		dificultad="";
		distancia=0;
		ubicacion="";
		descripcion="";
		concejo="";
		duracion=0;
		itinerario="";
		tipocalzado="";
		
		return "/publico/comun/rutas-caminando.xhtml?faces-redirect=true";
	}
	
	public String busquedaRutasCaminando()
	{
		return "/publico/comun/rutas-caminando.xhtml?faces-redirect=true";
	}

	public String añadirRutaCosteras()
	{
		RutasCosteras rcos = new RutasCosteras();
		rcos.setDesnivel(desnivel);
		rcos.setDificultad(dificultad);
		rcos.setDistancia(distancia);
		rcos.setUbicacion(ubicacion);
		rcos.setDescripcion(descripcion);
		rcos.setDescripcion(descripcion);
		rcos.setFecha(fecha);
		rcos.setItinerario(itinerario);
		rcos.setTipoCalzado(tipocalzado);
		
		
		rutascosterasDao.create(rcos);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Ruta tipo costera Añadida!!."));
		dificultad="";
		distancia=0;
		ubicacion="";
		descripcion="";
		concejo="";
		duracion=0;
		itinerario="";
		tipocalzado="";
		
		return "/publico/comun/rutas-caminando.xhtml?faces-redirect=true";
	}
	
	public String busquedaRutasCosteras()
	{
		return "/publico/comun/rutas-costeras.xhtml?faces-redirect=true";
	}

	public String añadirTrail()
	{
		RutasTrail rtrai = new RutasTrail();
		rtrai.setDesnivel(desnivel);
		rtrai.setDificultad(dificultad);
		rtrai.setDistancia(distancia);
		rtrai.setUbicacion(ubicacion);
		rtrai.setDescripcion(descripcion);
		rtrai.setDescripcion(descripcion);
		rtrai.setFecha(fecha);
		rtrai.setItinerario(itinerario);
		rtrai.setTipoCalzado(tipocalzado);
		
		
		rutastrailDao.create(rtrai);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Ruta tipo costera Añadida!!."));
		dificultad="";
		distancia=0;
		ubicacion="";
		descripcion="";
		concejo="";
		duracion=0;
		itinerario="";
		tipocalzado="";
		
		return "/publico/comun/rutas-trail.xhtml?faces-redirect=true";
	}
	
	public String busquedaRutasTrail()
	{
		return "/publico/comun/rutas-trail.xhtml?faces-redirect=true";
	}
	
	public void apuntarse() 
	{
        boolean user=loginBean.validaruser();
        if(user)
        {
        	 Usuarios u=usuarioDao.find(new Long(loginBean.getIdusuarios()));
        	 carreras.addListausuario(u);
        	 
        	 try {
        		 carrerasDao.update(carreras);
        	 } catch (Exception e) {
        		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!" ," Ya estás apuntado!!."));
        		 return;
        	 }
        	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", " Usuario Añadido!!."));
        	
        }
        
        
        
    }
	public void addCorredor(String summary, String detail) 
	{
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public List<Carreras> search() 
	  {
		  
	    	List<Carreras> temp=carrerasDao.searchDao(filtBusqueda,estado, fecha); 
	        estado=true;
	        return temp;
	       
	   }
	
	public List<RutasCaminado> searchcaminando() 
	  {
		  
	    	List<RutasCaminado> temp=rutascaminandoDao.searchcaminando(filtBusqueda,estado); 
	        estado=true;
	        return temp;
	       
	   }
	public List<RutasCosteras> searchcosteras() 
	  {
		  
	    	List<RutasCosteras> temp=rutascosterasDao.searchcosteras(filtBusqueda,estado); 
	        estado=true;
	        return temp;
	       
	   }
	
	public List<RutasTrail> searchtrail() 
	  {
		  
	    	List<RutasTrail> temp=rutastrailDao.searchTrail(filtBusqueda,estado); 
	        estado=true;
	        return temp;
	       
	   }




	
}

