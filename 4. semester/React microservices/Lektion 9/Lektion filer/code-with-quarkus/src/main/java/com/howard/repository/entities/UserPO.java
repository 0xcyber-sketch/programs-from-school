package com.howard.repository.entities;

import com.howard.domain.Id;
import com.howard.domain.*;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "AUTH_USER")
@UserDefinition
@NamedQueries({
        @NamedQuery(name = "UserPO.findByEmail", query = "Select u FROM UserPO u where u.email=:email or u.userName=:userName"),
})
public class UserPO {
    public static final String FIND_BY_EMAIL = "UserPO.findByEmail";
    public static final String EMAIL_PARAM = "email";
    public static final String USERNAME_PARAM = "userName";


    @javax.persistence.Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "ID", columnDefinition = "varchar(40)")
    private UUID id;

    @Username
    @Column(name = "EMAIL", columnDefinition = "varchar(100)", nullable = false, unique = true)
    private String email;

    @Password
    @Column(name = "PASSWORD", columnDefinition = "varchar(60)", nullable = false)
    private String password;

    @Roles
    @Column(name = "ROLES", columnDefinition = "varchar(100)", nullable = false)
    private String roles;


    @Column(name = "USER_NAME", columnDefinition = "varchar(40)")
    private String userName;

    @Column(name = "FIRST_NAME", columnDefinition = "varchar(40)")
    private String firstname;

    @Column(name = "LAST_NAME", columnDefinition = "varchar(40)")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER", columnDefinition = "varchar(40)")
    private Gender gender;


    public UserPO() {
        //JPA
    }

    public UserPO(Email email, UserName userName, com.howard.domain.Password password, com.howard.domain.Roles roles) {
        this.email = email.getValue();
        this.password = password.getHash();
        this.userName = userName.getValue();
        this.roles = roles.getRolesAsString();
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return roles;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User toUser() {
        return new User(
                new Id(id),
                new Email(email),
                new UserName(userName),
                new com.howard.domain.Password(password),
                new com.howard.domain.Roles(roles),
                new Name(firstname, lastName),
                gender
        );
    }

}
