package com.sumanth.backendconcepts.securityconfigaration;


import com.sumanth.backendconcepts.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        httpSecurity
                .csrf(csrf -> csrf.disable())  // Disables CSRF protection
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                        .requestMatchers( "/api/auth/**").permitAll()
   //                     .requestMatchers(HttpMethod.DELETE, "/api/**").permitAll() //HttpMethod.POST,
                        .anyRequest().authenticated()  // All requests require authentication
                );
        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//                .csrf(csrf -> csrf.disable())  // Disables CSRF protection
//     .authorizeHttpRequests(
//             auth -> auth.requestMatchers(HttpMethod.POST, "/api/auth/**").permitAll()  // Allows POST requests to /api/auth/** without authentication
//                        .anyRequest().authenticated());  // All other requests require authentication

        return httpSecurity.build();
    }

    @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
  {
      return authenticationConfiguration.getAuthenticationManager();
  }

}
