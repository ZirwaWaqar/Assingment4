/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Waqar
 */
@Named(value = "signup")
@SessionScoped
public class signup implements Serializable {

    public signup() {
    }
    private String uname;
    private String password;
    private String myMsg = "Sign up";

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String signupProject() {
        boolean result = signup_DAO.signup(uname, password);
        if (result) {

            return "home";

        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_WARN,
                            "Sign Up!",
                            myMsg));
            return "signup";
        }
    }

}
