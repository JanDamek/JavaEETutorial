package service;

import dao.UsersDAO;
import eu.tieto.entity.User;
import exception.PasswordNotEqualException;
import exception.UserAlreadyExistsException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Stateless
public class UserService {

    @Inject
    private UsersDAO usersDAO;

    public boolean processLogin(final String userName, final String password) {

        final Long userCount = this.usersDAO.getUsersCount(userName, password);
        return userCount == 0 ? false : true;
    }

    public void processRegistration(final String userName, final String password, final String confirmPassword) throws PasswordNotEqualException, UserAlreadyExistsException {

        if (!password.equals(confirmPassword)) {
            throw new PasswordNotEqualException();
        }

        final User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        try {
            this.usersDAO.save(user);
        } catch (final ConstraintViolationException e) {
            throw new UserAlreadyExistsException();
        }

    }

    public Boolean isUsernameAlreadyInDatabase(final String userName) {

        final List<User> user = this.usersDAO.isUsernameAlreadyInDatabase(userName);
        return !user.isEmpty();
    }
}
