package poc.rest.apiserver.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests( auth -> auth
                .requestMatchers("/health", "/status").permitAll()
                .requestMatchers("/api/**").authenticated()
                
                .anyRequest().authenticated()

                
                 )
                
                
            .csrf().disable()
            .httpBasic();    

        http
            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
            
            
        return http.build();

    }   
    
}
