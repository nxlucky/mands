package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Ugo on 02/05/2015.
 */
@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"security"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //todo Add user details service
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable();

    }



}
