/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Sikimic Nebojsa
 */

public class AppController { 

    public AppController() {
        
    }

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }

//    public void setSession(HttpSession session) {
//        this.session = session;
//    }
    
    
    
}
