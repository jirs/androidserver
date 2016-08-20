package ru.jirs.testprojects.androidserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by irs on 18.08.16.
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()
//				.withUser("user").password("password").roles("USER");

//		auth
//		.jdbcAuthentication()
//			.dataSource(dataSource)
//			.withDefaultSchema();

//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery(
//				"select username,password, enabled from users where username=?")
//				.authoritiesByUsernameQuery(
//						"select username, authority from authorities where username=?");

//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		System.out.println("password: 123 : " + passwordEncoder.encode("123"));

		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
				.usersByUsernameQuery(
				"select email as username,password, enabled from users where email=?")
				.authoritiesByUsernameQuery(
						"select u.email as username, p.name as authority from user_priv2role p2r LEFT JOIN user_roles r ON r.id = p2r.id_role LEFT JOIN users u ON u.id = r.id LEFT JOIN user_privs p ON p.id = p2r.id_priv where u.email=?");



	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//				.authorizeRequests()
//					.anyRequest().authenticated()
//					.and()
//
//				.formLogin()
//					.loginPage("/login")
//					.permitAll();

		http.authorizeRequests()
//				.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
				.antMatchers("/reminders").access("hasRole('ROLE_USER')")
				.and()

				.formLogin().loginPage("/login").failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password")
				.and()
				.logout().logoutSuccessUrl("/login?logout")
				.and()
				.exceptionHandling().accessDeniedPage("/403")
				.and()
				.csrf();


	}

}
