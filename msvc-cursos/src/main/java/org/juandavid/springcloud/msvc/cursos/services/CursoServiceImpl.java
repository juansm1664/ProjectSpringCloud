package org.juandavid.springcloud.msvc.cursos.services;

import org.juandavid.springcloud.msvc.cursos.clients.UsuarioClientRest;
import org.juandavid.springcloud.msvc.cursos.models.Usuario;
import org.juandavid.springcloud.msvc.cursos.models.entity.Curso;
import org.juandavid.springcloud.msvc.cursos.models.entity.CursoUsuario;
import org.juandavid.springcloud.msvc.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    private CursoRepository repository;

    @Autowired
    public UsuarioClientRest usuarioClient;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> listar() {
        return (List<Curso>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Curso guardar(Curso curso) {
        return repository.save(curso);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Usuario> asignarUsuario(Usuario usuario, Long cursoId) {
        Optional<Curso> opt = repository.findById(cursoId);
        if(opt.isPresent()){
            Usuario usuarioMsvc = usuarioClient.detalle(usuario.getId());

            Curso curso = opt.get();
            CursoUsuario cursoUsuario = new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioMsvc.getId());

            curso.addCursoUsuario(cursoUsuario);
            repository.save(curso);
            return Optional.of(usuarioMsvc);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Usuario> crearUsuario(Usuario usuario, Long cursoId) {

        Optional<Curso> opt = repository.findById(cursoId);
        if(opt.isPresent()){
            Usuario usuarioNuevoMsvc = usuarioClient.crear(usuario);

            Curso curso = opt.get();
            CursoUsuario cursoUsuario = new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioNuevoMsvc.getId());

            curso.addCursoUsuario(cursoUsuario);
            repository.save(curso);
            return Optional.of(usuarioNuevoMsvc);
        }
        return Optional.empty();
    }


    @Override
    @Transactional
    public Optional<Usuario> eliminarUsuario(Usuario usuario, Long cursoId) {

        Optional<Curso> opt = repository.findById(cursoId);
        if(opt.isPresent()){
            Usuario usuarioMsvc = usuarioClient.detalle(usuario.getId());

            Curso curso = opt.get();
            CursoUsuario cursoUsuario = new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioMsvc.getId());

            curso.removeCursoUsuario(cursoUsuario);
            repository.save(curso);
            return Optional.of(usuarioMsvc);
        }

        return Optional.empty();

    }
}
