package dev.lebenkov.todo.api.service;

import dev.lebenkov.todo.store.model.Account;
import dev.lebenkov.todo.store.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountServiceImp implements AccountService {

    AccountRepository accountRepository;

    @Override
    public Account fetchAccount() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return accountRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Account not founded!"));
    }
}
