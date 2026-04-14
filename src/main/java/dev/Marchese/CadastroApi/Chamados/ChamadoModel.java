package dev.Marchese.CadastroApi.Chamados;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Marchese.CadastroApi.Usuario.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_chamados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChamadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "difficulty")
    private String difficulty;//this is my new layer that has been implemented in my migration

    //Using the OneToMany, you say the java that this object recive 1 our more users for each call
    @OneToMany(mappedBy = "chamados")//if the OneToMany is used you must mapalo with where the ManyToOne this is being used, im my case it is in lisT off called
    @JsonIgnore//Use the JsonIgnore to not create a loop when using the showUser method
    private List <UsuarioModel> usuario;

}
