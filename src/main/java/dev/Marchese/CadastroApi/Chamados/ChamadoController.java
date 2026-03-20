package dev.Marchese.CadastroApi.Chamados;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    private ChamadoService chamdoservice;

    public ChamadoController (ChamadoService chamadoService) {this.chamdoservice= chamadoService;}

    @GetMapping("/showCalls")
    public List<ChamadoModel> showCalls(){return chamdoservice.showCalls();}

    @GetMapping("/showCall/{id}")
    public ChamadoModel showCallsId(@PathVariable Long id){return  chamdoservice.showCallsId(id);}

    @PostMapping("/creatCall")
    public ChamadoModel creatCall(@RequestBody ChamadoModel chamado){return  chamdoservice.creatCall(chamado);}

    @DeleteMapping("/deleteCall/{id}")
    public void deleteCall(@PathVariable Long id){ chamdoservice.deletCall(id);}

    @PutMapping("/changeCall/{id}")
    public ChamadoModel changeCall(@PathVariable Long id, @RequestBody ChamadoModel updatedCalls){ return chamdoservice.changeCall(id, updatedCalls);}

}
