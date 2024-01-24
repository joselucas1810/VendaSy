/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TesteCucumber;

import a.vendasy2.dao.DAOCliente;
import a.vendasy2.dao.DAOUsuario;
import a.vendasy2.model.ModelCliente;
import a.vendasy2.model.ModelUsuario;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class VendaSYSteps {
    private ModelCliente cliente;
    private int resultadoOperacao;
    private ModelUsuario usuario;
    private boolean resultadoValidacao;

 @Dado("que eu tenha um cliente com os seguintes dados:")
    public void que_eu_tenha_um_cliente_com_os_seguintes_dados(
            String nome, String endereco, String bairro, String cidade, String uf, String cep, String telefone) {
        cliente = new ModelCliente();
        cliente.setCliNome(nome);
        cliente.setCliEndereco(endereco);
        cliente.setCliBairro(bairro);
        cliente.setCliCidade(cidade);
        cliente.setCliUf(uf);
        cliente.setCliCep(cep);
        cliente.setCliTelefone(telefone);
    }

    @Quando("eu gravar o cliente no banco de dados")
    public void eu_gravar_o_cliente_no_banco_de_dados() {
        DAOCliente dao = new DAOCliente(); // Instancie seu DAO aqui
        resultadoOperacao = dao.salvarClienteDAO(cliente);
    }

    @Então("a operação de gravação deve ser bem-sucedida")
    public void a_operacao_de_gravacao_deve_ser_bem_sucedida() {
        assertTrue(resultadoOperacao > 0); // Verifica se a operação de gravação foi bem-sucedida
    }
    
   
    
    //teste validar usuário
   @Dado("que tenho um usuário com login {string} e senha {string}")
    public void que_tenho_um_usuario_com_login_e_senha(String login, String senha) {
        usuario = new ModelUsuario();
        usuario.setUsuLogin(login);
        usuario.setUsuSenha(senha);
        // Você pode configurar outros atributos do usuário conforme necessário
    }

    @Quando("eu validar o login")
    public void eu_validar_o_login() {
        DAOUsuario dao = new DAOUsuario(); // Instancie seu DAO aqui
        resultadoValidacao = dao.getValidarUsuarioDAO(usuario);
    }

    @Então("o login deve ser validado com sucesso e exibir uma mensagem de sucesso")
    public void o_login_deve_ser_validado_com_sucesso_e_exibir_mensagem_sucesso() {
        assertTrue(resultadoValidacao); // Verifica se o login foi validado com sucesso
        String mensagem = "O login foi validado com sucesso!";
        System.out.println(mensagem);
    }

    @Então("o login não deve ser validado e exibir uma mensagem de falha")
    public void o_login_nao_deve_ser_validado_e_exibir_mensagem_falha() {
        assertFalse(resultadoValidacao); // Verifica se o login não foi validado
        String mensagem = "O login não foi validado.";
        System.out.println(mensagem);
    }
    
     @Dado("que eu tenha um usuário com nome {string}, login {string} e senha {string}")
    public void que_eu_tenha_um_usuario_com_nome_login_e_senha(String nome, String login, String senha) {
        usuario = new ModelUsuario();
        usuario.setUsuNome(nome);
        usuario.setUsuLogin(login);
        usuario.setUsuSenha(senha);
    }

    @Quando("eu gravar o usuário no banco de dados")
    public void eu_gravar_o_usuario_no_banco_de_dados() {
        DAOUsuario dao = new DAOUsuario(); // Instancie seu DAO aqui
        resultadoOperacao = dao.salvarUsuarioDAO(usuario);
    }

    @Então("a operação de gravação deve ser bem-sucedida")
    public void a_operacao_de_gravacao_deve_ser_bemsucedida() {
        assertTrue(resultadoOperacao > 0); // Verifica se a operação de gravação foi bem-sucedida
    }
    
}