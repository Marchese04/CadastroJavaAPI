package dev.Marchese.CadastroApi.Usuario;


import org.springframework.data.jpa.repository.JpaRepository;
//JPA is an abstraction, serves for automatically the query
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
