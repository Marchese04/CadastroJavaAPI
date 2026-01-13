package dev.Marchese.CadastroApi.Chamados;

import dev.Marchese.CadastroApi.Usuario.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_chamados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChamadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    //Usando o OneToMany, você diz pro java que esse objeto recebera 1 ou mais usuarios para cada chamado
    @OneToMany(mappedBy = "chamados")//quando o OneToMany for usado você deve mapealo com onde o ManyToOne esta sendo usado, no meu casdo é na lista de chamados
    private UsuarioModel usuario;

}
