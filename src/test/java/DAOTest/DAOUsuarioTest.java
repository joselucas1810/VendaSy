/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAOTest;

import a.vendasy2.dao.DAOUsuario;
import a.vendasy2.model.ModelUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author jose_
 */
public class DAOUsuarioTest {
    
  

@Test
public void testSalvarUsuarioDAO() {
    // Obtendo a lista de usuários existentes para identificar o último ID de usuário
    DAOUsuario daoUsuario = new DAOUsuario();
    ArrayList<ModelUsuario> listaUsuarios = daoUsuario.getListaUsuarioDAO();
    int ultimoID = 0;

    if (!listaUsuarios.isEmpty()) {
        // Encontrando o maior ID na lista de usuários
        for (ModelUsuario usuario : listaUsuarios) {
            if (usuario.getIdUsuario() > ultimoID) {
                ultimoID = usuario.getIdUsuario();
            }
        }
    }

    // Incrementando o último ID para obter o próximo ID esperado para o novo usuário
    int proximoID = ultimoID + 1;

    // Criando um usuário fictício para teste
    ModelUsuario usuarioTeste = new ModelUsuario();
    usuarioTeste.setUsuNome("Nome do Usuário");
    usuarioTeste.setUsuLogin("login_usuario");
    usuarioTeste.setUsuSenha("senha123");

    // Testando o salvamento do usuário
    int resultado = daoUsuario.salvarUsuarioDAO(usuarioTeste);

    // Verificando se o resultado foi satisfatório
    assertEquals(proximoID, resultado);
}
    
   @Test
    public void testGetUsuarioDAO() {
        // Criando um ID de usuário simulado para buscar no banco de dados
        int idUsuarioSimulado = 1;

        // Criando uma instância do DAOUsuario
        DAOUsuario instance = new DAOUsuario();

        // Chamando o método getUsuarioDAO para buscar um usuário
        ModelUsuario resultadoUsuario = instance.getUsuarioDAO(idUsuarioSimulado);

        // Verificando manualmente se o usuário retornado tem o ID esperado
        if (resultadoUsuario != null && resultadoUsuario.getIdUsuario() == idUsuarioSimulado) {
            System.out.println("Teste passou: Usuário encontrado!");
            System.out.println("ID: " + resultadoUsuario.getIdUsuario());
            System.out.println("Nome: " + resultadoUsuario.getUsuNome());
            System.out.println("Login: " + resultadoUsuario.getUsuLogin());
            System.out.println("Senha: " + resultadoUsuario.getUsuSenha());
        } else {
            System.out.println("Teste falhou: Usuário não encontrado ou IDs não correspondem.");
        }
    }

  @Test
    public void testGetListaUsuarioDAO() {
        // Instancio a classe DAO de Usuário
        DAOUsuario daoUsuario = new DAOUsuario();

        // Obtendo a lista de usuários do DAO
        ArrayList<ModelUsuario> listaRetornada = daoUsuario.getListaUsuarioDAO();

        // Verificando se a lista retornada não é nula
        if (listaRetornada == null) {
            System.out.println("A lista de usuários é nula");
        } else {
            System.out.println("Lista de usuários:");
            for (ModelUsuario usuario : listaRetornada) {
                System.out.println("ID: " + usuario.getIdUsuario() +
                        ", Nome: " + usuario.getUsuNome() +
                        ", Login: " + usuario.getUsuLogin() +
                        ", Senha: " + usuario.getUsuSenha());
            }
        }
    }
    
 @Test
public void testAtualizarUsuarioDAO() {
    
    // Obtendo a lista de usuários existentes para identificar o último ID de usuário
    DAOUsuario daoUsuario = new DAOUsuario();
    
    // Criando um novo usuário para teste
    ModelUsuario usuario = new ModelUsuario();
    usuario.setUsuNome("Nome do Usuário");
    usuario.setUsuLogin("login_usuario");
    usuario.setUsuSenha("senha123");

    // Salvando o usuário criado para realizar a atualização
    int idUsuarioCriado = daoUsuario.salvarUsuarioDAO(usuario);

    // Verificando se o usuário foi criado corretamente
    assertTrue(idUsuarioCriado > 0);

    // Modificando os dados do usuário criado
    usuario.setIdUsuario(idUsuarioCriado);
    usuario.setUsuNome("Novo Nome do Usuário");
    usuario.setUsuLogin("novo_login_usuario");
    usuario.setUsuSenha("nova_senha123");

    // Atualizando o usuário no banco de dados
    boolean atualizacao = daoUsuario.atualizarUsuarioDAO(usuario);

    // Verificando se a atualização foi bem-sucedida
    assertTrue(atualizacao);
}
    
   
    

    @Test
    public void testExcluirUsuarioDAO() {
        
         DAOUsuario usuarioDAO = new DAOUsuario();
    // Defina um ID de usuário existente para exclusão nos testes
    int idUsuarioParaExcluir = 32; // Substitua pelo ID existente no seu banco de dados
        
        // Tenta excluir o usuário e verifica se a exclusão foi bem-sucedida
        boolean exclusaoBemSucedida = usuarioDAO.excluirUsuarioDAO(idUsuarioParaExcluir);
        
        // Verifica se a exclusão foi realizada com sucesso
        assertTrue("A exclusão do usuário falhou", exclusaoBemSucedida);
    }
    
    
    
   @Test
    public void testGetValidarUsuarioDAO() {
        // Cria uma instância da classe DAOUsuario
        DAOUsuario daoUsuario = new DAOUsuario();

        // Cria um usuário simulado com um login e senha válidos
        ModelUsuario usuarioValido = new ModelUsuario();
        usuarioValido.setUsuLogin("jose.gouveia.est@samarco.com");
        usuarioValido.setUsuSenha("181094");

        // Chama o método getValidarUsuarioDAO para validar o usuário
        boolean resultadoValidacao = daoUsuario.getValidarUsuarioDAO(usuarioValido);

        // Verifica se o login do usuário é válido (esperamos que seja verdadeiro)
        assertTrue(resultadoValidacao);

        // Cria um usuário simulado com um login e senha inválidos
        ModelUsuario usuarioInvalido = new ModelUsuario();
        usuarioInvalido.setUsuLogin("login_invalido");
        usuarioInvalido.setUsuSenha("senha_invalida");

        // Chama o método getValidarUsuarioDAO para validar o usuário
        resultadoValidacao = daoUsuario.getValidarUsuarioDAO(usuarioInvalido);

        // Verifica se o login do usuário é inválido (esperamos que seja falso)
        assertFalse(resultadoValidacao);
    }
}