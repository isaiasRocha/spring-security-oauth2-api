package com.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * AuthorizationServer
 * @author RochaDev
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
   	
    @Autowired
	private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserDetailsService userDetailService;
	 
	/**
	 * Configuração cliente
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	     clients.inMemory()
	       .withClient("project-web") 
	       .secret(passwordEncoder().encode("123"))
	       .scopes("read","write")
	       .authorizedGrantTypes("password","refresh_token")
	       .accessTokenValiditySeconds(60 * 60 * 1) // uma hora
	       .refreshTokenValiditySeconds(60 * 60 * 24 * 30); // um mês          
	}
	
	/**
	 * JWT com chave simétrica (HMAC SHA-256)
	 */
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		 JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		 jwtAccessTokenConverter.setSigningKey("sad6f5a4sd6545a6sdf4");//MAC
		 return jwtAccessTokenConverter;
	}
	

	/**
	 * Configura o gerenciador de autorização(apenas para o fluxo password),
	 * por meio deste é feita a validação das credenciais do usuário final.
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
		.accessTokenConverter(jwtAccessTokenConverter())
		.reuseRefreshTokens(false)
		.userDetailsService(userDetailService)
		.authenticationManager(this.authenticationManager);
	}
	
	
	/**
	 * Configuração do endpoint de introspecção nesse caso, demos,
	 * acesso ao cliente sem precisar de usuário e senha, valida o 
	 * token gerado.
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
	   security.checkTokenAccess("permitAll()"); 
	}
	
	/**
	 * @return estratégia de encriptação
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
		
}
