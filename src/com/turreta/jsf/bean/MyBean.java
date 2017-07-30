package com.turreta.jsf.bean;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
public class MyBean {

	public void isLoggedIn() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		
		Object loggedIn = session.getAttribute("loggedIn");
		if(loggedIn == null) {
			ConfigurableNavigationHandler nav
			   = (ConfigurableNavigationHandler)
					   facesContext.getApplication().getNavigationHandler();

			nav.performNavigation("no-access");
		} else {
			// Display dashboard.xhtml
		}
	}	
}
