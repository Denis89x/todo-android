package dev.lebenkov.todo.api.service;


import dev.lebenkov.todo.store.dto.AuthRequest;
import dev.lebenkov.todo.store.dto.AuthResponse;
import dev.lebenkov.todo.store.dto.RegistrationRequest;
import dev.lebenkov.todo.store.model.Account;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthService {
    AuthResponse register(RegistrationRequest registrationRequest);

    AuthResponse authenticate(AuthRequest authRequest);

    void saveUserToken(Account account, String jwtToken);

    void revokeAllUserTokens(Account account);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}