package dev.Marchese.CadastroApi.Usuario;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;//initializing the layer UserRepository to be able to use her methods
    private Object usuario;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public List <UsuarioModel> showUser(){//Creat a method to be able for list all user in my database
        return usuarioRepository.findAll();
    }

    public UsuarioModel showUserId(Long id){
        Optional<UsuarioModel> usuarioModel = usuarioRepository.findById(id);
                return usuarioModel.orElse(null);
    }

    public UsuarioModel creatUser(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    //for the delete method, this method does not need to return anything, this method needs to be void
    public void deleteUser(Long id){
        usuarioRepository.deleteById(id);
    }

    public UsuarioModel chengeUser(Long id, UsuarioModel updatedUser){
        if (usuarioRepository.existsById(id)){
            updatedUser.setId(id);
            return usuarioRepository.save(updatedUser);
        }
        return null;
    }

}
