package com.Bgrupo4.hospitalupskill.user;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.Bgrupo4.hospitalupskill.user.UserPermission.*;

public enum UserRole {
    USER(Sets.newHashSet()),
    UTENTE(Sets.newHashSet(UTENTE_READ)),
    MEDICO(Sets.newHashSet(UTENTE_WRITE, UTENTE_READ)),
    COLABORADOR(Sets.newHashSet(UTENTE_WRITE, UTENTE_READ)),
    RESPONSAVEL(Sets.newHashSet(MEDICO_WRITE, MEDICO_READ)),
    ADMIN(Sets.newHashSet(COLABORADOR_WRITE, COLABORADOR_READ, MEDICO_WRITE, MEDICO_READ, UTENTE_WRITE, UTENTE_READ, RESPONSAVEL_WRITE, RESPONSAVEL_READ)),
    MEDICO_RESPONSAVEL(Sets.newHashSet(COLABORADOR_WRITE, COLABORADOR_READ, MEDICO_WRITE, MEDICO_READ, UTENTE_WRITE, UTENTE_READ)),
    COLABORADOR_RESPONSAVEL(Sets.newHashSet(COLABORADOR_WRITE, COLABORADOR_READ, MEDICO_WRITE, MEDICO_READ, UTENTE_WRITE, UTENTE_READ));;

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
