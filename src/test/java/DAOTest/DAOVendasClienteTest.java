/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOTest;

import a.vendasy2.dao.DAOVendas;
import a.vendasy2.dao.DAOVendasCliente;
import a.vendasy2.model.ModelVendas;
import a.vendasy2.model.ModelVendasCliente;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose_
 */
public class DAOVendasClienteTest {


    // Instância do DAO a ser testado
    private DAOVendasCliente vendasClienteDAO = new DAOVendasCliente();

    @Test
    public void testGetListaVendasClienteDAO() {
        // Testando retorno da lista de vendas com informações de clientes
        ArrayList<ModelVendasCliente> listaVendasCliente = vendasClienteDAO.getListaVendasClienteDAO();

        // Verificando se a lista não é nula
        assertNotNull(listaVendasCliente, "A lista de vendas com informações de clientes foi retornada corretamente.");

        // Verificando se a lista não está vazia
        assertFalse(listaVendasCliente.isEmpty(), "A lista de vendas com informações de clientes não está vazia.");

        // Verificando se a lista possui elementos
        assertTrue(listaVendasCliente.size() > 0, "A lista de vendas com informações de clientes contém elementos.");
    }
}
