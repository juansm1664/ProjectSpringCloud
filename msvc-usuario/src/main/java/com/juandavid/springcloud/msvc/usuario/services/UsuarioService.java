package com.juandavid.springcloud.msvc.usuario.services;

import com.juandavid.springcloud.msvc.usuario.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listar();
    Optional<Usuario> porId(Long id);
    Usuario guardar (Usuario usuario);
    void eliminar(Long id);

    Optional<Usuario> buscarPorEmail(String email);

}
