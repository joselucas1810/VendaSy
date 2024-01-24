package ControllerTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jose_
 */
import a.vendasy2.controller.ControllerProdutos;
import a.vendasy2.dao.DAOProdutos;
import a.vendasy2.model.ModelProdutos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.mockito.Mockito;

public class ControllerProdutosTest {

    private ControllerProdutos controllerProdutos;
    private DAOProdutos daoProdutos;

    public ControllerProdutosTest() {
    }

    @BeforeEach
    public void setUp() {
       // Crie uma instância do ControllerProdutos
        controllerProdutos = new ControllerProdutos();

        // Crie um mock para o DAOProdutos
        daoProdutos = Mockito.mock(DAOProdutos.class);
        controllerProdutos.daoProdutos = daoProdutos;
    }

     @Test
    public void testAlterarEstoqueProdutoController() {
        // Crio uma lista simulada de ModelProdutos com valores de estoque alterados
        ArrayList<ModelProdutos> listaSimulada = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ModelProdutos produto = new ModelProdutos();
            produto.setIdProduto(i);
            produto.setProEstoque(20 * i); // Simulo um novo valor de estoque
            listaSimulada.add(produto);
        }

        // Configuro o comportamento do mock para simular a atualização de estoque pelo DAO
        Mockito.when(daoProdutos.alterarEstoqueProdutosDAO(listaSimulada)).thenReturn(true);

        // Invoco o método alterarEstoqueProdutoController() do Controller de Produtos
        boolean resultado = controllerProdutos.alterarEstoqueProdutoController(listaSimulada);

        // Verifico se a alteração de estoque foi realizada com sucesso
        assertTrue(resultado);
    }

   @Test
    public void testRetornarListaProdutoController() {
        // Crio uma lista simulada de ModelProdutos
        ArrayList<ModelProdutos> listaSimulada = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ModelProdutos produto = new ModelProdutos();
            produto.setIdProduto(i);
            produto.setProNome("Produto " + i);
            produto.setProValor(10.0 * i);
            produto.setProEstoque(20 * i);
            listaSimulada.add(produto);
        }

        // Configuro o comportamento do mock para simular o retorno da lista pelo DAO
        Mockito.when(daoProdutos.retornarListaProdutosDAO()).thenReturn(listaSimulada);

        // Invoco o método retornarListaProdutoController() do Controller de Produtos
        ArrayList<ModelProdutos> resultadoLista = controllerProdutos.retornarListaProdutoController();

        // Verifico se a lista retornada pelo controller é igual à lista simulada retornada pelo DAO
        assertEquals(listaSimulada.size(), resultadoLista.size());
        assertEquals(listaSimulada, resultadoLista);
    }



        @Test
    public void testSalvarProdutoController() {
        // Crie um objeto ModelProdutos para simular os dados do produto a serem salvos
        ModelProdutos produto = new ModelProdutos();
        produto.setProNome("Nome do produto");
        produto.setProValor(10.0);
        produto.setProEstoque(20);

        // Configurar o comportamento do mock para simular a inserção bem-sucedida no banco de dados (retorna 1, indicando um ID de produto válido)
        Mockito.when(daoProdutos.salvarProdutosDAO(produto)).thenReturn(1);

        // Invoco o método salvarProdutoController() do ControllerProdutos
        int resultadoSalvar = controllerProdutos.salvarProdutoController(produto);

        // Verifico se o resultado da inserção é igual a 1 (indicando sucesso)
        assertEquals(1, resultadoSalvar);
    }
        @Test
    public void testExcluirProdutoController() {
        // Configuro o comportamento do mock para simular a exclusão de um produto pelo DAO
        Mockito.when(daoProdutos.excluirProdutoDAO(1)).thenReturn(true);

        // Invoco o método excluirProdutoController() do Controller de Produtos
        boolean resultadoExclusao = controllerProdutos.excluirProdutoController(1);

        // Verifico se a exclusão foi realizada com sucesso
        assertTrue(resultadoExclusao);

        // Configuro o comportamento do mock para simular a falha na exclusão de um produto pelo DAO
        Mockito.when(daoProdutos.excluirProdutoDAO(2)).thenReturn(false);

        // Invoco o método excluirProdutoController() do Controller de Produtos
        boolean resultadoFalhaExclusao = controllerProdutos.excluirProdutoController(2);

        // Verifico se a exclusão falhou (retornando false)
        assertFalse(resultadoFalhaExclusao);
    }
        @Test
    public void testRetornarProdutoController() {
        // Crio um objeto ModelProdutos para simular um produto retornado pelo DAO
        ModelProdutos produtoRetornado = new ModelProdutos();
        produtoRetornado.setIdProduto(1);
        produtoRetornado.setProNome("Produto Teste");
        produtoRetornado.setProValor(10.0);
        produtoRetornado.setProEstoque(50);

        // Configuro o comportamento do mock para simular o retorno de um produto pelo DAO
        Mockito.when(daoProdutos.retornarProdutoDAO(1)).thenReturn(produtoRetornado);

        // Invoco o método retornarProdutoController() do Controller de Produtos
        ModelProdutos resultadoProduto = controllerProdutos.retornarProdutoController(1);

        // Verifico se o produto retornado pelo Controller é igual ao produto simulado retornado pelo DAO
        assertEquals(produtoRetornado, resultadoProduto);
    }
     @Test
    public void testRetornarProdutoControllerS() {
        // Crio um objeto ModelProdutos simulando o retorno esperado do DAO
        ModelProdutos produtoSimulado = new ModelProdutos();
        produtoSimulado.setIdProduto(1);
        produtoSimulado.setProNome("Produto Teste");
        produtoSimulado.setProValor(25.99);
        produtoSimulado.setProEstoque(10);

        // Configuro o comportamento do mock para simular o retorno do produto pelo DAO
        Mockito.when(daoProdutos.retornarProdutoDAO("Produto Teste")).thenReturn(produtoSimulado);

        // Invoco o método retornarProdutoControllerS() do Controller de Produtos
        ModelProdutos resultadoProduto = controllerProdutos.retornarProdutoControllerS("Produto Teste");

        // Verifico se o produto retornado é igual ao produto simulado
        assertEquals(produtoSimulado, resultadoProduto);
    }
     @Test
    public void testAlterarProdutoController() {
        // Crio um objeto ModelProdutos para simular os dados do produto a serem alterados
        ModelProdutos produtoParaAlterar = new ModelProdutos();
        produtoParaAlterar.setIdProduto(1);
        produtoParaAlterar.setProNome("Novo Nome do Produto");
        produtoParaAlterar.setProValor(39.99);
        produtoParaAlterar.setProEstoque(15);

        // Configuro o comportamento do mock para simular a alteração do produto pelo DAO
        Mockito.when(daoProdutos.alterarProdutoDAO(produtoParaAlterar)).thenReturn(true);

        // Invoco o método alterarProdutoController() do Controller de Produtos
        boolean resultadoAlteracao = controllerProdutos.alterarProdutoController(produtoParaAlterar);

        // Verifico se a alteração foi realizada com sucesso
        assertTrue(resultadoAlteracao);
    }
}

