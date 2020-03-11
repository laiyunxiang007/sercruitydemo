package com.example.sercruitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Model：
 * Description：
 * Author: 赖允翔
 * created：2020/3/11 8:37
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationProvider provider;  //注入我们自己的AuthenticationProvider
    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler myAuthenticationFailHander;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        auth.authenticationProvider(provider);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        //super.configure(http);
//        http
//
//                .formLogin()
//                .and()
//                .authorizeRequests().antMatchers("/user").hasRole("role")
//                .anyRequest().access("@rbacService.hasPermission(request,authentication)")
//                .and()
//                .csrf().disable();
        http.authorizeRequests().antMatchers("/user").hasRole("admin")
                .anyRequest().authenticated().and().formLogin();
    }
}
