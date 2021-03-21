package com.Bgrupo4.hospitalupskill.user;

public enum UserPermission {
    COLABORADOR_READ("colaborador:read"),
    COLABORADOR_WRITE("colaborador:write"),
    MEDICO_READ("medico:read"),
    MEDICO_WRITE("medico:write"),
    UTENTE_READ("utente:read"),
    UTENTE_WRITE("utente:write"),
    RESPONSAVEL_READ("responsavel:read"),
    RESPONSAVEL_WRITE("responsavel:write"),
    USER_READ("utente:read"),
    USER_WRITE("utente:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
