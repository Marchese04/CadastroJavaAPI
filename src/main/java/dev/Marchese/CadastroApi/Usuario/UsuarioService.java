package dev.Marchese.CadastroApi.Usuario;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;//initializing the layer UserRepository to be able to use her methods
    private Object usuario;
    private UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public List <UsuarioDTO> showUser(){
        List<UsuarioModel> usuario = usuarioRepository.findAll();
        return usuario.stream()
                .map(usuarioMapper::map)
                .collect(Collectors.toList());
    }

    public UsuarioDTO showUserId(Long id){
        Optional<UsuarioModel> usuarioPorId = usuarioRepository.findById(id);
                return usuarioPorId.map(usuarioMapper::map). orElse(null);
    }

    public UsuarioDTO creatUser(UsuarioDTO usuarioDTO){
        UsuarioModel usuario = usuarioMapper.map(usuarioDTO);
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.map(usuario);
    }

    //for the delete method, this method does not need to return anything, this method needs to be void
    public void deleteUser(Long id){
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO chengeUser(Long id, UsuarioDTO usuarioDTO){
        Optional<UsuarioModel> existingUser = usuarioRepository.findById(id);
        if (existingUser.isPresent()){
            UsuarioModel updatedUser = usuarioMapper.map(usuarioDTO);
            updatedUser.setId(id);
            UsuarioModel savedUser = usuarioRepository.save(updatedUser);
            return usuarioMapper.map(savedUser);
        }
        return null;
    }

}
