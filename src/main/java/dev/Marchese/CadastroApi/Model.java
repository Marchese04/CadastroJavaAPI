package dev.Marchese.CadastroApi;

import jakarta.persistence.*;

@Entity//usando o Entity ele transforma toda minha classe em uma entidade do banco de dados
@Table(name = "tb_cadastro")
public class Model {

    @Id// o id serve pra dizer que o atributo abaixo dele vai receber o id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// usa-se o generatedValue pra dizer qual vai ser a forma de gerar o id, aqui eu estou dizendo que irar ser sequencial
    Long id;//quando for trabalhar com banco de dados deve-se colocar um id para cada cadastro, estou usando o long ao inves de int caso o banco de dados seja gigantesco
    String nome;
    String email;
    int idade;


    public Model() {
    }

    public Model(String nome, String email, int idade) {
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
}
