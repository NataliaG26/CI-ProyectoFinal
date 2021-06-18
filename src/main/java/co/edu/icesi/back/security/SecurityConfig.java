package co.edu.icesi.back.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import co.edu.icesi.back.model.UserType;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private LoggingAccessDeniedHandler accessDeniedHandler;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.
			csrf().disable()
				.authorizeRequests()
					.antMatchers("/login**").permitAll()
						.antMatchers("/api-rest/**").permitAll()
			        .antMatchers("/h2/**").permitAll()
					.antMatchers("/institution/**").hasRole(UserType.admin.toString())
					.antMatchers("/institution/index").hasRole(UserType.operator.toString())
					.antMatchers("/person/**").hasRole(UserType.operator.toString())
					.antMatchers("/autotransition/**").hasRole(UserType.operator.toString())
					.antMatchers("/personautotran/**").hasRole(UserType.operator.toString())
					.antMatchers("/**").authenticated().anyRequest().permitAll()
					.and()
				.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/")
					.failureUrl("/login?error")
					.usernameParameter("username")
					.passwordParameter("password")
					.and()
				.logout()
					//.logoutUrl("/logout")
					.logoutSuccessUrl("/login")
					.permitAll()
					.and()
				.exceptionHandling()
					.accessDeniedHandler(accessDeniedHandler);

//				.and().logout()
//				.invalidateHttpSession(true).clearAuthentication(true)
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
//				.permitAll().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);

		//Actividad 2 - Punto 7: https://www.baeldung.com/java-config-spring-security

	}

}
