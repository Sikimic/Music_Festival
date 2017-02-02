/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Sikimic Nebojsa
 */
@ManagedBean(name="appBean")
@ViewScoped
public class AppBean {
    
//    @ManagedProperty(value="#{appContentPath}")
    private String appContentPath = "loginContent.xhtml";

    public AppBean() {
        appContentPath = "loginContent.xhtml";
    }
    
    public String getAppContentPath() {
        return appContentPath;
    }

    public void setAppContentPath(String appContentPath) {
        this.appContentPath = appContentPath;
    }
    
}
