/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOTest;

import a.vendasy2.dao.DAOProdutos;
import a.vendasy2.model.ModelProdutos;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose_
 */
public class DAOProdutosTest {
     // Instância do DAO a ser testado
    private DAOProdutos produtoDAO = new DAOProdutos();

    @Test
    public void testRetornarProdutoDAO() {
        // ID de um produto existente para teste
        int idProdutoExistente = 1;

        // Testando retorno de um produto existente
        ModelProdutos produtoExistente = produtoDAO.retornarProdutoDAO(idProdutoExistente);

        // Verificando se o produto retornado não é nulo
        assertNotNull(produtoExistente, "O produto existente foi retornado corretamente.");

        // Verificando se o ID do produto retornado é o esperado
        assertEquals(idProdutoExistente, produtoExistente.getIdProduto(), "ID do produto retornado está correto.");
    }
    
    @Test
    public void testRetornarProdutoPorNomeDAO() {
        // Nome de um produto existente para teste
        String nomeProdutoExistente = "Heineken";

        // Testando retorno de um produto existente pelo nome
        ModelProdutos produtoExistente = produtoDAO.retornarProdutoDAO(nomeProdutoExistente);

        // Verificando se o produto retornado não é nulo
        assertNotNull(produtoExistente, "O produto existente foi retornado corretamente.");

        // Verificando se o nome do produto retornado é o esperado
        assertEquals(nomeProdutoExistente, produtoExistente.getProNome(), "Nome do produto retornado esta correto.");

    }
    
     @Test
    public void testRetornarListaProdutosDAO() {
        // Testando retorno de uma lista de produtos
        ArrayList<ModelProdutos> listaProdutos = produtoDAO.retornarListaProdutosDAO();

        // Verificando se a lista não é nula
        assertNotNull(listaProdutos, "A lista de produtos foi retornada corretamente.");

        // Verificando se a lista não está vazia
        assertFalse(listaProdutos.isEmpty(), "A lista de produtos não está vazia.");

        // Verificando se a lista possui elementos
        assertTrue(listaProdutos.size() > 0, "A lista de produtos contém elementos.");
    }
    
        @Test
public void testSalvarProdutosDAO() {
    
    DAOProdutos daoProdutos = new DAOProdutos();
    
    // Criando um objeto ModelProdutos para testar
    ModelProdutos produtoTeste = new ModelProdutos();
    produtoTeste.setProNome("Nome do Produto");
    produtoTeste.setProValor(50.0); 
    produtoTeste.setProEstoque(10); 

    // Testando o salvamento do produto
    int resultado = daoProdutos.salvarProdutosDAO(produtoTeste);

    // Verificando se o resultado foi satisfatório
    assertTrue(resultado > 0);
}
@Test
public void testAlterarProdutoDAO() {
    
    DAOProdutos daoProdutos = new DAOProdutos();

    
    // Criando um objeto ModelProdutos para realizar a alteração
    ModelProdutos produtoTeste = new ModelProdutos();
    produtoTeste.setIdProduto(1); // Substitua pelo ID do produto criado no teste anterior
    produtoTeste.setProNome("Novo Nome do Produto");
    produtoTeste.setProValor(75.0); // Novo valor do produto
    produtoTeste.setProEstoque(15); // Nova quantidade em estoque do produto

    // Testando a alteração do produto
    boolean resultado = daoProdutos.alterarProdutoDAO(produtoTeste);

    // Verificando se o resultado foi satisfatório
    assertTrue(resultado);
}

@Test
public void testAlterarEstoqueProdutosDAO() {
    
       DAOProdutos daoProdutos = new DAOProdutos();

    
    // Criando uma lista de ModelProdutos para alterar o estoque
    ArrayList<ModelProdutos> listaProdutos = new ArrayList<>();

    // Adicionando produtos à lista com alterações de estoque
    ModelProdutos produto1 = new ModelProdutos();
    produto1.setIdProduto(1); // Substitua pelo ID do primeiro produto
    produto1.setProEstoque(25); // Novo estoque do primeiro produto
    listaProdutos.add(produto1);

    ModelProdutos produto2 = new ModelProdutos();
    produto2.setIdProduto(2); // Substitua pelo ID do segundo produto
    produto2.setProEstoque(50); // Novo estoque do segundo produto
    listaProdutos.add(produto2);

    // Testando a alteração de estoque dos produtos
    boolean resultado = daoProdutos.alterarEstoqueProdutosDAO(listaProdutos);

    // Verificando se o resultado foi satisfatório
    assertTrue(resultado);
}

  @Test
    public void testExcluirProdutoDAOComExcecao() {
        DAOProdutos produtosDAO = new DAOProdutos();
        int idProdutoExistente = 17; // Substitua pelo ID existente no seu banco de dados

        // Tenta excluir o produto e verifica se a exclusão foi bem-sucedida
        boolean exclusaoBemSucedida = produtosDAO.excluirProdutoDAO(idProdutoExistente);
        
        // Verifica se a exclusão foi realizada com sucesso
        assertTrue( exclusaoBemSucedida);
    }
}

