package com.example.jdbcExample.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@Configuration  //cho phép Spring Boot biết được đây là nơi định nghĩa ra các Bean.
public class SecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	@Autowired
	private UserDetailsService userDetailsService;
/*	
	@Bean
	public UserDetailsService userDetailService() {
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		// Add User
		UserDetails user1 = User 
				.withUsername("user")
				.password("user")
				.roles("USER")
				.authorities(new ArrayList<>())
				.build();
		UserDetails user2 = User 
				.withUsername("admin")
				.password("admin")
				.roles("ADMIN")// role
				.build();
		
		
		inMemoryUserDetailsManager.createUser(user1);
		inMemoryUserDetailsManager.createUser(user2);
		
		return inMemoryUserDetailsManager;
	}
	
	*/
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.cors()
				.disable()
				.csrf()
				.disable()
				.authorizeHttpRequests(
						http -> http
						//phan quyen cho admin. Controller
						.antMatchers("/admin**").hasAuthority("ADMIN") 
						
						// cho phep vao trang login ma k can login. Api
						.antMatchers("/admin/**").hasAuthority("ADMIN")
						//permitAll == cho phep het
						.antMatchers("/login","/images/**").permitAll()
						// tat ca cac duong dan khac thi can dang nhap
//						.antMatchers("/").permitAll()
						.anyRequest()
						.authenticated()
						)
				.logout(httpLogout ->
					// duong dan log out method post
					httpLogout.logoutUrl("/logout")
					// duong dan sau khi log out thanh cong, chuyen huong ve trang login
					.logoutSuccessUrl("/login")
				)
				.formLogin(HttpLogin -> HttpLogin.loginPage("/login")
						// custom login form
						.usernameParameter("email")
						.failureHandler(authenticationFailureHandler())
						.permitAll())
				// k phai login lai
				.rememberMe(
						rememberMe -> rememberMe.rememberMeServices(rememberMeServices(userDetailsService)
						))
				.userDetailsService(userDetailsService)
				.httpBasic()
				.and()
				.build();
	}
	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new SimpleUrlAuthenticationFailureHandler() {
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					org.springframework.security.core.AuthenticationException exception)
					throws IOException, ServletException {
				
				// back login page
				response.sendRedirect("/login?error=true&message="+exception.getMessage());
				
				System.out.println(exception.getMessage());
			}
		};
	}
	@Bean
	RememberMeServices rememberMeServices(UserDetailsService userDetailsService) {
		TokenBasedRememberMeServices rememberMe = new TokenBasedRememberMeServices("myKey", userDetailsService);
		return rememberMe;
	}
/*	
	@Bean // phien ban moi
	RememberMeServices rememberMeServices(UserDetailsService userDetailsService) {
		RememberMeTokenAlgorithm encodingAlgorithm = RememberMeTokenAlgorithm.SHA256;
		TokenBasedRememberMeServices rememberMe = new TokenBasedRememberMeServices("myKey", userDetailsService,
				encodingAlgorithm);
		rememberMe.setMatchingAlgorithm(RememberMeTokenAlgorithm.MD5);
		return rememberMe;
	}
	*/

}
