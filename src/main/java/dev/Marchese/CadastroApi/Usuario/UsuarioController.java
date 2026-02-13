package dev.Marchese.CadastroApi.Usuario;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UsuarioController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota, Hello World!!";
    }

    //Creat user
    @PostMapping("/CreatUser")
    public String CreateUser (){
        return "Creat user";
    }

    //Show all users
    @GetMapping("/ShowUser")
    public String showUsers(){
        return "This is all users";
    }

    //Show users by id
    @GetMapping("/ShowUserId")
    public String showUserId(){
        return "This user with id";
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
