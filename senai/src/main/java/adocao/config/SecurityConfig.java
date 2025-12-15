package adocao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
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
        // Desativa COMPLETAMENTE o CSRF para testar
        .csrf(AbstractHttpConfigurer::disable) 
          .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
        // Permite todas as requisições para todos os caminhos
        .authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll()
        );
        return http.build();
    }
   // @Bean
    //public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // http.csrf(csrf -> csrf.disable())
        // .authorizeHttpRequests(auth -> auth
//.requestMatchers("/api/adocoes/**").permitAll()
         // .anyRequest().authenticated()
        //);
            
   // return http.build();
//}
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
   
}
