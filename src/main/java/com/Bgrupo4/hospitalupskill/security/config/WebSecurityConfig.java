package com.Bgrupo4.hospitalupskill.security.config;

import com.Bgrupo4.hospitalupskill.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import java.util.concurrent.TimeUnit;

import static com.Bgrupo4.hospitalupskill.user.UserRole.*;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //If this gives error probably you don't have the lombok plugin
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/register","/register/**","/css/**","/img/**","/js/**","/","/log-in","/about-us","/services", "/contacts", "/registration").permitAll()
                .antMatchers("/users/**", "/management/users", "/management/users/**").hasAnyRole(UTENTE.name(), MEDICO.name(), COLABORADOR.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic(); //for development purposes
        /*
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                "/register","/register/**","/css/**","/img/**","/js/**","/files/**","/","/log-in","/about-us","/services", "/contacts",
                "/registration", "/users/**", "/management/users", "/management/users/**")
                .permitAll().anyRequest().authenticated().and()
                .formLogin().loginPage("/login")
                .permitAll().defaultSuccessUrl("/profileutente", true)
                .and().rememberMe().tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)).key("somethingverysecured")
                //Todo: make the key secure
                .and().logout()
                .clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/");
        */
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
}
