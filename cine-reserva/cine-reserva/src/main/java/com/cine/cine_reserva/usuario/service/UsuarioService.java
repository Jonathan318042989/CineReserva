package com.cine.cine_reserva.usuario.service;

import com.cine.cine_reserva.usuario.entity.Usuario;
import com.cine.cine_reserva.usuario.repository.UsuarioRepository;
import com.cine.cine_reserva.exception_handling.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicios para la entidad Usuario
 */
@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "No se encontró el usuario con el id " + id));
    }

    public void crearUsuario(Usuario usuario) {

        usuarioRepository.findByEmail(usuario.getEmail())
                .ifPresent(u -> {
                    throw new ApiException(HttpStatus.CONFLICT, "El email ya está registrado");
                });

        usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {

        Usuario usuario = obtenerUsuario(id);
        usuarioRepository.delete(usuario);
    }

}