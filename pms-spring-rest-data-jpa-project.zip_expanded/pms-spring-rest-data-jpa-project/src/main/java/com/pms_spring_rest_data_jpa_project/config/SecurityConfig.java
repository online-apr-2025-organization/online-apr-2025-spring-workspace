package com.pms_spring_rest_data_jpa_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pms_spring_rest_data_jpa_project.filter.JwtAuthFilter;
import com.pms_spring_rest_data_jpa_project.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	private JwtAuthFilter authFilter;
	
	public SecurityConfig(JwtAuthFilter authFilter) {
		this.authFilter = authFilter;
	}

	@Bean
	public UserDetailsService userDetailsService() {
//		UserDetails admin = User
//								.withUsername("Emma")
//								.password(encoder.encode("Watson"))
//								.roles("ADMIN")
//								.build();
//		UserDetails user = User
//							.withUsername("user123")
//							.password(encoder.encode("pass123"))
//							.roles("USER, ADMIN")
//							.build();
//		UserDetails dev = User
//							.withUsername("dev123")
//							.password(encoder.encode("dev123"))
//							.roles("USER")
//							.build();
//		return new InMemoryUserDetailsManager(admin, user, dev);
		return new UserDetailsServiceImpl();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/swagger-ui/**", "/api/products/**", "/api/validate")
						.permitAll()
						.anyRequest()
						.authenticated())
				.formLogin(Customizer.withDefaults())
				.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
