/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOTest;

import a.vendasy2.dao.DAOCliente;
import a.vendasy2.model.ModelCliente;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose_
 */
public class DAOClienteTest {
    
private ModelCliente modelCliente; // Declarando a variável modelCliente na classe

@BeforeEach
public void setUp() {
    // Cria um cliente simulado para cada teste
    modelCliente = new ModelCliente();
    modelCliente.setCliNome("Nome do Cliente");
    // Define outros atributos do cliente conforme necessário
}


    
     @Test
    public void testGetClienteDAO() {
        // Cria uma instância do DAOCliente
        DAOCliente daoCliente = new DAOCliente();

        // Crie um ID de cliente existente no banco de dados
        int idClienteExistente = 1;

        // Chama o método getClienteDAO para buscar um cliente
        ModelCliente clienteEncontrado = daoCliente.getClienteDAO(idClienteExistente);

        // Verifica se o cliente retornado não é nulo
        assertNotNull(clienteEncontrado);
        // Verifica se o ID do cliente retornado corresponde ao ID esperado
        assertEquals(idClienteExistente, clienteEncontrado.getIdCliente());
        
        // Aqui você pode adicionar mais verificações para outros atributos do cliente, se necessário
    }
    
       @Test
    public void testGetClienteDAOByNome() {
        // Cria uma instância da classe DAOCliente
        DAOCliente daoCliente = new DAOCliente();

        // Define um nome de cliente existente no banco de dados
        String nomeCliente = "Cristiano Ronaldo da Silva";

        // Chama o método getClienteDAO para buscar um cliente pelo nome
        ModelCliente clienteRecuperado = daoCliente.getClienteDAO(nomeCliente);

        // Verifica se o cliente retornado não é nulo
        assertNotNull(clienteRecuperado);

        // Verifica se o nome do cliente retornado corresponde ao nome esperado
        assertEquals(nomeCliente, clienteRecuperado.getCliNome());

        // Você pode adicionar mais verificações para outros atributos do cliente, se necessário
    }
    
 @Test
public void testGetListaClienteDAO() {
    // Instancia a classe DAO de Cliente
    DAOCliente daoCliente = new DAOCliente();

    // Obtém a lista de clientes do DAO
    ArrayList<ModelCliente> listaRetornada = daoCliente.getListaClienteDAO();

    // Verifica se a lista retornada não é nula
    if (listaRetornada == null) {
        System.out.println("A lista de clientes é nula");
    } else {
        System.out.println("Lista de clientes:");
        for (ModelCliente modelCliente : listaRetornada) {
            System.out.println("ID: " + modelCliente.getIdCliente() +
                    ", Nome: " + modelCliente.getCliNome() +
                    ", Endereço: " + modelCliente.getCliEndereco() +
                    ", Bairro: " + modelCliente.getCliBairro() +
                    ", Cidade: " + modelCliente.getCliCidade() +
                    ", UF: " + modelCliente.getCliUf() +
                    ", CEP: " + modelCliente.getCliCep() +
                    ", Telefone: " + modelCliente.getCliTelefone());
        }
    }
}
    
    

    
   @Test
public void testSalvarClienteDAO() {
    // Obtendo o último ID de cliente existente no banco de dados
    DAOCliente daoCliente = new DAOCliente();
    ArrayList<ModelCliente> listaClientes = daoCliente.getListaClienteDAO();
    int ultimoID = 0;

    if (!listaClientes.isEmpty()) {
        // Encontrando o maior ID na lista de clientes
        for (ModelCliente cliente : listaClientes) {
            if (cliente.getIdCliente() > ultimoID) {
                ultimoID = cliente.getIdCliente();
            }
        }
    }

    // Incrementando o último ID para obter o próximo ID esperado para o novo cliente
    int proximoID = ultimoID +1 ;

    // Criando um cliente fictício para teste
    ModelCliente clienteTeste = new ModelCliente();
    clienteTeste.setCliNome("Cliente Teste");
    clienteTeste.setCliEndereco("Endereço Teste");
    clienteTeste.setCliBairro("Bairro Teste");
    clienteTeste.setCliCidade("Cidade Teste");
    clienteTeste.setCliUf("UF");
    clienteTeste.setCliCep("12345-678");
    clienteTeste.setCliTelefone("123456789");

    // Testando o salvamento do cliente
    int resultado = daoCliente.salvarClienteDAO(clienteTeste);

    // Verificando se o resultado foi satisfatório
    assertEquals(proximoID, resultado);
}

    @Test
public void testAtualizarClienteDAO() {
    // Obtendo o último ID de cliente existente no banco de dados
    DAOCliente daoCliente = new DAOCliente();
    ArrayList<ModelCliente> listaClientes = daoCliente.getListaClienteDAO();
    int ultimoID = 0;

    if (!listaClientes.isEmpty()) {
        // Encontrando o maior ID na lista de clientes
        for (ModelCliente cliente : listaClientes) {
            if (cliente.getIdCliente() > ultimoID) {
                ultimoID = cliente.getIdCliente();
            }
        }
    }

    // Criando um cliente fictício para atualização
    ModelCliente clienteAtualizado = new ModelCliente();
    clienteAtualizado.setIdCliente(ultimoID); // Definindo o ID do último cliente salvo
    clienteAtualizado.setCliNome("Novo Nome"); // Novo nome para o cliente
    clienteAtualizado.setCliEndereco("Novo Endereço"); // Novo endereço
    clienteAtualizado.setCliBairro("Novo Bairro"); // Novo bairro
    clienteAtualizado.setCliCidade("Nova Cidade"); // Nova cidade
    clienteAtualizado.setCliUf("UF"); // Nova UF
    clienteAtualizado.setCliCep("54321-987"); // Novo CEP
    clienteAtualizado.setCliTelefone("987654321"); // Novo telefone

    // Testando a atualização do cliente
    boolean resultadoAtualizacao = daoCliente.atualizarClienteDAO(clienteAtualizado);

    // Verificando se a atualização foi realizada com sucesso
    Assertions.assertTrue(resultadoAtualizacao);
}

@Test
public void testExcluirClienteDAO() {
    // Crie um cliente simulado para ser excluído
    ModelCliente clienteTeste = new ModelCliente();
    clienteTeste.setCliNome("Novo nome");
    // Defina outros atributos conforme necessário

    // Salve o cliente no banco de dados para obter o ID gerado
    DAOCliente daoCliente = new DAOCliente();
    int idCliente = daoCliente.salvarClienteDAO(clienteTeste);

    // Teste a exclusão do cliente pelo ID
    boolean exclusao = daoCliente.excluirClienteDAO(idCliente);

    // Verifique se a exclusão foi bem-sucedida
    assertTrue(exclusao);
}
    }




