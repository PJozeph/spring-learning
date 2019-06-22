package home.joci.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//in memory authentication
		UserBuilder useres = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication().withUser(useres.username("jhon").password("test123").roles("EMPLOYEE"));
		auth.inMemoryAuthentication().withUser(useres.username("mary").password("test123").roles("MANAGER"));
		auth.inMemoryAuthentication().withUser(useres.username("joci").password("test123").roles("ADMIN"));
	}

}
