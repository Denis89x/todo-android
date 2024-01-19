package dev.lebenkov.todo.api.controller;

import dev.lebenkov.todo.api.service.AuthService;
import dev.lebenkov.todo.api.util.validation.AccountValidator;
import dev.lebenkov.todo.store.dto.AccountRequestLogin;
import dev.lebenkov.todo.store.dto.AccountRequestRegistration;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/v1/auth")
public class AuthController {

    AccountValidator accountValidator;
    AuthService authService;

    @PostMapping("/register")
    public Map<String, String> performRegistration(
            @RequestBody AccountRequestRegistration accountRequestRegistration,
            BindingResult bindingResult) {
        accountValidator.validate(accountRequestRegistration, bindingResult);

        if (bindingResult.hasErrors())
            return Map.of("Error", bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .filter(Objects::nonNull)
                    .toList()
                    .toString());

        return authService.register(accountRequestRegistration) ;
    }

    @PostMapping("/login")
    public Map<String, String> performLogin(
            @RequestBody AccountRequestLogin accountRequestLogin) {
        return authService.login(accountRequestLogin);
    }
}
