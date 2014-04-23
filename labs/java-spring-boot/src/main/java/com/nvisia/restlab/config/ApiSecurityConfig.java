package com.nvisia.restlab.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("USER", "ADMIN");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
            .csrf().disable()
    		.authorizeRequests()
            .antMatchers("/api/**").hasRole("USER")
            .antMatchers("/beans/**").hasRole("ADMIN")
    		.anyRequest()
    		.authenticated()
    		.and()
    		.httpBasic();
    }
}
