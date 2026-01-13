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
    private String name;
    private String description;

    //Using the OneToMany, you say the java that this object recive 1 our more users for each call
    @OneToMany(mappedBy = "chamados")//if the OneToMany is used you must mapalo with where the ManyToOne this is being used, im my case it is in lisT off called
    private UsuarioModel usuario;

}
