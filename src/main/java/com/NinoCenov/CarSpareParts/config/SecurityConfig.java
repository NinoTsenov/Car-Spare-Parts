package com.NinoCenov.CarSpareParts.config;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/auth/**").permitAll()
//                        .requestMatchers("/api/v1/user/**").hasAuthority("USER")
//                        .requestMatchers("/api/v1/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated())
//                        .exceptionHandling(e -> e
//                                .authenticationEntryPoint((request, response, authException) -> {
//                                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//                                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                                    response.getWriter().write("{\"Unauthorized access. Please log in.\"}");
//                                })
//                                .accessDeniedHandler((request, response, accessDeniedException) -> {
//                                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//                                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//                                    response.getWriter().write("{\"Access Denied\"}");
//                                }))
                .sessionManagement(sessionManagementConfig ->
                        sessionManagementConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
