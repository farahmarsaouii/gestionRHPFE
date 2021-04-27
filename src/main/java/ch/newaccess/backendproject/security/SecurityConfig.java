package ch.newaccess.backendproject.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	//auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN","USER").and().withUser("user").password("123").roles("USER");


}
@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();
		//http.formLogin();
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
	http.authorizeRequests().antMatchers("/login/**","/register/**").permitAll();
	http.authorizeRequests().antMatchers(HttpMethod.GET,"/tasks/**").permitAll();
	http.authorizeRequests().antMatchers(HttpMethod.GET,"/documents/**").permitAll();
	http.authorizeRequests().antMatchers(HttpMethod.GET,"/document/**").permitAll();
	http.authorizeRequests().antMatchers(HttpMethod.GET,"/**").permitAll();
	http.authorizeRequests().antMatchers(HttpMethod.POST,"/**").permitAll();
	http.authorizeRequests().antMatchers(HttpMethod.DELETE,"**").permitAll();
	//http.authorizeRequests().antMatchers(HttpMethod.GET,"/tasks/**").hasAuthority(****** privilege******);
	//http.authorizeRequests().antMatchers(HttpMethod.GET,"/tasks/**").hasAuthority("accessToData");
	//http.authorizeRequests().antMatchers(HttpMethod.GET,"/tasks/**").hasAuthority("updateData");
	http.authorizeRequests().anyRequest().authenticated();
	http.addFilter(new JWTAuthenticatinFilter(authenticationManager()));
	http.addFilterBefore(new JWTAuthorizationFiltre(), UsernamePasswordAuthenticationFilter.class);
	}

}
