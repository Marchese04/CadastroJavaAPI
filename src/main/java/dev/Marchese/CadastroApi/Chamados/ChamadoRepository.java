package dev.Marchese.CadastroApi.Chamados;


import org.springframework.data.jpa.repository.JpaRepository;
//JPA is an abstraction, serves for automatically the query
public interface ChamadoRepository extends JpaRepository<ChamadoModel, Long> {
}
