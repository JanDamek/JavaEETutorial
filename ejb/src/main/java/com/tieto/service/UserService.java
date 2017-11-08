package com.tieto.service;

import com.tieto.dao.UsersDAO;
import com.tieto.domain.RoleEnum;
import com.tieto.entity.User;
import com.tieto.exception.PasswordNotEqualException;
import com.tieto.exception.UserAlreadyExistsException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UserService {

    @Inject
    private UsersDAO usersDAO;

    public boolean processLogin(final String userName, final String password) {
        //TODO check role of user
        final Long userCount = this.usersDAO.getUsersCount(userName, password);
        return userCount != 0;
    }

    public void processRegistration(final String userName, final String password, final String confirmPassword,
                                    final RoleEnum roleEnum)
            throws PasswordNotEqualException,
            UserAlreadyExistsException {

        if (!password.equals(confirmPassword)) {
            throw new PasswordNotEqualException();
        }
        if (isUsernameAlreadyInDatabase(userName)) {
            throw new UserAlreadyExistsException();
        }

        final User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setRole(roleEnum);
        this.usersDAO.save(user);

    }

    public Boolean isUsernameAlreadyInDatabase(final String userName) {

        final List<User> user = this.usersDAO.isUsernameAlreadyInDatabase(userName);
        return !user.isEmpty();
    }
}
