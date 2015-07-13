package com.rutas.controller.model;


import java.io.Serializable;

import com.rutas.persitence.LoginDao;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;


/**
 * 
 * @author igomez
 * 
 */
@ManagedBean(name = "Login")
@SessionScoped
public class LoginConctroller implements Serializable {
	// ------------------------- Atributos -------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idusuarios;
	private String username;
	private String password;
	
	@EJB
	protected LoginDao loginDao;
	
	

	public LoginConctroller() {
		
		super();
		
		idusuarios=-1;
	}

	// ----------------- Getters y Setters --------------------

	public int getIdusuarios() {
		return idusuarios;
	}

	public void setIdusuarios(int idusuarios) {
		this.idusuarios = idusuarios;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	// ------------------------- Metodos -------------------------------

	public String login()
	{
		
		idusuarios = loginDao.validarUser(username, password);
        if (idusuarios!=-1) {
           
            return "/publico/views/index.xhtml?faces-redirect=true";
            
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrecto Usuario y Passowrd",
                            "Por favor introduce de nuevo Usuario y Password"));
            return "/publico/views/login.xhtml?faces-redirect=true";
        }
		
		
		
	}
	
	public String logout()
    {    
    	
        username="";
        password="";
        idusuarios=-1;
        
    	 return "/publico/views/index.xhtml?faces-redirect=true"; 
      }  
	
    public String accesoUsuarios()
    {    
    	
        
        
    	 return "/publico/views/login.xhtml?faces-redirect=true"; 
      }  
	
	

	public String acceso() {

		return "/publico/views/acceso.xhtml?faces-redirect=true";

	}

	public String registro() {

		return "/publico/views/registro.xhtml?faces-redirect=true";
	}

	public String solicitar() {

		return "/publico/index.xhtml?faces-redirect=true";
	}

	public String altanueva() {

		return "/publico/index.xhtml?faces-redirect=true";
	}
	
	public void activarDialog()
	{
		if(idusuarios!=-1)
		{
			RequestContext rc=RequestContext.getCurrentInstance();
			rc.execute("nousuarios.show()");
		
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrecto No estas Logeado",
                            "Por favor introduce el Usuario y Password"));
            
		}
	}
	
	public boolean validaruser()
	{
		if (idusuarios!=-1)
		{
			
			return true;
		}
		else
		{
			return false;
		}
		
		
	}

}
