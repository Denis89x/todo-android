package dev.lebenkov.todo.api.auditing;

import dev.lebenkov.todo.store.model.Account;
import org.bson.types.ObjectId;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class ApplicationAuditAware implements AuditorAware<ObjectId> {
    @Override
    public Optional<ObjectId> getCurrentAuditor() {
        Authentication authentication =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();
        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken
        ) {
            return Optional.empty();
        }

        Account userPrincipal = (Account) authentication.getPrincipal();
        return Optional.ofNullable(userPrincipal.getId());
    }
}
