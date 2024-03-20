package ru.mccormick.ipa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ru.mccormick.ipa.security.AuthProviderImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final AuthProviderImpl authProviderImpl;
	
	@Autowired
	public SecurityConfig(AuthProviderImpl authProviderImpl) {
		this.authProviderImpl = authProviderImpl;
	}
	
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authProviderImpl);
	}
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails admin = User.builder().username("admin").password(encoder.encode("admin")).build();
		UserDetails user = User.builder().username("user").password(encoder.encode("user")).build();
		
		return new InMemoryUserDetailsManager(admin, user);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
				.authorizeHttpRequests( (auth) -> 
					auth.requestMatchers("/js/**", "/css/**", "/svg/**").permitAll()
					.requestMatchers("/calculate", "/", "/history/**", "/settings/**").authenticated())
					.formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
					.formLogin(
						form -> form
								.loginPage("/login")
								.loginProcessingUrl("/login")
								.usernameParameter("email")
								.passwordParameter("pass")
								.permitAll()
				).logout(
						logout -> logout
							.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
							.permitAll()
				)
				.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
