package com.howard.repository;

import com.howard.domain.*;
import com.howard.repository.entities.UserPO;
import io.quarkus.elytron.security.common.BcryptUtil;
import org.wildfly.security.password.PasswordFactory;
import org.wildfly.security.password.interfaces.BCryptPassword;
import org.wildfly.security.password.util.ModularCrypt;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Dependent
public class Repository {

    private final EntityManager entityManager;

    @Inject
    public Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Email createUser(Email email, UserName userName, Password password, Roles roles) {
        UserPO userPO = new UserPO(email, userName, password, roles);
        entityManager.persist(userPO);
        return new Email(userPO.getEmail());
    }

    public User updateUserName(Id id, UserName userName, Email email, Name name, Gender gender) {
        UserPO userPO = entityManager.find(UserPO.class, id.getUuid());
        userPO.setUserName(userName.getValue());
        userPO.setEmail(email.getValue());
        userPO.setFirstname(name.getFirstName());
        userPO.setLastName(name.getLastName());
        userPO.setGender(gender);
        return userPO.toUser();
    }

    public User findUser(Email email, UserName userName, Password password) {
        try {
            UserPO userPO = entityManager
                    .createNamedQuery(UserPO.FIND_BY_EMAIL, UserPO.class)
                    .setParameter(UserPO.EMAIL_PARAM, email == null ? "" : email.getValue())
                    .setParameter(UserPO.USERNAME_PARAM, userName == null ? "" : userName.getValue())
                    .getSingleResult();

            if (!verifyPassword(password.getValue(), userPO.getPassword())) {
                return null;
            }
            return userPO.toUser();

        } catch (NoResultException e) {
            return null;
        }
    }

    public User getUser(Id id) {
        return entityManager.find(UserPO.class, id.getUuid()).toUser();
    }

    public void testPasswordHash() {

        // get the password the user sent in the post
        String testPassword = "myPassword";

        // get the MCF formatted string to store in the database
        String encryptedPwd = BcryptUtil.bcryptHash(testPassword);

        // verify posted password against the encrypted password from the database
        boolean matches = verifyPassword(testPassword, encryptedPwd);


    }

    private boolean  verifyPassword(String originalPwd, String encryptedPwd) {
        try {
            // convert encrypted password string to a password key
            org.wildfly.security.password.Password rawPassword = ModularCrypt.decode(encryptedPwd);

            // create the password factory based on the bcrypt algorithm
            PasswordFactory factory = PasswordFactory.getInstance(BCryptPassword.ALGORITHM_BCRYPT);

            // create encrypted password based on stored string
            BCryptPassword restored = (BCryptPassword) factory.translate(rawPassword);

            // verify restored password against original
            return factory.verify(restored, originalPwd.toCharArray());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
