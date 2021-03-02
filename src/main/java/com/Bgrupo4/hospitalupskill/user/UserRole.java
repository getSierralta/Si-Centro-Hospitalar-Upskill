package com.Bgrupo4.hospitalupskill.user;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.Bgrupo4.hospitalupskill.user.UserPermission.*;

public enum UserRole {
    // maybe remove USER and have AMDIN handle the tests
    USER(Sets.newHashSet()),
    UTENTE(Sets.newHashSet(UTENTE_WRITE)),
    MEDICO(Sets.newHashSet(UTENTE_WRITE)),
    COLABORADOR(Sets.newHashSet(UTENTE_WRITE, RESPONSAVEL_WRITE)),
    RESPONSAVEL(Sets.newHashSet(MEDICO_WRITE, RESPONSAVEL_WRITE)),
    ADMIN(Sets.newHashSet(COLABORADOR_WRITE, MEDICO_WRITE, UTENTE_WRITE, RESPONSAVEL_WRITE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}
