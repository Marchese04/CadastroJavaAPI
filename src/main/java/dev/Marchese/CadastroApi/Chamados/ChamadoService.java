package dev.Marchese.CadastroApi.Chamados;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    private ChamadoRepository chamadoRepository;
    private Object Chamado;

    public ChamadoService(ChamadoRepository chamadoRepository){this.chamadoRepository = chamadoRepository; }

    public List<ChamadoModel> showCalls(){return chamadoRepository.findAll();}

    public ChamadoModel showCallsId(Long id){
        Optional <ChamadoModel> chamadoModel = chamadoRepository.findById(id);
            return chamadoModel.orElse(null);
    }

    public ChamadoModel creatCall(ChamadoModel chamado){return chamadoRepository.save(chamado);}

    public void deletCall(Long id){ chamadoRepository.deleteById(id);}

    public ChamadoModel changeCall(Long id, ChamadoModel updatedCalls){
        if (chamadoRepository.existsById(id)){
            updatedCalls.setId(id);
            return chamadoRepository.save(updatedCalls);
        }
        return null;
    }


}
