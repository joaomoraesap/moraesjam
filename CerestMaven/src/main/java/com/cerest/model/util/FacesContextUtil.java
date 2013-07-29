/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cerest.model.util;

import javax.faces.context.FacesContext;
import org.hibernate.Session;

/**
 *
 * @author moraes
 */
public class FacesContextUtil {
  //  public static final HIBERNATE_SESSION="hibernate_session";
    private static final String HIBERNATE_SESSION ="hibernate_session";

    public static void setRequestSession(Session session){
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION,session);
    }
    public static Session getRequestSession() {
        return (Session)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
        
    }
    
}
