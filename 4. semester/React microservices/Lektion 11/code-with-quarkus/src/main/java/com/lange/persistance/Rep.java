package com.lange.persistance;



import com.lange.domain.Credentials;
import com.lange.domain.Email;
import com.lange.domain.User;

import com.lange.domain.Username;
import com.lange.persistance.entity.UserPO;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;



@Dependent
@Transactional
public class Rep {
    private  final EntityManager entityManager;

    @Inject
    public Rep (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getUsers() {
        return entityManager.createNamedQuery(UserPO.FIND_ALL, UserPO.class).getResultList().stream().map(UserPO::toUser).collect(Collectors.toList());
    }

    public boolean UserExists(Username username, Email email) {
        return getUsers().stream().anyMatch(u -> u.getUserName().equals(username) || u.getEmail().equals(email));
    }

    public User getUserByEmail(String email) {
        try {
            return entityManager.createNamedQuery(UserPO.FIND_BY_EMAIL, UserPO.class)
                    .setParameter(UserPO.FIND_BY_EMAIL_PARAMETER, email)
                    .getSingleResult().toUser();
        } catch (NoResultException e) {
            return null;
        }
    }

    public User createUser(Credentials credentials) {
        UserPO user = new UserPO(credentials);
        entityManager.persist(user);
        return user.toUser();
    }


    public User findUser(String username) {
        try {
            return entityManager.createNamedQuery(UserPO.FIND_BY_USERNAME, UserPO.class)
                    .setParameter(UserPO.FIND_BY_USERNAME_PARAMETER, username)
                    .getSingleResult().toUser();
        } catch (NoResultException e) {
            return null;
        }
    }
}
