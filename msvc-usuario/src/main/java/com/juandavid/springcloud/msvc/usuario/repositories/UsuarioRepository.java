package com.juandavid.springcloud.msvc.usuario.repositories;

import com.juandavid.springcloud.msvc.usuario.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);


    //Otra forma de realizar consulta en la BD

    @Query("select u from Usuario u where u.email=?1")
    Optional<Usuario> porEmail(String username);

    boolean existsByEmail(String email);

}
