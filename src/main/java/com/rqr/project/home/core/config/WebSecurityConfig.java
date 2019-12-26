package com.rqr.project.home.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rqr.project.home.core.service.UsuarioDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	String[] resources = new String[]{"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"};
    @Autowired
	private BCryptPasswordEncoder bcrypt;
    @Autowired
    private UsuarioDetailsServiceImpl userDetailsService;
    
    @Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		return bCryptPasswordEncoder;
	}
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    	auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
        .antMatchers(resources).permitAll()  
        .antMatchers("/tohol","/tohol/index").permitAll()
        .antMatchers("/tohol/home*").access("hasRole('SUPERADMIN')")
        .antMatchers("/tohol/home/finanzas*").access("hasRole('GESTORFINAN') or hasRole('SUPERADMIN')")
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/tohol/login")
            .permitAll()
            .defaultSuccessUrl("/tohol/home")
            .failureUrl("/tohol/login?error=true")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
        .logout()
            .permitAll()
            .logoutSuccessUrl("/tohol/login?logout");
    }
	
}
