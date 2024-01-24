package ControllerTest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jose_
 */
import a.vendasy2.controller.ControllerUsuario;
import a.vendasy2.model.ModelUsuario;
import a.vendasy2.dao.DAOUsuario;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerUsuarioTest {

    private ControllerUsuario controllerUsuario;
    private DAOUsuario daoUsuario;

    @BeforeEach
    public void setUp() {
        // Crie uma instância do ControllerUsuario
        controllerUsuario = new ControllerUsuario();

        // Crie um mock para o DAOUsuario
        daoUsuario = Mockito.mock(DAOUsuario.class);
        controllerUsuario.daoUsuario = daoUsuario;
    }

@Test
    public void testSalvarUsuarioController() {
        ModelUsuario usuario = new ModelUsuario();
        usuario.setUsuNome("Usu teste");
        usuario.setUsuLogin("login teste");
        usuario.setUsuSenha("123456789");

        // Simule o retorno do DAOUsuario
        Mockito.when(daoUsuario.salvarUsuarioDAO(usuario)).thenReturn(1); // Retorne o valor desejado (por exemplo, 1) aqui

        int resultado = controllerUsuario.salvarUsuarioController(usuario);

        // Verifique se o resultado é maior que 0 para indicar que o usuário foi salvo com sucesso
        assertTrue(resultado > 0);
    }

   @Test
    public void testAtualizarUsuarioController() {
        ModelUsuario usuario = new ModelUsuario();
        usuario.setIdUsuario(1);
        usuario.setUsuNome("Usu teste");
        usuario.setUsuLogin("login teste");
        usuario.setUsuSenha("987654321");

        // Simule o retorno do DAOUsuario
        Mockito.when(daoUsuario.atualizarUsuarioDAO(usuario)).thenReturn(true); // Retorne o valor desejado (true) aqui

        boolean resultado = controllerUsuario.atualizarUsuarioController(usuario);

        // Verifique se o resultado é verdadeiro para indicar que o usuário foi atualizado com sucesso
        assertTrue(resultado);
    }
    
    @Test
    public void testGetUsuarioController() {
        int idUsuario = 1;
        ModelUsuario expectedUsuario = new ModelUsuario();
        expectedUsuario.setIdUsuario(1);
        expectedUsuario.setUsuNome("Nome do Usuário");
        expectedUsuario.setUsuLogin("Login");
        expectedUsuario.setUsuSenha("Senha");

        Mockito.when(daoUsuario.getUsuarioDAO(idUsuario)).thenReturn(expectedUsuario);

        ModelUsuario resultUsuario = controllerUsuario.getUsuarioController(idUsuario);

        assertEquals(expectedUsuario.getIdUsuario(), resultUsuario.getIdUsuario());
        assertEquals(expectedUsuario.getUsuNome(), resultUsuario.getUsuNome());
        assertEquals(expectedUsuario.getUsuLogin(), resultUsuario.getUsuLogin());
        assertEquals(expectedUsuario.getUsuSenha(), resultUsuario.getUsuSenha());
    }
    @Test
    public void testGetListaUsuarioController() {
        // Crio uma lista de ModelUsuario esperada para simular o retorno do DAO
        ArrayList<ModelUsuario> expectedListaUsuario = new ArrayList<>();
        
        // Crio alguns objetos ModelUsuario para adicionar à lista esperada
        ModelUsuario usuario1 = new ModelUsuario();
        usuario1.setIdUsuario(1);
        usuario1.setUsuNome("Nome 1");
        usuario1.setUsuLogin("Login 1");
        usuario1.setUsuSenha("Senha 1");

        ModelUsuario usuario2 = new ModelUsuario();
        usuario2.setIdUsuario(2);
        usuario2.setUsuNome("Nome 2");
        usuario2.setUsuLogin("Login 2");
        usuario2.setUsuSenha("Senha 2");

        // Adiciono os objetos ModelUsuario à lista esperada
        expectedListaUsuario.add(usuario1);
        expectedListaUsuario.add(usuario2);

        // Configuro o comportamento do mock para retornar a lista esperada quando o método getListaUsuarioDAO() for chamado
        Mockito.when(daoUsuario.getListaUsuarioDAO()).thenReturn(expectedListaUsuario);

        // Invoco o método getListaUsuarioController() do MeuController
        ArrayList<ModelUsuario> resultListaUsuario = controllerUsuario.getListaUsuarioController();

        // Comparo o tamanho da lista esperada com a lista retornada para verificar se têm o mesmo tamanho
        assertEquals(expectedListaUsuario.size(), resultListaUsuario.size());

        // Faço a comparação de cada usuário individualmente para garantir que os dados estejam corretos
        for (int i = 0; i < expectedListaUsuario.size(); i++) {
            ModelUsuario expectedUsuario = expectedListaUsuario.get(i);
            ModelUsuario resultUsuario = resultListaUsuario.get(i);

            // Comparo os campos do objeto ModelUsuario individualmente para garantir que os dados correspondam
            assertEquals(expectedUsuario.getIdUsuario(), resultUsuario.getIdUsuario());
            assertEquals(expectedUsuario.getUsuNome(), resultUsuario.getUsuNome());
            assertEquals(expectedUsuario.getUsuLogin(), resultUsuario.getUsuLogin());
            assertEquals(expectedUsuario.getUsuSenha(), resultUsuario.getUsuSenha());
        }
    }
    @Test
    public void testExcluirUsuarioController() {
        int idUsuario = 1; // Defino um ID de usuário para o teste

        // Configuro o comportamento do mock para simular a exclusão bem-sucedida
        Mockito.when(daoUsuario.excluirUsuarioDAO(idUsuario)).thenReturn(true);

        // Invoco o método excluirUsuarioController() do MeuController
        boolean resultadoExclusao = controllerUsuario.excluirUsuarioController(idUsuario);

        // Verifico se a exclusão foi bem-sucedida (esperado true)
        assertTrue(resultadoExclusao);

        // Configuro o comportamento do mock para simular uma falha na exclusão
        Mockito.when(daoUsuario.excluirUsuarioDAO(idUsuario)).thenReturn(false);

        // Invoco o método excluirUsuarioController() novamente
        resultadoExclusao = controllerUsuario.excluirUsuarioController(idUsuario);

        // Verifico se a exclusão falhou (esperado false)
        assertFalse(resultadoExclusao);
    }
    @Test
    public void testGetValidarUsuarioController() {
        // Crio um objeto ModelUsuario para simular os dados de login
        ModelUsuario usuario = new ModelUsuario();
        usuario.setUsuLogin("login");
        usuario.setUsuSenha("senha");

        // Configuro o comportamento do mock para simular a validação de usuário bem-sucedida
        Mockito.when(daoUsuario.getValidarUsuarioDAO(usuario)).thenReturn(true);

        // Invoco o método getValidarUsuarioController() do MeuController
        boolean resultadoValidacao = controllerUsuario.getValidarUsuarioController(usuario);

        // Verifico se a validação foi bem-sucedida (esperado true)
        assertTrue(resultadoValidacao);

        // Configuro o comportamento do mock para simular a validação de usuário falha
        Mockito.when(daoUsuario.getValidarUsuarioDAO(usuario)).thenReturn(false);

        // Invoco o método getValidarUsuarioController() novamente
        resultadoValidacao = controllerUsuario.getValidarUsuarioController(usuario);

        // Verifico se a validação falhou (esperado false)
        assertFalse(resultadoValidacao);
    }
}




