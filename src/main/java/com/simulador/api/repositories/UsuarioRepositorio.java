package com.simulador.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simulador.api.entities.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

}
