package ControllerTest;


import a.vendasy2.controller.ControllerProdutosVendasProdutos;
import a.vendasy2.dao.DAOProdutosVendasProdutos;
import a.vendasy2.dao.DAOVendasProdutos;
import a.vendasy2.model.ModelProdutosVendasProdutos;
import a.vendasy2.model.ModelVendasProdutos;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jose_
 */
public class ControllerProdutosVendasProdutosTest {
  
  private ControllerProdutosVendasProdutos controllerProdutosVendasProdutos;
    private DAOProdutosVendasProdutos daoProdutosVendasProdutos;

    @BeforeEach
    public void setUp() {
        // Instanciando o ControllerProdutosVendasProdutos
        controllerProdutosVendasProdutos = new ControllerProdutosVendasProdutos();

        // Criando um mock para o DAOProdutosVendasProdutos
        daoProdutosVendasProdutos = Mockito.mock(DAOProdutosVendasProdutos.class);
        controllerProdutosVendasProdutos.dAOProdutosVendasProdutos = daoProdutosVendasProdutos;
    }

    @Test
    public void testGetListaProdutosVendasProdutosController() {
        // Criando um código de venda simulado para o teste
        int codigoVendaSimulado = 123;

        // Criando objetos simulados para a lista de ModelProdutosVendasProdutos
        ArrayList<ModelProdutosVendasProdutos> listaSimulada = new ArrayList<>();

        // Criando alguns objetos simulados para ModelProdutosVendasProdutos, ModelProdutos e ModelVendasProdutos
        ModelProdutosVendasProdutos produtoVendasProdutos1 = new ModelProdutosVendasProdutos();
  

        ModelProdutosVendasProdutos produtoVendasProdutos2 = new ModelProdutosVendasProdutos();


        // Adicionando os objetos simulados à lista simulada
        listaSimulada.add(produtoVendasProdutos1);
        listaSimulada.add(produtoVendasProdutos2);

        // Configurando o comportamento simulado para o método getListaProdutosVendasProdutosDAO
        Mockito.when(daoProdutosVendasProdutos.getListaProdutosVendasProdutosDAO(codigoVendaSimulado)).thenReturn(listaSimulada);

        // Invocando o método getListaProdutosVendasProdutosController() do ControllerProdutosVendasProdutos
        ArrayList<ModelProdutosVendasProdutos> resultado = controllerProdutosVendasProdutos.getListaProdutosVendasProdutosController(codigoVendaSimulado);

        // Verificando se o resultado obtido é igual à lista simulada
        assertEquals(listaSimulada, resultado);

        // Verificando se o método getListaProdutosVendasProdutosDAO do mock foi chamado
        Mockito.verify(daoProdutosVendasProdutos).getListaProdutosVendasProdutosDAO(codigoVendaSimulado);
    }
}
