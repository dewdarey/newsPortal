package kz.springproject.phoenix.config;

import kz.springproject.phoenix.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.exceptionHandling(exception -> exception
                .accessDeniedPage("/403-page"));

        AuthenticationManagerBuilder builder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userService()).passwordEncoder(passwordEncoder());

        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/bot/complete-text"));

        http.formLogin(form -> form
                .loginPage("/sign-in")
                .loginProcessingUrl("/auth")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/profile")
                .failureUrl("/sign-in?autherror"));

        http.logout(logout -> logout
                .logoutUrl("/sign-out")
                .logoutSuccessUrl("/sign-in"));

        http
                .csrf(csrf -> csrf.disable());

        return http.build();

    }

}
