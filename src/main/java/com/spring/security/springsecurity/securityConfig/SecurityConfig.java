package com.spring.security.springsecurity.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic(withDefaults());
//        http.authorizeHttpRequests(authorizeRequest -> authorizeRequest.anyRequest().authenticated());
//        http.formLogin(formLogin -> formLogin
//                     // Customize login page URL if needed
//                        .permitAll() // Allow access to login page without authentication
//                        );// Specify the default success URL);
        http.authorizeHttpRequests(authorizeRequest->authorizeRequest.requestMatchers("/Hello").authenticated());
        http.addFilterBefore(new MyAuthenticationFilter(), BasicAuthenticationFilter.class);
        return http.build();
    }

//    @Bean
//    UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("Admin").password(passwordEncoder().encode("123"))
//                .authorities("read").build();
//        userDetailsManager.createUser(user);
//        return userDetailsManager;
//    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
