package dev.Marchese.CadastroApi.Chamados;

import org.springframework.stereotype.Component;

@Component
public class ChamadoMapper {

    public ChamadoModel map(ChamadoDTO chamadoDTO){
        ChamadoModel chamadoModel = new ChamadoModel();
        chamadoModel.setId(chamadoDTO.getId());
        chamadoModel.setName(chamadoDTO.getName());
        chamadoModel.setDescription(chamadoDTO.getDescription());
        chamadoModel.setDifficulty(chamadoDTO.getDifficulty());
        chamadoModel.setUsuario(chamadoDTO.getUsuario());

        return chamadoModel;
    }
    public ChamadoDTO map(ChamadoModel chamadoModel){
        ChamadoDTO chamadoDTO = new ChamadoDTO();
        chamadoDTO.setId(chamadoModel.getId());
        chamadoDTO.setName(chamadoModel.getName());
        chamadoDTO.setName(chamadoModel.getName());
        chamadoDTO.setDescription(chamadoModel.getDescription());
        chamadoDTO.setDifficulty(chamadoModel.getDifficulty());
        chamadoDTO.setUsuario(chamadoModel.getUsuario());

        return chamadoDTO;
    }

}
