package ControllerTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jose_
 */
import a.vendasy2.controller.ControllerVendas;
import a.vendasy2.model.ModelVendas;
import a.vendasy2.dao.DAOVendas;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.assertEquals;



import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControllerVendasTest {

    private ControllerVendas controllerVendas;
    private DAOVendas daoVendas;

    @BeforeEach
    public void setUp() {
        // Crie uma instância do ControllerVendas
        controllerVendas = new ControllerVendas();

        // Crie um mock para o DAOVendas
        daoVendas = Mockito.mock(DAOVendas.class);
        controllerVendas.daoVendas = daoVendas;
    }



@Test
    public void testExcluirVendasController() {
        int idVenda = 1; // Insira um ID de venda válido para o teste

        // Simule o retorno do DAOVendas
        Mockito.when(daoVendas.excluirVendasDAO(idVenda)).thenReturn(true); // Retorne o valor desejado (true) aqui

        boolean resultado = controllerVendas.excluirVendasController(idVenda);

        // Verifique se o resultado é verdadeiro para indicar que a venda foi excluída com sucesso
        assertTrue(resultado);
    }
 
     @Test
    public void testSalvarVendasController() throws ParseException {
        // Criando um objeto ModelVendas simulado
        ModelVendas venda = new ModelVendas();
        venda.setCliente(1); // Simulando o cliente
        venda.setVenValorLiquido(100.0); // Simulando o valor líquido da venda
        venda.setVenValorBruto(120.0); // Simulando o valor bruto da venda
        venda.setVenDesconto(20.0); // Simulando o desconto aplicado na venda

        // Definindo a data no formato desejado: "yyyy-MM-dd"
        String dataString = "2023-11-15";
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        Date venData = formatador.parse(dataString);

        // Definindo a data formatada no objeto ModelVendas
        venda.setVenData(venData);

        // Configurando o comportamento simulado para o método salvarVendasDAO
        DAOVendas daoMock = mock(DAOVendas.class);
        Mockito.when(daoMock.salvarVendasDAO(venda)).thenReturn(1); // Simulando a inserção bem-sucedida no banco de dados

        // Criando uma instância do ControllerVendas com o mock do DAOVendas
        ControllerVendas controller = new ControllerVendas();
        controller.daoVendas = daoMock;

        // Invocando o método salvarVendasController() do ControllerVendas
        int resultadoSalvar = controller.salvarVendasController(venda);

        // Verificando se o resultado da inserção é igual a 1 (indicando sucesso)
        assertEquals(1, resultadoSalvar);
        
        // Verificando se o método salvarVendasDAO do mock foi chamado com o objeto ModelVendas correto
        verify(daoMock).salvarVendasDAO(venda);
    }
    
      @Test
    public void testGetVendasController() {
        // Crio um id de venda simulado para o teste
        int idVenda = 1;

        // Crio um objeto ModelVendas simulado para retorno do DAO
        ModelVendas vendaSimulada = new ModelVendas();
        vendaSimulada.setIdVenda(1); // Defino um ID de venda simulado
        vendaSimulada.setCliente(1); // Defino um cliente simulado
        vendaSimulada.setVenValorLiquido(100.0); // Valor líquido simulado da venda
        vendaSimulada.setVenValorBruto(120.0); // Valor bruto simulado da venda
        vendaSimulada.setVenDesconto(20.0); // Simulando o desconto aplicado na venda

        // Configuro o comportamento simulado para o método getVendasDAO
        DAOVendas daoMock = mock(DAOVendas.class);
        Mockito.when(daoMock.getVendasDAO(idVenda)).thenReturn(vendaSimulada); // Simulo o retorno da venda pelo DAO

        // Crio uma instância do ControllerVendas com o mock do DAOVendas
        ControllerVendas controller = new ControllerVendas();
        controller.daoVendas = daoMock;

        // Invoco o método getVendasController() do ControllerVendas
        ModelVendas resultadoVenda = controller.getVendasController(idVenda);

        // Verifico se a venda retornada pelo controller é igual à venda simulada retornada pelo DAO
        assertEquals(vendaSimulada, resultadoVenda);
        
        // Verifico se o método getVendasDAO do mock foi chamado com o ID de venda correto
        verify(daoMock).getVendasDAO(idVenda);
    }
    
    @Test
    public void testGetListaVendasController() {
        // Crio uma lista simulada de ModelVendas para retorno do DAO
        ArrayList<ModelVendas> listaVendasSimuladas = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            ModelVendas vendaSimulada = new ModelVendas();
            vendaSimulada.setIdVenda(i); // Defino um ID de venda simulado
            vendaSimulada.setCliente(i); // Defino um cliente simulado
            vendaSimulada.setVenValorLiquido(100.0 * i); // Valor líquido simulado da venda
            vendaSimulada.setVenValorBruto(120.0 * i); // Valor bruto simulado da venda
            vendaSimulada.setVenDesconto(20.0 * i); // Simulando o desconto aplicado na venda
            listaVendasSimuladas.add(vendaSimulada);
        }

        // Configuro o comportamento simulado para o método getListaVendasDAO
        DAOVendas daoMock = mock(DAOVendas.class);
        Mockito.when(daoMock.getListaVendasDAO()).thenReturn(listaVendasSimuladas); // Simulo o retorno da lista de vendas pelo DAO

        // Crio uma instância do ControllerVendas com o mock do DAOVendas
        ControllerVendas controller = new ControllerVendas();
        controller.daoVendas = daoMock;

        // Invoco o método getListaVendasController() do ControllerVendas
        ArrayList<ModelVendas> resultadoListaVendas = controller.getListaVendasController();

        // Verifico se a lista de vendas retornada pelo controller é igual à lista simulada retornada pelo DAO
        assertEquals(listaVendasSimuladas.size(), resultadoListaVendas.size());
        assertEquals(listaVendasSimuladas, resultadoListaVendas);
        
        // Verifico se o método getListaVendasDAO do mock foi chamado
        verify(daoMock).getListaVendasDAO();
    }
    
   @Test
    public void testAtualizarVendasController() {
        // Criando um objeto ModelVendas simulado para atualização
        ModelVendas venda = new ModelVendas();
        venda.setIdVenda(1); // Simulando o ID da venda
        venda.setCliente(1); // Simulando o cliente

        // Configurando a data no formato correto
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormatada = null;
        try {
            dataFormatada = dateFormat.parse("2023-11-15");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        venda.setVenData(dataFormatada);

        venda.setVenValorLiquido(100.0); // Simulando o valor líquido da venda
        venda.setVenValorBruto(120.0); // Simulando o valor bruto da venda
        venda.setVenDesconto(20.0); // Simulando o desconto aplicado na venda

        // Configurando o comportamento simulado para o método atualizarVendasDAO
        DAOVendas daoMock = mock(DAOVendas.class);
        Mockito.when(daoMock.atualizarVendasDAO(venda)).thenReturn(true); // Simulando a atualização bem-sucedida no banco de dados

        // Criando uma instância do ControllerVendas com o mock do DAOVendas
        ControllerVendas controller = new ControllerVendas();
        controller.daoVendas = daoMock;

        // Invocando o método atualizarVendasController() do ControllerVendas
        boolean resultadoAtualizacao = controller.atualizarVendasController(venda);

        // Verificando se o resultado da atualização é verdadeiro (indicando sucesso)
        assertTrue(resultadoAtualizacao);

        // Verificando se o método atualizarVendasDAO do mock foi chamado com o objeto ModelVendas correto
        verify(daoMock).atualizarVendasDAO(venda);
    }
}

