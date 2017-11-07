package com.tieto.controller;

import com.tieto.exception.PasswordNotEqualException;
import com.tieto.exception.UserAlreadyExistsException;
import com.tieto.service.UserService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import java.util.logging.Logger;

@ManagedBean
@Getter
@Setter
@ViewScoped
public class LoginController {

    @Inject
    private Logger logger;

    @Inject
    private UserService userService;
    private String loginName;
    private String password;
    private String passwordConfirm;
    private Boolean inRegistration;

    @PostConstruct
    private void init() {
        this.inRegistration = false;
    }

    public String login() {

        final Boolean isLoggedIn = this.userService.processLogin(this.loginName, this.password);
        return isLoggedIn ? "index.xhtml" : null;
    }

    public String register() {

        if (this.inRegistration) {
            checkLoginName(null, null, this.loginName);
            try {
                this.userService.processRegistration(this.loginName, this.password, this.passwordConfirm);
            } catch (final PasswordNotEqualException e) {
                final FacesContext currentInstance = FacesContext.getCurrentInstance();
                currentInstance.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chyba!", "Hesla nejsou stejna!"));
                return null;
            } catch (final UserAlreadyExistsException e) {
                final FacesContext currentInstance = FacesContext.getCurrentInstance();
                currentInstance.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chyba!", "Uzivatel jiz existuje!"));
                return null;
            }
            return "index.xhtml";
        } else {
            this.inRegistration = true;
        }
        return null;
    }

    public void checkLoginName(final FacesContext facesContext, final javax.faces.component.UIComponent component,
                               final java.lang.Object value) {

        final Boolean isAlreadyInDatabase = this.userService.isUsernameAlreadyInDatabase((String) value);
        if (isAlreadyInDatabase) {
            this.logger.info("Uzivatel existuje!");
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Chyba!", "Uzivatel jiz existuje!"));
        }
    }

}
