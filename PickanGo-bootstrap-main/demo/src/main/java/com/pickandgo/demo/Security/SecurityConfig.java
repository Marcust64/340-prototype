package com.pickandgo.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                    .authorizeHttpRequests((authorize) -> authorize
                    .requestMatchers("/", "/index", "/signup").hasAuthority("ANONYMOUS") // Allow access to these paths without authentication
//                    .requestMatchers("/admin/**").hasRole("ADMIN") // Require ADMIN role for paths starting with /admin
//                    .requestMatchers("/tourGuide/**").hasRole("TOUR_GUIDE") // Require TOUR_GUIDE role for paths starting with /tourGuide
                    .anyRequest().permitAll()// Require authentication for any other path
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/sign")
                    .permitAll()
            )
            .logout(logout ->
                logout
                    .permitAll()
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = createUser("admin@example.com", "ADMIN", "admin");
        UserDetails tourGuide = createUser("tourguide@example.com", "TOUR_GUIDE", "tourguide");
        UserDetails tourist = createUser("tourist@example.com", "TOURIST", "tourist");

        return new InMemoryUserDetailsManager(admin, tourGuide, tourist);
    }

    private UserDetails createUser(String email, String role, String password) {
        return org.springframework.security.core.userdetails.User.builder()
                .username(email)
                .password(passwordEncoder().encode(password))
                .roles(role)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
