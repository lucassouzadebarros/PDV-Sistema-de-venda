package com.pdv.venda.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pdv.venda.AplicationContextLoad;
import com.pdv.venda.model.Usuario;
import com.pdv.venda.repository.UsuarioRepository;


import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;

@Service
@Component
public class JWTTokenAutenticacaoService  {
	
	@Autowired
	private AplicationContextLoad aplicationContextLoad;

	/* Tempo de Validade do Token*/
	private static final long EXPIRATION_TIME = 990000000;
	
	private static final String SECRET = "SenhaExtremamenteSecreta";
	
	private static final String TOKEN_PREFIX = "Bearer";
	
	private static final String HEADER_STRING = "Authorizathion";
	
	/* Gerando token de autenticado e adiocionando ao cabeçalho e resposta Http*/
	public void addAuthentication(HttpServletResponse response, String username) throws Exception{
		
		String JWT = Jwts.builder()/*Chama o Gerador de token */
				.setSubject(username)/*Adiciona o Usuario */
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))/* Tempo de Expiração */
				.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, SECRET).compact();/*Compactação e algoritimo de geração de senha */
		
		/* Junta o Token com o Prefixo */
		String token = TOKEN_PREFIX + " " + JWT; /* Bearer 8787s87scscsc8w*/
		
		/*Adiciona no cabeçalho http */
		response.addHeader(TOKEN_PREFIX, token);/* Authorizathion: Bearer 8787s87scscsc8w */
		
		aplicationContextLoad.getApplicationcontext().getBean(UsuarioRepository.class).atualizaTokenUser(JWT, username);
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		/* Liberando Acesso Cors*/
		liberacaoCors(response);
		
		/* Escreve token como resposta no corpo http */
		response.getWriter().write("{\"Authorizathion\": \"" +token+"\"}");
	}
	
	/* Retorna o usuario validado com token ou caso não seja valido retorna null*/
	public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) {
		
		/* Pega o token enviado no cabeçalho HTTP */
		String token = request.getHeader(HEADER_STRING);
		try {
		if(token != null) {
			
			String tokenlimpo = token.replace(TOKEN_PREFIX, "").trim();
			/*faz a validação do usuario a cada requisição*/
			String user = Jwts.parser()
					      .setSigningKey(SECRET)
					      .parseClaimsJws(tokenlimpo)
					      .getBody().getSubject();/* se validado retorna o usuario */
			System.out.println(user.toString());
			System.out.println(user);
			System.out.println(user.toString().getClass());
			if(user != null) {
				
				
				Usuario usuario = aplicationContextLoad.getApplicationcontext().getBean(UsuarioRepository.class).findUserByNome(user);
				System.out.println("Testando usuario: " + usuario);		             
				
				if(usuario != null) {
					
					if(tokenlimpo.equalsIgnoreCase(usuario.getToken())) {
					return new UsernamePasswordAuthenticationToken(
							   usuario.getNome(), 
							   usuario.getSenha(), 
							   usuario.getAuthorities());
					}
				}
				
			}
			}
		    }catch (io.jsonwebtoken.ExpiredJwtException e) {
				try {
				response.getOutputStream().println("Token Expirado, faça um login");
			}catch (IOException e1) {}
			}
			
		    response.addHeader("Access-Control-Allow-Origin", "*");
			liberacaoCors(response);
			return null;
	}

	private void liberacaoCors(HttpServletResponse response) {
		
		if(response.getHeader("Access-Control-Allow-Origin") == null) {
		response.addHeader("Access-Control-Allow-Origin", "*");
	}
		
		if(response.getHeader("Access-Control-Allow-Headers")== null) {
			
			response.addHeader("Access-Control-Allow-Headers", "*");
		}
		
		if(response.getHeader("Access-Control-Request-Headers")== null) {
			
			response.addHeader("Access-Control-Request-Headers", "*");
		}
		
		if(response.getHeader("Access-Control-Allow-Methods")== null) {
			response.addHeader("Access-Control-Allow-Methods", "*");
		}

}
	}
