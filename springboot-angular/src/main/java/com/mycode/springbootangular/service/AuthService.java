package com.mycode.springbootangular.service;

import com.mycode.springbootangular.dto.RegisterRequest;
import com.mycode.springbootangular.model.NotificationEmail;
import com.mycode.springbootangular.model.User;
import com.mycode.springbootangular.model.VerificationToken;
import com.mycode.springbootangular.repository.UserRepository;
import com.mycode.springbootangular.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Autowired
    private MailService mailService;

    @Transactional
    public void signUp(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword())); // Password is encoded and then registered
        user.setCreatedDate(Instant.now());
        user.setEnabled(false);
        userRepository.save(user);

        String token = generateVerificationToken(user);
        mailService.sendEmail(new NotificationEmail("Please activate your account", user.getEmail(),
                "Thank you for signing up to Spring Reddit, " + "please click on the below url to activate your " +
                        "account : " + "http://localhost:8080/api/auth/accountVerification/" + token));
    }

    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepository.save(verificationToken);
        return token;

    }
}
