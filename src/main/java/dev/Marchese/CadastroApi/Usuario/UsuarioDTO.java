package dev.Marchese.CadastroApi.Usuario;

import dev.Marchese.CadastroApi.Chamados.ChamadoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDTO {//"D"ata "T"ransfer "O"bject

    private Long id;
    private String name;
    private String email;
    private int age;
    private String imgUrl;
    private ChamadoModel chamados;

}
