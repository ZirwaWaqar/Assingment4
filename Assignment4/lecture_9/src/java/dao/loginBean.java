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
@Named(value = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

    private String uname;
    private String password;
    private String myMsg = "Login!";

    public String getMyMsg() {
        return myMsg;
    }

    public void setMyMsg(String myMsg) {
        this.myMsg = myMsg;
    }

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

    public String loginProject() {
        boolean result = UserDAO.login(uname, password);
        if (result) {

            return "home";

        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(
                            FacesMessage.SEVERITY_WARN,
                            "Login!",
                            myMsg));
            return "index";
        }
    }

}
