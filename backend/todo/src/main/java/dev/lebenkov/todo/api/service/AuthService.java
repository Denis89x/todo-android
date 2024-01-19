package dev.lebenkov.todo.api.service;


import dev.lebenkov.todo.store.dto.AccountRequestLogin;
import dev.lebenkov.todo.store.dto.AccountRequestRegistration;

import java.util.Map;

public interface AuthService {
    Map<String, String> register(AccountRequestRegistration accountRequestRegistration);
    Map<String, String> login(AccountRequestLogin accountRequestLogin);
}