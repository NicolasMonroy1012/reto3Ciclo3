package com.usa.G22.Reto3.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableWebSecurity
public class SecurityAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a -> a
                        .antMatchers("/", "/error","/assets/**","/assets/css/**","/assets/imgs/**",
                                "/assets/js/**","/webjars/**",  "/api/**", "/api/Skate/**",
                                "/api/Reservation/**", "/api/Client/**", "/api/Category/**",
                                "/api/Message/**", "/api/Score/**").permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .oauth2Login().defaultSuccessUrl("/",true);

        http.cors().and().csrf().disable();
    }
}