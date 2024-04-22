package com.juandavid.springcloud.msvc.usuario.services;

import com.juandavid.springcloud.msvc.usuario.models.entity.Usuario;
import com.juandavid.springcloud.msvc.usuario.repositories.UsuarioRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class UsuariosServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listar() {
        return (List<Usuario>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
         repository.deleteById(id);
    }
}
