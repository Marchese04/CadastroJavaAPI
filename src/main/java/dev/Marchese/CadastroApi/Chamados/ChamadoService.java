package dev.Marchese.CadastroApi.Chamados;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChamadoService {

    private ChamadoRepository chamadoRepository;
    private Object Chamado;
    private ChamadoMapper chamadoMapper;

    public ChamadoService(ChamadoRepository chamadoRepository, ChamadoMapper chamadoMapper) {
        this.chamadoRepository = chamadoRepository;
        this.chamadoMapper = chamadoMapper;
    }

    public List<ChamadoDTO> showCalls(){
        List<ChamadoModel> chamado = chamadoRepository.findAll();
        return chamado.stream()
                .map(chamadoMapper::map)
                .collect(Collectors.toList());
    }

    public ChamadoDTO showCallsId(Long id){
        Optional <ChamadoModel> chamadoPorId = chamadoRepository.findById(id);
            return chamadoPorId.map(chamadoMapper::map). orElse(null);
    }

    public ChamadoDTO creatCall(ChamadoDTO chamadoDTO){
        ChamadoModel chamado = chamadoMapper.map(chamadoDTO);
        chamado = chamadoRepository.save(chamado);
        return chamadoMapper.map(chamado);
    }

    public void deletCall(Long id){ chamadoRepository.deleteById(id);}

    public ChamadoDTO changeCall(Long id, ChamadoDTO chamadoDTO){
        Optional<ChamadoModel> existingCalls = chamadoRepository.findById(id);
        if (existingCalls.isPresent()){
            ChamadoModel updatedCalls = chamadoMapper.map(chamadoDTO);
            updatedCalls.setId(id);
            ChamadoModel savedCalls = chamadoRepository.save(updatedCalls);
            return chamadoMapper.map(savedCalls);
        }
        return null;
    }


}
