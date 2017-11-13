package br.com.devmedia.curso.config;

import br.com.devmedia.curso.security.DevmediaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DevmediaUserDetailsService ssUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/static/**", "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();
//                .loginPage("/login")
//                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(ssUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}