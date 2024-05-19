package org.sid.projectue.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authCustomizer -> authCustomizer
                                .requestMatchers("/editCustomer","/updateCustomer","/deleteCustomer").hasRole("ADMIN")
                                .requestMatchers("/createCustomer","/saveCustomer").hasAnyRole("ADMIN","CASHIER")
                                .requestMatchers("/customersList").hasAnyRole("ADMIN","CASHIER","USER")
                                .anyRequest().authenticated()
                )
                .exceptionHandling(
                        exceptionHandlingCustomizer -> exceptionHandlingCustomizer
                                .accessDeniedPage("/accessDenied")
                )
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
        .build();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(bCryptPasswordEncoder().encode("123")).roles("ADMIN", "USER").build(),
                User.withUsername("cashier").password(bCryptPasswordEncoder().encode("123")).roles("CASHIER").build(),
                User.withUsername("accountant").password(bCryptPasswordEncoder().encode("123")).roles("USER").build()
        );
    }
}
