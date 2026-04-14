package dev.Marchese.CadastroApi.Chamados;
import dev.Marchese.CadastroApi.Usuario.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChamadoDTO {

    private Long id;
    private String name;
    private String description;
    private String difficulty;
    private List<UsuarioModel> usuario;

}
