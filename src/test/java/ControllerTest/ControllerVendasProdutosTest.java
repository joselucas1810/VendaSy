/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerTest;

/**
 *
 * @author jose_
 */


import a.vendasy2.controller.ControllerVendasProdutos;
import a.vendasy2.dao.DAOVendasProdutos;
import a.vendasy2.model.ModelVendasProdutos;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class ControllerVendasProdutosTest {
private ControllerVendasProdutos controllerVendasProdutos;
private DAOVendasProdutos daoVendasProdutos;


        @BeforeEach
    public void setUp() {
        // Crie uma instância do ControllerVendasProdutos
        controllerVendasProdutos = new ControllerVendasProdutos();

        // Crie um mock para o DAOVendasProdutos
        daoVendasProdutos = Mockito.mock(DAOVendasProdutos.class);
        controllerVendasProdutos.daoVendasProdutos = daoVendasProdutos;
    }
  // Teste para o método salvarVendasProdutosController
    @Test
    public void testSalvarVendasProdutosController() {
        // Criando um objeto ModelVendasProdutos simulado
        ModelVendasProdutos vendaProduto = new ModelVendasProdutos();
        vendaProduto.setProduto(1); // Simulando o ID do produto
        vendaProduto.setVendas(1); // Simulando o ID da venda
        vendaProduto.setVenProValor(100.0); // Simulando o valor do produto na venda
        vendaProduto.setVenProQuantidade(5); // Simulando a quantidade do produto vendido

        // Configurando o comportamento simulado para o método salvarVendasProdutosDAO
        Mockito.when(daoVendasProdutos.salvarVendasProdutosDAO(vendaProduto)).thenReturn(1); // Simulando a inserção bem-sucedida no banco de dados

        // Invocando o método salvarVendasProdutosController() do ControllerVendasProdutos
        int resultadoSalvar = controllerVendasProdutos.salvarVendasProdutosController(vendaProduto);

        // Verificando se o resultado da inserção é igual a 1 (indicando sucesso)
        assertEquals(1, resultadoSalvar);

        // Verificando se o método salvarVendasProdutosDAO do mock foi chamado com o objeto ModelVendasProdutos correto
        Mockito.verify(daoVendasProdutos).salvarVendasProdutosDAO(vendaProduto);
    }
    
    // Teste para o método getVendasProdutosController
    @Test
    public void testGetVendasProdutosController() {
        // Simulando um ID de venda de produto
        int idVendaProduto = 1;

        // Criando um objeto ModelVendasProdutos simulado
        ModelVendasProdutos vendaProdutoSimulado = new ModelVendasProdutos();
        vendaProdutoSimulado.setIdVendaProduto(idVendaProduto);
        vendaProdutoSimulado.setProduto(1); // Defina valores simulados para o produto, venda, valor e quantidade

        // Configurando o comportamento simulado para o método getVendasProdutosDAO
        Mockito.when(daoVendasProdutos.getVendasProdutosDAO(idVendaProduto)).thenReturn(vendaProdutoSimulado); // Simulando a recuperação do objeto pelo DAO

        // Invocando o método getVendasProdutosController() do ControllerVendasProdutos
        ModelVendasProdutos resultadoGet = controllerVendasProdutos.getVendasProdutosController(idVendaProduto);

        // Verificando se o resultado retornado pelo método é igual ao esperado
        assertEquals(vendaProdutoSimulado, resultadoGet);

        // Verificando se o método getVendasProdutosDAO do mock foi chamado com o ID de venda correto
        Mockito.verify(daoVendasProdutos).getVendasProdutosDAO(idVendaProduto);
    }
    
    // Teste para o método getListaVendasProdutosController
    @Test
    public void testGetListaVendasProdutosController() {
        // Criando uma lista simulada de ModelVendasProdutos
        ArrayList<ModelVendasProdutos> listaSimulada = new ArrayList<>();
        // Adicionando um ModelVendasProdutos à lista simulada
        ModelVendasProdutos vendaProduto = new ModelVendasProdutos();
        vendaProduto.setIdVendaProduto(1);
        vendaProduto.setProduto(1);
        vendaProduto.setVendas(1);
        vendaProduto.setVenProValor(100.0);
        vendaProduto.setVenProQuantidade(5);
        listaSimulada.add(vendaProduto);

        // Configurando o comportamento simulado para o método getListaVendasProdutosDAO
        Mockito.when(daoVendasProdutos.getListaVendasProdutosDAO()).thenReturn(listaSimulada);

        // Invocando o método getListaVendasProdutosController do ControllerVendasProdutos
        ArrayList<ModelVendasProdutos> resultado = controllerVendasProdutos.getListaVendasProdutosController();

        // Verificando se o resultado obtido é igual à lista simulada
        assertEquals(listaSimulada, resultado);

        // Verificando se o método getListaVendasProdutosDAO do mock foi chamado
        Mockito.verify(daoVendasProdutos).getListaVendasProdutosDAO();
    }
    
    // Teste para o método atualizarVendasProdutosController
    @Test
    public void testAtualizarVendasProdutosController() {
        // Criando um objeto ModelVendasProdutos simulado para atualização
        ModelVendasProdutos vendaProduto = new ModelVendasProdutos();
        vendaProduto.setIdVendaProduto(1); // Simulando o ID do produto da venda
        vendaProduto.setProduto(1); // Simulando o ID do produto
        vendaProduto.setVendas(1); // Simulando o ID da venda
        vendaProduto.setVenProValor(100.0); // Simulando o valor do produto na venda
        vendaProduto.setVenProQuantidade(5); // Simulando a quantidade do produto vendido

        // Configurando o comportamento simulado para o método atualizarVendasProdutosDAO
        Mockito.when(daoVendasProdutos.atualizarVendasProdutosDAO(vendaProduto)).thenReturn(true); // Simulando a atualização bem-sucedida no banco de dados

        // Invocando o método atualizarVendasProdutosController do ControllerVendasProdutos
        boolean resultadoAtualizacao = controllerVendasProdutos.atualizarVendasProdutosController(vendaProduto);

        // Verificando se o resultado da atualização é verdadeiro (indicando sucesso)
        assertTrue(resultadoAtualizacao);

        // Verificando se o método atualizarVendasProdutosDAO do mock foi chamado com o objeto ModelVendasProdutos correto
        Mockito.verify(daoVendasProdutos).atualizarVendasProdutosDAO(vendaProduto);
    }
    
    // Teste para o método excluirVendasProdutosController
    @Test
    public void testExcluirVendasProdutosController() {
        int idVendaProduto = 1; // ID do produto da venda a ser excluído

        // Configurando o comportamento simulado para o método excluirVendasProdutosDAO
        Mockito.when(daoVendasProdutos.excluirVendasProdutosDAO(idVendaProduto)).thenReturn(true); // Simulando a exclusão bem-sucedida no banco de dados

        // Invocando o método excluirVendasProdutosController do ControllerVendasProdutos
        boolean resultadoExclusao = controllerVendasProdutos.excluirVendasProdutosController(idVendaProduto);

        // Verificando se o resultado da exclusão é verdadeiro (indicando sucesso)
        assertTrue(resultadoExclusao);

        // Verificando se o método excluirVendasProdutosDAO do mock foi chamado com o ID correto
        Mockito.verify(daoVendasProdutos).excluirVendasProdutosDAO(idVendaProduto);
    }
    
    // Teste para o método salvarVendasProdutosController
    @Test
    public void testSalvarVendasProdutosControllerLista() {
        ArrayList<ModelVendasProdutos> listaVendasProdutos = new ArrayList<>();
        // Adicionando um ModelVendasProdutos simulado à lista
        ModelVendasProdutos vendaProduto1 = new ModelVendasProdutos();
        vendaProduto1.setProduto(1); // Simulando o ID do produto
        vendaProduto1.setVendas(1); // Simulando o ID da venda
        vendaProduto1.setVenProValor(100.0); // Simulando o valor do produto na venda
        vendaProduto1.setVenProQuantidade(5); // Simulando a quantidade do produto vendido
        listaVendasProdutos.add(vendaProduto1);

        // Configurando o comportamento simulado para o método salvarVendasProdutosDAO
        Mockito.when(daoVendasProdutos.salvarVendasProdutosDAO(listaVendasProdutos)).thenReturn(true); // Simulando a inserção bem-sucedida no banco de dados

        // Invocando o método salvarVendasProdutosController do ControllerVendasProdutos
        boolean resultadoSalvar = controllerVendasProdutos.salvarVendasProdutosController(listaVendasProdutos);

        // Verificando se o resultado da inserção é verdadeiro (indicando sucesso)
        assertTrue(resultadoSalvar);

        // Verificando se o método salvarVendasProdutosDAO do mock foi chamado com a lista de produtos correta
        Mockito.verify(daoVendasProdutos).salvarVendasProdutosDAO(listaVendasProdutos);
    }
}