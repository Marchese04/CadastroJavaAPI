package dev.Marchese.CadastroApi.Usuario;

import org.springframework.stereotype.Component;

@Component
//basically Mapper will map the Usuario model to the Usuario DTO and also to the contrary Usuario DTO
public class UsuarioMapper {

    public UsuarioModel map(UsuarioDTO usuarioDTO){

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(usuarioDTO.getId());
        usuarioModel.setName(usuarioDTO.getName());
        usuarioModel.setEmail(usuarioDTO.getEmail());
        usuarioModel.setAge(usuarioDTO.getAge());
        usuarioModel.setImgUrl(usuarioDTO.getImgUrl());
        usuarioModel.setChamados(usuarioDTO.getChamados());

        return usuarioModel;
    }
    public UsuarioDTO map(UsuarioModel usuarioModel){

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioModel.getId());
        usuarioDTO.setName(usuarioModel.getName());
        usuarioDTO.setEmail(usuarioModel.getEmail());
        usuarioDTO.setAge(usuarioModel.getAge());
        usuarioDTO.setImgUrl(usuarioModel.getImgUrl());
        usuarioDTO.setChamados(usuarioModel.getChamados());

        return usuarioDTO;
    }

}
