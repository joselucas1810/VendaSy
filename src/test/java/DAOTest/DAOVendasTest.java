/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOTest;

import a.vendasy2.dao.DAOVendas;
import a.vendasy2.model.ModelVendas;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class DAOVendasTest {
    
     // Instância do DAO a ser testado
    private DAOVendas vendasDAO = new DAOVendas();

    @Test
    public void testGetVendasDAO() {
        // ID de uma venda existente para teste
        int idVendaExistente = 3;

        // Testando retorno de uma venda existente
        ModelVendas vendaExistente = vendasDAO.getVendasDAO(idVendaExistente);

        // Verificando se a venda retornada não é nula
        assertNotNull(vendaExistente, "A venda existente foi retornada corretamente.");

        // Verificando se o ID da venda retornado é o esperado
        assertEquals(idVendaExistente, vendaExistente.getIdVenda(), "ID da venda retornado está correto.");
    }
    
    @Test
    public void testGetListaVendasDAO() {
        // Testando retorno de uma lista de vendas
        ArrayList<ModelVendas> listaVendas = vendasDAO.getListaVendasDAO();

        // Verificando se a lista não é nula
        assertNotNull(listaVendas, "A lista de vendas foi retornada corretamente.");

        // Verificando se a lista não está vazia
        assertFalse(listaVendas.isEmpty(), "A lista de vendas não está vazia.");

        // Verificando se a lista possui elementos
        assertTrue(listaVendas.size() > 0, "A lista de vendas contém elementos.");
    }
    
    @Test
public void testSalvarVendasDAO() {
    // Obtendo o último ID de venda existente no banco de dados
    DAOVendas daoVendas = new DAOVendas();
    ArrayList<ModelVendas> listaVendas = daoVendas.getListaVendasDAO();
    int ultimoID = 0;

    if (!listaVendas.isEmpty()) {
        // Encontrando o maior ID na lista de vendas
        for (ModelVendas venda : listaVendas) {
            if (venda.getIdVenda() > ultimoID) {
                ultimoID = venda.getIdVenda();
            }
        }
    }

    // Incrementando o último ID para obter o próximo ID esperado para a nova venda
    int proximoID = ultimoID + 1;

    // Criando um objeto ModelVendas para teste
    ModelVendas vendaTeste = new ModelVendas();
    vendaTeste.setCliente(1); // Substitua pelo ID do cliente

    // Convertendo a string de data para o formato Date
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dataVenda = null;
    try {
        // Definindo a data da venda (2023-11-20)
        dataVenda = dateFormat.parse("2023-11-20");
    } catch (ParseException e) {
        e.printStackTrace();
    }
    vendaTeste.setVenData(dataVenda); // Definindo a data da venda

    vendaTeste.setVenValorLiquido(100.0); // Substitua pelo valor líquido da venda
    vendaTeste.setVenValorBruto(120.0); // Substitua pelo valor bruto da venda
    vendaTeste.setVenDesconto(20.0); // Substitua pelo valor do desconto da venda

    // Testando o salvamento da venda
    int resultado = daoVendas.salvarVendasDAO(vendaTeste);

    // Verificando se o resultado foi satisfatório
    assertEquals(0, resultado); 
}

@Test
public void testAtualizarVendasDAO() {
    // Criando uma nova venda para posterior atualização
    ModelVendas vendaTeste = new ModelVendas();
    vendaTeste.setCliente(1); // Substitua pelo ID do cliente

    // Convertendo a string de data para o formato Date
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dataVenda = null;
    try {
        // Definindo a data da venda (2023-11-20)
        dataVenda = dateFormat.parse("2023-11-20");
    } catch (ParseException e) {
        e.printStackTrace();
    }
    vendaTeste.setVenData(dataVenda); // Definindo a data da venda

    vendaTeste.setVenValorLiquido(100.0); // Substitua pelo valor líquido da venda
    vendaTeste.setVenValorBruto(120.0); // Substitua pelo valor bruto da venda
    vendaTeste.setVenDesconto(20.0); // Substitua pelo valor do desconto da venda

    // Salvando a venda para obter o ID gerado
    DAOVendas daoVendas = new DAOVendas();
    int idVendaSalva = daoVendas.salvarVendasDAO(vendaTeste);

    // Modificando os dados da venda para atualização
    vendaTeste.setIdVenda(idVendaSalva);
    vendaTeste.setVenValorLiquido(150.0); // Novo valor líquido da venda
    vendaTeste.setVenValorBruto(180.0); // Novo valor bruto da venda

    // Testando a atualização da venda
    boolean atualizacao = daoVendas.atualizarVendasDAO(vendaTeste);

    // Verificando se a atualização foi bem-sucedida
    assertTrue(atualizacao);
}

@Test
public void testExcluirVendasDAO() {
    // Criando uma nova venda para posterior exclusão
    ModelVendas vendaTeste = new ModelVendas();
    vendaTeste.setCliente(1); // Substitua pelo ID do cliente

    // Convertendo a string de data para o formato Date
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dataVenda = null;
    try {
        // Definindo a data da venda (2023-11-20)
        dataVenda = dateFormat.parse("2023-11-20");
    } catch (ParseException e) {
        e.printStackTrace();
    }
    vendaTeste.setVenData(dataVenda); // Definindo a data da venda

    vendaTeste.setVenValorLiquido(100.0); // Substitua pelo valor líquido da venda
    vendaTeste.setVenValorBruto(120.0); // Substitua pelo valor bruto da venda
    vendaTeste.setVenDesconto(20.0); // Substitua pelo valor do desconto da venda

    // Salvando a venda para obter o ID gerado
    DAOVendas daoVendas = new DAOVendas();
    int idVendaSalva = daoVendas.salvarVendasDAO(vendaTeste);

    // Testando a exclusão da venda
    boolean exclusao = daoVendas.excluirVendasDAO(idVendaSalva);

    // Verificando se a exclusão foi bem-sucedida
    assertTrue(exclusao);
}
}
