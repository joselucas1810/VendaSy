/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerTest;
import a.vendasy2.controller.ControllerCliente;
import a.vendasy2.model.ModelCliente;
import a.vendasy2.dao.DAOCliente;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/**
 *
 * @author jose_
 */
public class ControllerClienteTest {
     private ControllerCliente controllerCliente;
    private DAOCliente daoCliente;

    @BeforeEach
    public void setUp() {
        // Crie uma instância do ControllerCliente
        controllerCliente = new ControllerCliente();

        // Crie um mock para o DAOCliente
        daoCliente = Mockito.mock(DAOCliente.class);
        controllerCliente.daoCliente = daoCliente;
    }

@Test
public void testAtualizarClienteController() {
    // Crie uma instância do ModelCliente com os dados para atualização
    ModelCliente cliente = new ModelCliente();
    cliente.setIdCliente(1);
    cliente.setCliNome("João do teste");
    cliente.setCliEndereco("Rua Teste");
    cliente.setCliBairro("Bairro teste");
    cliente.setCliCidade("Cidade teste");
    cliente.setCliUf("UF teste");
    cliente.setCliCep("32310210");
    cliente.setCliTelefone("31973737373");

    // Configure o comportamento do mock do DAOCliente para retornar true
    when(daoCliente.atualizarClienteDAO(cliente)).thenReturn(true);

    // Execute o método atualizarClienteController
    boolean resultado = controllerCliente.atualizarClienteController(cliente);

    // Verifique se o resultado é true (ou seja, a atualização foi bem-sucedida)
    assertTrue(resultado);

    // Verifique se o método atualizarClienteDAO do mock foi chamado com o cliente correto
    verify(daoCliente).atualizarClienteDAO(cliente);
}

@Test
    public void testExcluirClienteController() {
        int idCliente = 1; // Insira um ID de cliente válido para o teste

        // Configurar o comportamento simulado para o método excluirClienteDAO
        Mockito.when(daoCliente.excluirClienteDAO(idCliente)).thenReturn(true);

        boolean resultado = controllerCliente.excluirClienteController(idCliente);

        // Verificar se o resultado é verdadeiro para indicar que o cliente foi excluído com sucesso
        assertTrue(resultado);
    }
     @Test
    public void testSalvarClienteController() {
        // Crio um objeto ModelCliente para simular os dados do cliente a serem salvos
        ModelCliente cliente = new ModelCliente();
        cliente.setCliNome("Nome");
        cliente.setCliEndereco("Endereço");
        cliente.setCliBairro("Bairro");
        cliente.setCliCidade("Cidade");
        cliente.setCliUf("UF");
        cliente.setCliCep("CEP");
        cliente.setCliTelefone("Telefone");

        // Configuro o comportamento do mock para simular a inserção bem-sucedida no banco de dados (retorna 1, indicando um ID de cliente válido)
        when(daoCliente.salvarClienteDAO(cliente)).thenReturn(1);

        // Invoco o método salvarClienteController() do MeuController
        int resultadoSalvar = controllerCliente.salvarClienteController(cliente);

        // Verifico se o resultado da inserção é igual a 1 (indicando sucesso)
        assertEquals(1, resultadoSalvar);
    }
    @Test
    public void testGetClienteControllerPId() {
        int idCliente = 1; // Defino o ID do cliente para o teste

        // Crio um objeto ModelCliente para simular os dados do cliente retornado pelo DAO
        ModelCliente clienteRetornado = new ModelCliente();
        clienteRetornado.setIdCliente(idCliente);
        clienteRetornado.setCliNome("Nome");
        clienteRetornado.setCliEndereco("Endereço");
        clienteRetornado.setCliBairro("Bairro");
        clienteRetornado.setCliCidade("Cidade");
        clienteRetornado.setCliUf("UF");
        clienteRetornado.setCliCep("CEP");
        clienteRetornado.setCliTelefone("Telefone");

        // Configuro o comportamento do mock para simular o retorno do cliente pelo DAO
        when(daoCliente.getClienteDAO(idCliente)).thenReturn(clienteRetornado);

        // Invoco o método getClienteController() do MeuController
        ModelCliente resultadoCliente = controllerCliente.getClienteController(idCliente);

        // Verifico se o cliente retornado pelo controller é igual ao cliente simulado retornado pelo DAO
        assertEquals(clienteRetornado, resultadoCliente);
    }
     @Test
    public void testGetClienteControllerPNome() {
        String nomeCliente = "NomeCliente"; // Defino o nome do cliente para o teste

        // Crio um objeto ModelCliente para simular os dados do cliente retornado pelo DAO
        ModelCliente clienteRetornado = new ModelCliente();
        clienteRetornado.setIdCliente(1);
        clienteRetornado.setCliNome(nomeCliente);
        clienteRetornado.setCliEndereco("Endereço");
        clienteRetornado.setCliBairro("Bairro");
        clienteRetornado.setCliCidade("Cidade");
        clienteRetornado.setCliUf("UF");
        clienteRetornado.setCliCep("CEP");
        clienteRetornado.setCliTelefone("Telefone");

        // Configuro o comportamento do mock para simular o retorno do cliente pelo DAO
        when(daoCliente.getClienteDAO(nomeCliente)).thenReturn(clienteRetornado);

        // Invoco o método getClienteController() do MeuController
        ModelCliente resultadoCliente = controllerCliente.getClienteController(nomeCliente);

        // Verifico se o cliente retornado pelo controller é igual ao cliente simulado retornado pelo DAO
        assertEquals(clienteRetornado, resultadoCliente);
    }
     @Test
    public void testGetListaClienteController() {
        // Crio uma lista simulada de ModelCliente
        ArrayList<ModelCliente> listaSimulada = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ModelCliente cliente = new ModelCliente();
            cliente.setIdCliente(i);
            cliente.setCliNome("Cliente " + i);
            cliente.setCliEndereco("Endereço " + i);
            // Defina outros atributos conforme necessário
            listaSimulada.add(cliente);
        }

        // Configuro o comportamento do mock para simular o retorno da lista pelo DAO
       Mockito.when(daoCliente.getListaClienteDAO()).thenReturn(listaSimulada);

        // Invoco o método getListaClienteController() do MeuController
        ArrayList<ModelCliente> resultadoLista = controllerCliente.getListaClienteController();

        // Verifico se a lista retornada pelo controller é igual à lista simulada retornada pelo DAO
        assertEquals(listaSimulada.size(), resultadoLista.size());
        assertTrue(resultadoLista.containsAll(listaSimulada));
    }
}
