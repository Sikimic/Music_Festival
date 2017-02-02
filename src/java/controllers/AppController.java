/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import entities.User;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Sikimic Nebojsa
 */
@ManagedBean(name = "app")
@ApplicationScoped
public class AppController {
    
    public AppController() {
        
    }

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    }
    
    public static User getUser() {
        return (User) getSession().getAttribute("user");
    }
    
    public static void setUser(User user) {
        getSession().setAttribute("user", user);
    }
    
}
