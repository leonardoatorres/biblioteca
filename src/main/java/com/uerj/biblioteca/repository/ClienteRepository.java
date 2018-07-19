package com.uerj.biblioteca.repository;

import com.uerj.biblioteca.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Objects;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query(value="SELECT cliente.cpf, cliente.nome, cliente.email, cliente.endereco, telefonesCliente.numTelefone FROM cliente INNER JOIN telefonesCliente ON cliente.cpf=telefonesCliente.cpf", nativeQuery=true)
    List<Object[]> selectTodosOsClientes();

    @Query(value = "SELECT cliente.cpf, cliente.nome, cliente.email, cliente.endereco, telefonesCliente.numTelefone FROM cliente inner join telefonesCliente on cliente.cpf=telefonesCliente.cpf where cliente.cpf = ?" ,nativeQuery = true)
    Object selectClientePorCpf(String cpf);

    /*Melhora utilizando query nativa
    @Query(value = "insert into cliente (cpf, nome, email, endereco) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void createCadastroCliente(String cpf, String nome, String email, String endereco);
*/
    //Melhoria utilizando query nativa
    /*@Modifying
    @Query(value = "DELETE FROM cliente where cpf = ?" ,nativeQuery = true)
    void deleteCliente(String cpf);*/
}