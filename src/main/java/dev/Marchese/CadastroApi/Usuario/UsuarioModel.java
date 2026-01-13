package dev.Marchese.CadastroApi.Usuario;

import dev.Marchese.CadastroApi.Chamados.ChamadoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity//usando o Entity ele transforma toda minha classe em uma entidade do banco de dados
@Table(name = "tb_cadastro")
/*
Usando essas 3 anotações do lombok ele crial e atualiza automaticamente os contrutore e getrs e seters, usamos o "data" para os Getters e Setter.
Já o "NoArgsConstuctor" usamos para criar construtores "vazios" e o "AllArgsConstructors" Para os construtores com todos os argumentos
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {

    @Id// o id serve pra dizer que o atributo abaixo dele vai receber o id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// usa-se o generatedValue pra dizer qual vai ser a forma de gerar o id, aqui eu estou dizendo que irar ser sequencial
    private Long id;//quando for trabalhar com banco de dados deve-se colocar um id para cada cadastro, estou usando o long ao inves de int caso o banco de dados seja gigantesco
    private String nome;
    private String email;
    private int idade;

    //usando a anotação ManyToOne você diz pro java que apena 1 chamado sera vinculado por usuario
    @ManyToOne
    @JoinColumn(name = "chamados_id")//essa é nossa chave estrangeira ela serve pra conectar 2 tabelas ou mais
    private List <ChamadoModel> chamados;


    public UsuarioModel() {
    }

    public UsuarioModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }
}
