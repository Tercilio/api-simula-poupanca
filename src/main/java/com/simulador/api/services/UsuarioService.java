package com.simulador.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simulador.api.entities.Usuario;
import com.simulador.api.repositories.UsuarioRepositorio;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> findAll(){
		return repositorio.findAll();
	}
	
	
	public Usuario findById(Long id) {
		 Optional<Usuario> user = repositorio.findById(id);
		return user.orElseThrow();
	}
	
	public Usuario newUser(Usuario obj) { 
		return repositorio.save(obj);
	}
}
