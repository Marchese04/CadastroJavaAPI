package dev.Marchese.CadastroApi.Usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota, Hello World!!";
    }

    //Creat user
    @PostMapping("/creatUser")
    public ResponseEntity<String> createUser (@RequestBody UsuarioDTO usuario){
        UsuarioDTO usuarioDTO = usuarioService.creatUser(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("The user '" +usuarioDTO.getName()+ "' was created successfully with id:" + usuarioDTO.getId());
    }// the response entity serves to give answers to the user

    //Show all users
    @GetMapping("/showUser")
    public ResponseEntity<List<UsuarioDTO>> showUsers(){
        List<UsuarioDTO> usuarioList = usuarioService.showUser();
        return ResponseEntity.status(HttpStatus.OK).body(usuarioList);
    }

    /*
    if i want to return JSON like before, i need to turn my ResponseEntity into a Generic and delete the body and put "usuarioDTO"
    in my return ResponseEntity.ok(usuarioDTO), but i liked how it turned ouy. i will do it this way in "changeUser"
    */

    //Show users by id
    @GetMapping("/showUser/{id}")
    public ResponseEntity<String> showUserId(@PathVariable Long id){
        UsuarioDTO usuarioDTO = usuarioService.showUserId(id);
        if(usuarioDTO != null){
            usuarioService.showUserId(id);
            return ResponseEntity.ok()
                    .body("This is the user with id:" +usuarioDTO.getId()+"\n" +
                            " the name is:" +usuarioDTO.getName()+"\n" +
                            " age:" +usuarioDTO.getAge());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The user with id:" +id+ " was not found");
        }
    }

    //Change user data
    @PutMapping("/changeUser/{id}")
    public ResponseEntity<?> changeUser(@PathVariable Long id, @RequestBody UsuarioDTO updatedUser){
        UsuarioDTO usuarioDTO = usuarioService.chengeUser(id, updatedUser);
        if(usuarioDTO != null){
            return ResponseEntity.ok(usuarioDTO);
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The user with id:"+id+ " was not found");
        }
    }

    //Delete user by id
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        if(usuarioService.showUserId(id) != null){
            usuarioService.deleteUser(id);
            return ResponseEntity.ok()
                    .body("The user with id:"+id+ " has been deleted successfully");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)//the status "not found = 404" will appear in your request status
                    .body("The user with id:"+id+ " was not found");
        }

    }

}
