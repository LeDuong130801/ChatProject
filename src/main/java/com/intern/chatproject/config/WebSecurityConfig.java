package com.intern.chatproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    @Bean
    public UserDetailsService userDetailInMemorysService() {
        UserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("duong")
                        .password("1")
                        .roles("EMPLOYEE")
                        .roles("TEST")
                        .build()
        );
        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("1")
                        .roles("ADMIN")
                        .build()
        );
        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("remote")
                        .password("1")
                        .roles("REMOTE")
                        .build()
        );
        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//        http.authenticationProvider(authenticationProvider());

        CookieClearingLogoutHandler cookies = new CookieClearingLogoutHandler("our-custom-cookie");

        http.authorizeHttpRequests((authorize) -> authorize
//                .requestMatchers("/api/employee/**").hasRole("ADMIN")
//                .requestMatchers("/api/employee/get*").hasAnyRole("ADMIN", "EMPLOYEE")
//                .requestMatchers("/api/project/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                .requestMatchers("/api/employee-project/**").hasAnyRole("ADMIN", "EMPLOYEE")
//                .requestMatchers("/api/role/**").hasAnyRole("ADMIN", "TEST")
                .anyRequest().permitAll()
                )
//                .oauth2Login(withDefaults())
                .httpBasic(withDefaults())
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/")
                )
                .userDetailsService(userDetailInMemorysService());
//        http.authorizeRequests()
//                .requestMatchers("/oauth_login")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .oauth2Login()
//                .loginPage("/oauth_login");
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}