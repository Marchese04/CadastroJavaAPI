package dev.Marchese.CadastroApi.Usuario;

import dev.Marchese.CadastroApi.Chamados.ChamadoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity//Using the annotation "Entity" he transforms the my class in a entity of my database
@Table(name = "tb_cadastro")

/*
Using these 3 annotation of lombok he to creates and automatically updates the constructors and gettrs and setters, Using the "data" for the Getters e Setter.
Already the "NoArgsConstuctor" we use for to create constructors "empty" and the "AllArgsConstructors" for the constuctors with all the Args
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {

    @Id// the id he serves for say that the attribute below it will recive the id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Using the generatedValue for say wich on will be the form of to generate the id, here i'm saying that the will be sequential
    private Long id;//when you go to work of database one must place a id for each register, i'm using the long in advance of int case the database be long
    private String name;
    @Column(unique = true)// this annotation serves for each register to be unique, so 2 peoples cannot have the same email
    private String email;
    private int age;

    //using the annotation ManyToOne you say for java if only 1 called will be linked by user
    @ManyToOne
    @JoinColumn(name = "chamados_id")//this is our foreign key she serves to connect 2 tables or more
    private List <ChamadoModel> chamados;



}
