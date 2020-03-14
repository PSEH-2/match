package com.sapient.match.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sapient.match.filter.APIKeyAuthFilter;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig implements WebMvcConfigurer {

	@Value("${match.http.auth-token-header-name}")
	private String principalRequestHeader;

	@Value("${match.http.auth-token}")
	private String principalRequestValue;

	
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		APIKeyAuthFilter filter = new APIKeyAuthFilter(principalRequestHeader);
		filter.setAuthenticationManager(new AuthenticationManager() {

			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				String principal = (String) authentication.getPrincipal();
				if (!principalRequestValue.equals(principal)) {
					throw new BadCredentialsException("The API key was not found or not the expected value.");
				}
				authentication.setAuthenticated(true);
				return authentication;
			}
		});
		httpSecurity.antMatcher("/api/**").csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().httpBasic().disable().addFilter(filter).authorizeRequests()
				.anyRequest().authenticated();
	}

}
