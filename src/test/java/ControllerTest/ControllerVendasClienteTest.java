/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControllerTest;

import a.vendasy2.controller.ControllerVendasCliente;
import a.vendasy2.dao.DAOVendasCliente;
import a.vendasy2.model.ModelCliente;
import a.vendasy2.model.ModelVendas;
import a.vendasy2.model.ModelVendasCliente;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 *
 * @author jose_
 */
public class ControllerVendasClienteTest {
    
    private ControllerVendasCliente controllerVendasCliente;
    private DAOVendasCliente daoVendasCliente;

    @BeforeEach
    public void setUp() {
        // Instanciando o ControllerVendasCliente
        controllerVendasCliente = new ControllerVendasCliente();

        // Criando um mock para o DAOVendasCliente
        daoVendasCliente = Mockito.mock(DAOVendasCliente.class);
        controllerVendasCliente.daoVendasCliente = daoVendasCliente;
    }

    @Test
    public void testGetListaVendasClienteController() {
        // Criando uma lista simulada de ModelVendasCliente
        ArrayList<ModelVendasCliente> listaSimulada = new ArrayList<>();
       
        // Criando alguns objetos simulados de ModelVendas e ModelCliente
        ModelVendas venda1 = new ModelVendas();
        venda1.setIdVenda(1);
        venda1.setCliente(101);

        ModelCliente cliente1 = new ModelCliente();
        cliente1.setIdCliente(101);
        cliente1.setCliNome("Cliente A");
        
        // Criando um objeto ModelVendasCliente e associando o objeto ModelVendas e ModelCliente criados acima
        ModelVendasCliente vendasCliente1 = new ModelVendasCliente();
        vendasCliente1.setModelVendas(venda1);
        vendasCliente1.setModelCliente(cliente1);

        // Configurando o comportamento simulado para o método getListaVendasClienteDAO
        Mockito.when(daoVendasCliente.getListaVendasClienteDAO()).thenReturn(listaSimulada);

        // Invocando o método getListaVendasClienteController() do ControllerVendasCliente
        ArrayList<ModelVendasCliente> resultado = controllerVendasCliente.getListaVendasClienteController();

        // Verificando se o resultado obtido é igual à lista simulada
        assertEquals(listaSimulada, resultado);

        // Verificando se o método getListaVendasClienteDAO do mock foi chamado
        Mockito.verify(daoVendasCliente).getListaVendasClienteDAO();
    }
    
}
