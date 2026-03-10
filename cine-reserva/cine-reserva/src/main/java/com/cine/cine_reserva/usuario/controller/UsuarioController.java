package com.cine.cine_reserva.usuario.controller;

import com.cine.cine_reserva.usuario.entity.Usuario;
import com.cine.cine_reserva.usuario.service.UsuarioService;
import com.cine.cine_reserva.exception_handling.ApiException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar las operaciones de la entidad Usuario
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerUsuario(id));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> crearUsuario(
            @Valid @RequestBody Usuario usuario,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ApiException(
                    HttpStatus.BAD_REQUEST,
                    bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        usuarioService.crearUsuario(usuario);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminarUsuario(@PathVariable Long id) {

        usuarioService.eliminarUsuario(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}