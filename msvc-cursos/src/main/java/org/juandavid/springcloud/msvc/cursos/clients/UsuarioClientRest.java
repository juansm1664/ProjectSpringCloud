package org.juandavid.springcloud.msvc.cursos.clients;


import org.juandavid.springcloud.msvc.cursos.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name ="msvc-usuario", url = "localhost:8001")
public interface UsuarioClientRest {


    @GetMapping("/{id}")
    public Usuario detalle(@PathVariable Long id);

    @PostMapping("/")
    Usuario crear(@RequestBody Usuario usuario);

    @GetMapping("/usuarios-por-curso")
    List<Usuario> obtenerUsuarioCurso(@RequestParam Iterable<Long> ids);

}
