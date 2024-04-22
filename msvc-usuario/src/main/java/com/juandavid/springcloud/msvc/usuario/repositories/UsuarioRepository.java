package com.juandavid.springcloud.msvc.usuario.repositories;

import com.juandavid.springcloud.msvc.usuario.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {


}
