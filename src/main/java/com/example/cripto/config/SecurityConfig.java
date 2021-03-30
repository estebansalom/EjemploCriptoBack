//package com.example.cripto.config;
//
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    protected void configurer (AuthenticationManagerBuilder auth)throws Exception{
//        super.configure(auth);
//    }
//
//    protected void configure(HttpSecurity http)throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("BigPP")
//                .antMatchers("/user").hasRole("SmolPP")
//                .antMatchers("/api/v1/**").permitAll()
//                .and().formLogin();
//    }
//}
