
package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class AppConfig {



    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        System.out.println("JwtTokenValidatosdaasdr is executing");
        http.sessionManagement(management->management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(Authorize->Authorize.requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll())
                .addFilterBefore( new JwtTokenValidator(), BasicAuthenticationFilter.class)
                .csrf(csrf->csrf.disable()).cors(corse-> corse.configurationSource(corseConfigurationsource()));

        return http.build();
    }
//    private CorsConfigurationSource corseConfigurationsource() {
//        return null;
//    }



    private CorsConfigurationSource corseConfigurationsource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }




}
