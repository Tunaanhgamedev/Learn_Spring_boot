package com.rs.Test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("$2a$10$QukgbgGXYZQba.ASC6EVe.WQYtOgz5bG8AyrJyqj4SSu7EaHXSb2W")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("$2a$10$Nd0IcTlRM18eHoayFQ7j.u0acrssAAYcF.3N.XjoqBjlxiDdgC1ZG")
//                .roles("USER", "ADMIN")
//                .build();
//
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(user);
//        users.createUser(admin);
//        return users;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())   // ✅ cách mới
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/v2/api-docs/**",        // nếu bạn có legacy swagger v2
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/webjars/**",
                                "/swagger-resources/**",
                                "/v3/api-docs.yaml",
                                "/favicon.ico"
                        ).permitAll()
                        .requestMatchers("/v1/register").permitAll()
                        .requestMatchers("/v1/greeting").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults());

        return http.build();
    }
}
