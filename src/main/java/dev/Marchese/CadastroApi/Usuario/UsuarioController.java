package dev.Marchese.CadastroApi.Usuario;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
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
    @PostMapping("/CreatUser")
    public UsuarioModel createUser (@RequestBody UsuarioModel usuario){
        return usuarioService.creatUser(usuario);
    }

    //Show all users
    @GetMapping("/ShowUser")
    public List<UsuarioModel> showUsers(){
        return usuarioService.showUser();
    }

    //Show users by id
    @GetMapping("/ShowUser/{id}")
    public UsuarioModel showUserId(@PathVariable Long id){
        return usuarioService.showUserId(id);
    }

    //Change user data
    @PutMapping("/changeUser")
    public String changeUser(){
        return "Choose the user you want to change";
    }

    //Delete user by id
    @DeleteMapping("/deleteUser")
    public String deleteUser(){
        return "User deleted successfully ";
    }

}
