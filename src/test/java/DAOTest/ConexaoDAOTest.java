/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOTest;

import a.vendasy2.dao.ConexaoDAO;
import java.sql.Connection;
import java.sql.Statement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author jose_
 */
public class ConexaoDAOTest {
    
     @Test
    public void testGetNomeDoBanco() {
        ConexaoDAO conexao = new ConexaoDAO();

        // Simular o estabelecimento da conexão (chamada a um método de conexão, etc.)
        conexao.conectar(); //estabelece a conexão

        // Verifica se o nome do banco de dados é o esperado
        String nomeEsperado = "dbvendasy"; 
        String nomeDoBanco = conexao.getNomeDoBanco();

        assertEquals(nomeEsperado, nomeDoBanco);
    }
    
     @Test
    public void testGetServidor() {
        ConexaoDAO conexao = new ConexaoDAO();
        String servidorEsperado = "localhost"; //servidor esperado

        // Supondo que exista um método para configurar o servidor na classe de conexão
        conexao.setServidor(servidorEsperado);

        assertEquals(servidorEsperado, conexao.getServidor());
    }
    
    @Test
    public void testGetUsuario() {
        ConexaoDAO conexao = new ConexaoDAO();
        String usuarioEsperado = "root"; //usuário esperado

        // Supondo que exista um método para configurar o usuário na classe de conexão
        conexao.setUsuario(usuarioEsperado);

        assertEquals(usuarioEsperado, conexao.getUsuario());
    }
    
     @Test
    public void testGetSenha() {
        ConexaoDAO conexao = new ConexaoDAO();
        String senhaEsperada = ""; //senha esperada

        // Supondo que exista um método para configurar a senha na classe de conexão
        conexao.setSenha(senhaEsperada);

        assertEquals(senhaEsperada, conexao.getSenha());
    }
    
     @Test
    public void testConexaoDAO() {
        String servidorEsperado = "localhost";
        String nomeDoBancoEsperado = "dbvendasy";
        String usuarioEsperado = "root";
        String senhaEsperada = "";

        ConexaoDAO conexao = new ConexaoDAO(servidorEsperado, nomeDoBancoEsperado, usuarioEsperado, senhaEsperada);

        // Verifica se os valores foram atribuídos corretamente aos campos da classe
        assertEquals(servidorEsperado, conexao.getServidor());
        assertEquals(nomeDoBancoEsperado, conexao.getNomeDoBanco());
        assertEquals(usuarioEsperado, conexao.getUsuario());
        assertEquals(senhaEsperada, conexao.getSenha());
    }
    
    @Test
    public void testGetMensagem() {
        ConexaoDAO objeto = new ConexaoDAO();
        String mensagemEsperada = "Mensagem de teste"; // Substitua pela mensagem esperada

        // Supondo que exista um método para configurar a mensagem na classe
        objeto.setMensagem(mensagemEsperada);

        assertEquals(mensagemEsperada, objeto.getMensagem());
    }
    
   
}
