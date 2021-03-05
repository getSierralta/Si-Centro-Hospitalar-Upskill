package com.Bgrupo4.hospitalupskill.security.config;

import com.Bgrupo4.hospitalupskill.jwt.JwtConfig;
import com.Bgrupo4.hospitalupskill.jwt.JwtTokenVerifier;
import com.Bgrupo4.hospitalupskill.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.Bgrupo4.hospitalupskill.user.ApplicationUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.SecretKey;
import java.util.concurrent.TimeUnit;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //If this gives error probably you don't have the lombok plugin
    private final ApplicationUserService applicationUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey))
                .addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/register","/register/**","/css/**","/img/**","/js/**","/","/log-in","/about-us","/services", "/contacts", "/registration").permitAll()
                .antMatchers("/users/**", "/management/users", "/management/users/**").hasAnyRole("UTENTE", "MEDICO", "COLABORADOR")
                .anyRequest()
                .authenticated()
                .and()
                //.httpBasic();
                //todo: fix login so it uses Json
                .formLogin().loginPage("/login")
                .permitAll().defaultSuccessUrl("/profileutente", true)
                .and().rememberMe().tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)).key("somethingverysecured")
                //Todo: make the key secure
                .and().logout()
                .clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }
}
