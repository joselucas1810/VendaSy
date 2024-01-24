/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOTest;

import a.vendasy2.dao.DAOProdutos;
import a.vendasy2.dao.DAOVendasProdutos;
import a.vendasy2.model.ModelProdutos;
import a.vendasy2.model.ModelVendasProdutos;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose_
 */
public class DAOVendasProdutosTest {
    
    // Instância do DAO a ser testado
    private DAOVendasProdutos vendasProdutosDAO = new DAOVendasProdutos();
    
    @Test
    public void testGetVendasProdutosDAO() {
        // ID de um produto de venda existente para teste
        int idVendaProdutoExistente = 118;

        // Testando retorno de um produto de venda existente
        ModelVendasProdutos vendaProdutoExistente = vendasProdutosDAO.getVendasProdutosDAO(idVendaProdutoExistente);

        // Verificando se o produto de venda retornado não é nulo
        assertNotNull(vendaProdutoExistente, "O produto de venda existente foi retornado corretamente.");

        // Verificando se o ID do produto de venda retornado é o esperado
        assertEquals(idVendaProdutoExistente, vendaProdutoExistente.getIdVendaProduto(), "ID do produto de venda retornado está correto.");

    }
    
    @Test
    public void testGetListaVendasProdutosDAO() {
        // Testando retorno de uma lista de produtos de venda
        ArrayList<ModelVendasProdutos> listaVendasProdutos = vendasProdutosDAO.getListaVendasProdutosDAO();

        // Verificando se a lista não é nula
        assertNotNull(listaVendasProdutos, "A lista de produtos de venda foi retornada corretamente.");

        // Verificando se a lista não está vazia
        assertFalse(listaVendasProdutos.isEmpty(), "A lista de produtos de venda não está vazia.");

        // Verificando se a lista possui elementos
        assertTrue(listaVendasProdutos.size() > 0, "A lista de produtos de venda contém elementos.");
    }
    
    @Test
public void testSalvarVendasProdutosDAO() {
    
    DAOVendasProdutos daoVendasProdutos = new DAOVendasProdutos();
    
    // Criando um novo objeto ModelVendasProdutos para testar
    ModelVendasProdutos vendasProdutos = new ModelVendasProdutos();
    vendasProdutos.setProduto(1); // Substitua pelo ID do produto
    vendasProdutos.setVendas(20); // Substitua pelo ID da venda
    vendasProdutos.setVenProValor(75); // Substitua pelo valor do produto na venda
    vendasProdutos.setVenProQuantidade(2); // Substitua pela quantidade vendida do produto

    // Testando o salvamento do VendasProdutos
    int resultado = daoVendasProdutos.salvarVendasProdutosDAO(vendasProdutos);

    // Verificando se o resultado foi satisfatório
    assertTrue(resultado > 0);
}

@Test
public void testAtualizarVendasProdutosDAO() {
    // Criando um objeto DAOVendasProdutos para acessar o método atualizarVendasProdutosDAO
    DAOVendasProdutos daoVendasProdutos = new DAOVendasProdutos();

    // Criando um objeto ModelVendasProdutos para teste com dados já existentes no banco de dados
    ModelVendasProdutos vendasProdutosTeste = new ModelVendasProdutos();
    vendasProdutosTeste.setIdVendaProduto(1); // Substitua pelo ID do produto da venda que deseja atualizar
    vendasProdutosTeste.setProduto(46); // Substitua pelo novo ID do produto da venda
    vendasProdutosTeste.setVendas(20); // Substitua pelo novo ID da venda
    vendasProdutosTeste.setVenProValor(75); // Substitua pelo novo valor do produto na venda
    vendasProdutosTeste.setVenProQuantidade(2); // Substitua pela nova quantidade vendida do produto

    // Testando a atualização dos dados dos produtos na venda
    boolean resultado = daoVendasProdutos.atualizarVendasProdutosDAO(vendasProdutosTeste);

    // Verificando se o resultado foi satisfatório
    assertTrue(resultado);
}

@Test
public void testSalvarVendasProdutosDAOLista() {
    // Criando um objeto DAOVendasProdutos para acessar o método salvarVendasProdutosDAO
    DAOVendasProdutos daoVendasProdutos = new DAOVendasProdutos();

    // Criando uma lista de ModelVendasProdutos para teste
    ArrayList<ModelVendasProdutos> listaVendasProdutos = new ArrayList<>();

    // Adicionando itens à lista de vendas de produtos
    ModelVendasProdutos vendasProdutos1 = new ModelVendasProdutos();
    vendasProdutos1.setProduto(1); // Substitua pelo ID do produto
    vendasProdutos1.setVendas(1); // Substitua pelo ID da venda
    vendasProdutos1.setVenProValor(50.0); // Substitua pelo valor do produto na venda
    vendasProdutos1.setVenProQuantidade(2); // Substitua pela quantidade vendida do produto
    listaVendasProdutos.add(vendasProdutos1);

    // Adicione mais itens à lista, se necessário

    // Testando o salvamento da lista de vendas de produtos
    boolean resultado = daoVendasProdutos.salvarVendasProdutosDAO(listaVendasProdutos);

    // Verificando se o resultado foi satisfatório
    assertTrue(resultado);
}

@Test
public void testExcluirVendasProdutosDAO() {
    // Crie um objeto DAOVendasProdutos para acessar o método de exclusão
    DAOVendasProdutos daoVendasProdutos = new DAOVendasProdutos();

    // Suponha o ID de venda do produto que foi salvo no testeSalvarVendasProdutosDAO
    int idVendaProdutoParaExcluir = 1;

    // Teste a exclusão do registro de venda de produto usando o método DAO
    boolean exclusaoBemSucedida = daoVendasProdutos.excluirVendasProdutosDAO(idVendaProdutoParaExcluir);

    // Verifique se a exclusão foi bem-sucedida (espera-se que seja verdadeira)
    assertTrue(exclusaoBemSucedida);
}

}
