// package com.pickandgo.demo.Security;

// import com.pickandgo.demo.user.CustomUserDetailsService;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import java.io.IOException;
// import java.util.Collection;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Autowired
//     CustomUserDetailsService service;

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
//         requestCache.setMatchingRequestParameterName(null);
//         http
               
//                 .csrf(AbstractHttpConfigurer::disable)
//                 .authorizeHttpRequests((authorize) -> authorize
// 				.requestMatchers("/", "/sign", "/index","/signup", "/user/index-user", "/plugins/**", "/assets/**", "/images/**").permitAll()
//                                 .requestMatchers("/user/**").hasAuthority("USER")
//                                 .requestMatchers("/TourGuide/**").hasAuthority("TOURGUIDE")
//                                 .requestMatchers("/admin/**").hasAuthority("ADMIN")
// 				.anyRequest().authenticated()
// 			)
//                         .formLogin()
// 			.loginPage("/sign")
//                         .loginProcessingUrl("/sign")
//                         .usernameParameter("email")
//                         .passwordParameter("password")
//                         .successHandler((request, response, authentication) -> {
//                         handleSuccessRedirect(request, response, authentication);
//                         })
//                         .and()
//                         .logout()
//                         .permitAll();

//                         return http.build();
                
//     }  
    
//     private void handleSuccessRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
//         Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//         String defaultSuccessUrl = determineDefaultSuccessUrl(authorities);
//         response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + defaultSuccessUrl));
//     }
    
//     private String determineDefaultSuccessUrl(Collection<? extends GrantedAuthority> authorities) {
//         if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("USER"))) {
//             return "/user/index-user";
//         } else if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("TOURGUIDE"))) {
//             return "/TourGuide/index";
//         } else if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("ADMIN"))) {
//             return "/Admin/index";
//         } else {
//             return "/";
//         }
//     }
                
    

//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(service).passwordEncoder(
//                 passwordEncoder());
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
    

// }


package com.pickandgo.demo.Security;

import com.pickandgo.demo.user.CustomUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    CustomUserDetailsService service;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        requestCache.setMatchingRequestParameterName(null);
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/", "/sign", "/index", "/searchresults", "/api/packages", "/signup", "/user/index-user", "/plugins/**", "/assets/**", "/images/**", "/403").permitAll()
                .requestMatchers("/user/**").hasAuthority("USER")
                .requestMatchers("/TourGuide/**").hasAuthority("TOURGUIDE")
                .requestMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                .loginPage("/sign")
                .loginProcessingUrl("/sign")
                .usernameParameter("email")
                .passwordParameter("password")
                .failureUrl("/403")
                .successHandler((request, response, authentication) -> {
                        handleSuccessRedirect(request, response, authentication);
                        })
                )
                .logout()
                .logoutUrl("/logout")  
                .logoutSuccessUrl("/sign")
                 .and()
                .exceptionHandling()
                .accessDeniedPage("/403");
        
                return http.build();

    }

    private void handleSuccessRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String defaultSuccessUrl = determineDefaultSuccessUrl(authorities);
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + defaultSuccessUrl));
    }

    private String determineDefaultSuccessUrl(Collection<? extends GrantedAuthority> authorities) {
        if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("USER"))) {
            return "/user/index-user";
        } else if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("TOURGUIDE"))) {
            return "/TourGuide/index";
        } else if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("ADMIN"))) {
            return "/Admin/index";
        } else {
            return "/";
        }
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(
                passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
