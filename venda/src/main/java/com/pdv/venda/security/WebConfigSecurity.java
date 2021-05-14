package com.pdv.venda.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*Mapear URLs Endereços, autorizamos ou bloqueamos acessos ao EndPoint*/

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userdatailservice;
	
	/* Configura as solicitações po http */
	@Override
		protected void configure(HttpSecurity http) throws Exception {
			/* Ativando a proteção contra usuario que não estão validado por token */
			http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			
			/*Ativando a restrição a URL*/
			/*Ativando a pagina inicial do sistema*/
			.disable().authorizeRequests().antMatchers("/").permitAll()
			.antMatchers("/index").permitAll()
			
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			
			/*URL de Logout - Redireciona após o usuario deslogar do sistema*/
			.anyRequest().authenticated().and().logout().logoutSuccessUrl("/index")
			
			/*Mapear URL de logout e invalida o usuário*/
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			
			/*Filtra Requisições de login para autenticação*/
			.and().addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), 
					                                            UsernamePasswordAuthenticationFilter.class)
			/*FIltra demais requisições para verificar a presença do TOKEN JWT no HEADER HTTP*/
			.addFilterBefore(new JwtApiAutenticacaiFilter(), UsernamePasswordAuthenticationFilter.class);
			
		}

	@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			/* Service ira consultar o usuário no banco */
			auth.userDetailsService(userdatailservice)
			
			/* Padrão de codificação de Senha */
			.passwordEncoder(new BCryptPasswordEncoder());
			
			
		}
}
