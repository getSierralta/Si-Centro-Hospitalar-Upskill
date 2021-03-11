package com.Bgrupo4.hospitalupskill.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    /*
     * This method extracts the roles of currently logged-in user and returns
     * appropriate URL according to his/her role.
     */

    protected String determineTargetUrl(Authentication authentication) {
        // Get the role of logged in user
        String role = authentication.getAuthorities().toString();

        String targetUrl = "";
        if(role.contains("ROLE_UTENTE")) {
            targetUrl = "/utente/profileutente";
        }else if(role.contains("ROLE_MEDICO")) {
            targetUrl = "/medico/profilemedico";
        }else if(role.contains("ROLE_EMPLOYEE")) {
            targetUrl = "/employee/profile";
        }else if(role.contains("ROLE_ADMIN")) {
            targetUrl = "/admin/profile";
        }else if(role.contains("ROLE_COLABORADOR")) {
            targetUrl = "/employee/profile";
        }
        return targetUrl;
    }



    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

}