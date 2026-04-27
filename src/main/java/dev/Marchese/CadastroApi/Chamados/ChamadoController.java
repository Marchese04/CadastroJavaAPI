package dev.Marchese.CadastroApi.Chamados;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    private ChamadoService chamdoservice;

    public ChamadoController (ChamadoService chamadoService) {this.chamdoservice= chamadoService;}

    @GetMapping("/showCall")
    public ResponseEntity<List<ChamadoDTO>> showCalls(){
        List<ChamadoDTO> chamadoList = chamdoservice.showCalls();
        return ResponseEntity.ok(chamadoList);
    }

    @GetMapping("/showCall/{id}")
    public ResponseEntity<String> showCallsId(@PathVariable Long id){
        ChamadoDTO chamadoDTO = chamdoservice.showCallsId(id);
        if(chamadoDTO != null){
            chamdoservice.showCallsId(id);
            return ResponseEntity.ok().body("This is called with id:"+id+"\n"+
                    "This is called with name:"+chamadoDTO.getName()+"\n"+
                    "and Description:"+chamadoDTO.getDescription());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The call with id:" +id + " was not found");
        }
    }

    @PostMapping("/creatCall")
    public ResponseEntity<String> creatCall(@RequestBody ChamadoDTO chamado){
        ChamadoDTO chamadoDTO = chamdoservice.creatCall(chamado);
    return  ResponseEntity.status(HttpStatus.CREATED).body("The Call with name:"+chamadoDTO.getName()+ " was successfully created");
    }

    @DeleteMapping("/deleteCall/{id}")
    public ResponseEntity<String> deleteCall(@PathVariable Long id){
        if (chamdoservice.showCallsId(id) != null){
            chamdoservice.deletCall(id);
            return ResponseEntity.ok().body("The Call with id:"+id+" was successfully deleted");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The call with id:"+id + " was not found");
        }
    }

    @PutMapping("/changeCall/{id}")
    public ResponseEntity<?> changeCall(@PathVariable Long id, @RequestBody ChamadoDTO updatedCalls){
        ChamadoDTO chamadoDTO = chamdoservice.changeCall(id, updatedCalls);
        if(chamadoDTO != null){
            return ResponseEntity.ok(chamadoDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The call with id:"+id + " was not found");
        }
    }

}
