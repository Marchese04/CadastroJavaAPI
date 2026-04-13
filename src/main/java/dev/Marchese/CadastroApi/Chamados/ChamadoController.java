package dev.Marchese.CadastroApi.Chamados;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    private ChamadoService chamdoservice;

    public ChamadoController (ChamadoService chamadoService) {this.chamdoservice= chamadoService;}

    @GetMapping("/showCalls")
    public List<ChamadoDTO> showCalls(){return chamdoservice.showCalls();}

    @GetMapping("/showCall/{id}")
    public ChamadoDTO showCallsId(@PathVariable Long id){return  chamdoservice.showCallsId(id);}

    @PostMapping("/creatCall")
    public ChamadoDTO creatCall(@RequestBody ChamadoDTO chamado){return  chamdoservice.creatCall(chamado);}

    @DeleteMapping("/deleteCall/{id}")
    public void deleteCall(@PathVariable Long id){ chamdoservice.deletCall(id);}

    @PutMapping("/changeCall/{id}")
    public ChamadoDTO changeCall(@PathVariable Long id, @RequestBody ChamadoDTO updatedCalls){ return chamdoservice.changeCall(id, updatedCalls);}

}
