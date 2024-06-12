package org.hogwarts.annotations.test4.entity;

import org.hogwarts.annotations.test4.annotations.Email;
import org.hogwarts.annotations.test4.annotations.MaxLength;
import org.hogwarts.annotations.test4.annotations.MinLength;
import org.hogwarts.annotations.test4.annotations.NotEmpty;
import org.hogwarts.annotations.test4.annotations.ValidBean;
import org.hogwarts.annotations.test4.valid_clases.AppConstants;

// ХОТИМ ПРОВЕРЯТЬ ЗНАЧЕНИЕ НАШИХ ПОЛЕЙ БЕЗ ПРИВЯЗКИ К СТРУКТУРЕ КЛАССА
@ValidBean("person")
public class Person {

    @MinLength(6)
    @MaxLength(12)
    @NotEmpty
    private String login;
    @MinLength(8)
    private String password;
    @Email(regex = AppConstants.EMAIL_PATTERN)
    private String email;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
