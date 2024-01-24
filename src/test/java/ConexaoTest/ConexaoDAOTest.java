/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexaoTest;

/**
 *
 * @author jose_
 */

import a.vendasy2.dao.ConexaoDAO;
import static org.junit.Assert.*;
import org.junit.*;

public class ConexaoDAOTest {

    private ConexaoDAO conexao;

    @Before
    public void setUp() {
        // Configuração inicial para os testes
        conexao = new ConexaoDAO("localhost", "test_db", "root", "");
        conexao.conectar(); // Estabelece a conexão antes de cada teste
    }

    @After
    public void tearDown() {
        conexao.fecharConexao(); // Fecha a conexão após cada teste
    }

    @Test
    public void testConectar() {
        assertTrue(conexao.isStatus()); // Verifica se a conexão foi estabelecida com sucesso
    }

    @Test
    public void testExecutarSQL() {
        assertTrue(conexao.executarSQL("SELECT * FROM tabela")); // Testa a execução de uma consulta SQL
    }

    @Test
    public void testExecutarUpdateDeleteSQL() {
        assertTrue(conexao.executarUpdateDeleteSQL("DELETE FROM tabela WHERE id = 1")); // Testa a execução de um comando de atualização/deleção
    }

    @Test
    public void testInsertSQL() {
        int idInserido = conexao.insertSQL("INSERT INTO tabela (campo) VALUES ('valor')");
        assertTrue(idInserido > 0); // Verifica se um novo registro foi inserido e retorna o ID
    }

    @Test
    public void testFecharConexao() {
        assertTrue(conexao.fecharConexao()); // Testa se a conexão é fechada com sucesso
    }
}
