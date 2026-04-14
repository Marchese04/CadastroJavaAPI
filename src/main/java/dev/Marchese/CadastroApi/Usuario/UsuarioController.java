package dev.Marchese.CadastroApi.Usuario;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public UsuarioDTO createUser (@RequestBody UsuarioDTO usuario){
        return usuarioService.creatUser(usuario);
    }

    //Show all users
    @GetMapping("/showUser")
    public List<UsuarioDTO> showUsers(){
        return usuarioService.showUser();
    }

    //Show users by id
    @GetMapping("/showUser/{id}")
    public UsuarioDTO showUserId(@PathVariable Long id){
        return usuarioService.showUserId(id);
    }

    //Change user data
    @PutMapping("/changeUser/{id}")
    public UsuarioDTO changeUser(@PathVariable Long id, @RequestBody UsuarioDTO updatedUser){return usuarioService.chengeUser(id, updatedUser);}

    //Delete user by id
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        usuarioService.deleteUser(id);
    }

}
