package com.lange.service.requests;

import com.lange.domain.Email;
import com.lange.domain.Password;
import com.lange.domain.Username;
import com.lange.domain.exception.DomainValidation;

public class SignupRequest {
        private final Email email;
        private final Password password;
        private final Username userName;

        public SignupRequest(String email, String userName, String password)  {
            try {
                this.email = new Email(email);
                this.password = new Password(password) ;
                this.userName = new Username(userName);
            } catch (DomainValidation e) {
                throw new IllegalArgumentException(e.getMessage());
            }

        }

        public Email getEmail() {
            return email;
        }

        public Password getPassword() {
            return password;
        }

        public Username getUserName() {
            return userName;
        }
}
