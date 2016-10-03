package com.baeldung.spring.cloud.integration.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("disc_configUser")
                .password("configPassword")
            .and()
                .withUser("disc_discUser")
                .password("discPassword")
            .and()
                .withUser("disc_gatewayUser")
                .password("gatewayPassword")
            .and()
                .withUser("disc_resourceUser")
                .password("resourcePassword");
    }
}