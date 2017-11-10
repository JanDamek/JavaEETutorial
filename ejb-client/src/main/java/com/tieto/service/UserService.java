package com.tieto.service;

import com.tieto.domain.RoleEnum;
import com.tieto.exception.PasswordNotEqualException;
import com.tieto.exception.UserAlreadyExistsException;

/**
 * Project: JavaEETutorialMaven
 * For:
 * Created by damekjan on 09/11/2017.
 */
public interface UserService {

    boolean processLogin(String userName, String password);

    void processRegistration(String userName, String password, String confirmPassword,
                             RoleEnum roleEnum)
            throws PasswordNotEqualException,
            UserAlreadyExistsException;

    Boolean isUsernameAlreadyInDatabase(String userName);
}
