package com.nuvu.personas.infraestructura.controlador;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nuvu.personas.aplicacion.comando.manejador.ManejadorSesion;
import com.nuvu.personas.dominio.dto.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class ControllerSesion {
	
	private final ManejadorSesion manejadorSesion;
	
	public ControllerSesion(ManejadorSesion manejadorSesion) {
		this.manejadorSesion = manejadorSesion;
	}

	@PostMapping("sesion")
	public String login(@RequestParam("usuario") String usuario, @RequestParam("contrasena") String contrasena) {
		
		String token = getJWTToken(usuario);
		
		System.out.println("entro");
		Usuario usuarioSesion = new Usuario();
		usuarioSesion.setUsuario(usuario);
		usuarioSesion.setContrasena(contrasena);
		usuarioSesion.setToken(token);
		return manejadorSesion.validarSesion(usuarioSesion) ? token : "Credenciales incorrectas";
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

}
