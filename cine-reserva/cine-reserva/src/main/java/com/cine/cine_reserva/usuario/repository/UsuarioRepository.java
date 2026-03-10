package com.cine.cine_reserva.usuario.repository;

import com.cine.cine_reserva.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Esta clase modela el repositorio de la entidad Usuario
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}