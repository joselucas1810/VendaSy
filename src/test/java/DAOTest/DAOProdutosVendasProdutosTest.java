/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOTest;

import a.vendasy2.dao.DAOProdutosVendasProdutos;
import a.vendasy2.model.ModelProdutosVendasProdutos;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose_
 */
public class DAOProdutosVendasProdutosTest {
    
     // Instância do DAO a ser testado
    private DAOProdutosVendasProdutos produtosVendasProdutosDAO = new DAOProdutosVendasProdutos();

    @Test
    public void testGetListaProdutosVendasProdutosDAO() {
        // ID de uma venda existente para teste
        int codigoVendaExistente = 19;

        // Testando retorno da lista de produtos associados a uma venda existente
        ArrayList<ModelProdutosVendasProdutos> listaProdutosVendasProdutos = produtosVendasProdutosDAO.getListaProdutosVendasProdutosDAO(codigoVendaExistente);

        // Verificando se a lista não é nula
        assertNotNull(listaProdutosVendasProdutos, "A lista de produtos associados a uma venda foi retornada corretamente.");

        // Verificando se a lista não está vazia
        assertFalse(listaProdutosVendasProdutos.isEmpty(), "A lista de produtos associados a uma venda não está vazia.");

        // Verificando se a lista possui elementos
        assertTrue(listaProdutosVendasProdutos.size() > 0, "A lista de produtos associados a uma venda contém elementos.");
    }
}
