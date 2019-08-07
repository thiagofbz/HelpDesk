package com.treinaspring.helpdesk.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.treinaspring.helpdesk.api.entity.User;
import com.treinaspring.helpdesk.api.enums.ProfileEnum;


public class JwtUserFactory {
	
	private JwtUserFactory() {
	}

	//Método que gera o JwtUser com base nos dados de um usuário
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(),
				mapToGrantedAuthorities(user.getProfile()));
	}

	//Método que converte o perfil do usuário para um formato utilizado pelo Spring Security
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}
}
