package a.vendasy2.dao;

import a.vendasy2.model.ModelCliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe responsável por acessar e manipular dados relacionados aos clientes no banco de dados.
 */
public class DAOCliente extends ConexaoDAO {

    /**
     * Construtor padrão.
     * Este é o construtor padrão da classe DAOCliente.
     */
    public DAOCliente() {
        // Construtor padrão vazio
    }

    /**
     * Grava um cliente na base de dados.
     * 
     * @param pModelCliente O modelo de cliente a ser gravado
     * @return int O ID do cliente gravado
     */
    public int salvarClienteDAO(ModelCliente pModelCliente) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_cliente ("
                    + "cli_nome," + "cli_endereco," + "cli_bairro," + "cli_cidade," + "cli_uf," + "cli_cep,"
                    + "cli_telefone" + ") VALUES (" + "'" + pModelCliente.getCliNome() + "'," + "'"
                    + pModelCliente.getCliEndereco() + "'," + "'" + pModelCliente.getCliBairro() + "'," + "'"
                    + pModelCliente.getCliCidade() + "'," + "'" + pModelCliente.getCliUf() + "'," + "'"
                    + pModelCliente.getCliCep() + "'," + "'" + pModelCliente.getCliTelefone() + "'" + ");");
        } catch (Exception e) {
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Recupera um cliente pelo ID.
     * 
     * @param pIdCliente O ID do cliente a ser recuperado
     * @return ModelCliente O cliente recuperado pelo ID
     */
    public ModelCliente getClienteDAO(int pIdCliente) {
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL("SELECT " + "pk_id_cliente," + "cli_nome," + "cli_endereco," + "cli_bairro," + "cli_cidade,"
                    + "cli_uf," + "cli_cep," + "cli_telefone" + " FROM" + " tbl_cliente" + " WHERE"
                    + " pk_id_cliente = '" + pIdCliente + "'" + ";");

            while (this.getResultSet().next()) {
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliEndereco(this.getResultSet().getString(3));
                modelCliente.setCliBairro(this.getResultSet().getString(4));
                modelCliente.setCliCidade(this.getResultSet().getString(5));
                modelCliente.setCliUf(this.getResultSet().getString(6));
                modelCliente.setCliCep(this.getResultSet().getString(7));
                modelCliente.setCliTelefone(this.getResultSet().getString(8));
            }
        } catch (SQLException e) {
            // Tratamento de exceções
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }

    /**
     * Recupera um cliente pelo nome.
     * 
     * @param pNomeCliente O nome do cliente a ser recuperado
     * @return ModelCliente O cliente recuperado pelo nome
     */
    public ModelCliente getClienteDAO(String pNomeCliente) {
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL("SELECT " + "pk_id_cliente," + "cli_nome," + "cli_endereco," + "cli_bairro," + "cli_cidade,"
                    + "cli_uf," + "cli_cep," + "cli_telefone" + " FROM" + " tbl_cliente" + " WHERE"
                    + " cli_nome = '" + pNomeCliente + "'" + ";");

            while (this.getResultSet().next()) {
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliEndereco(this.getResultSet().getString(3));
                modelCliente.setCliBairro(this.getResultSet().getString(4));
                modelCliente.setCliCidade(this.getResultSet().getString(5));
                modelCliente.setCliUf(this.getResultSet().getString(6));
                modelCliente.setCliCep(this.getResultSet().getString(7));
                modelCliente.setCliTelefone(this.getResultSet().getString(8));
            }
        } catch (SQLException e) {
            // Tratamento de exceções
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }

    /**
     * Recupera uma lista de Cliente.
     * 
     * @return ArrayList ModelCliente Lista de todos os clientes
     */
    public ArrayList<ModelCliente> getListaClienteDAO() {
        ArrayList<ModelCliente> listamodelCliente = new ArrayList<>();
        ModelCliente modelCliente;
        try {
            this.conectar();
            this.executarSQL("SELECT " + "pk_id_cliente," + "cli_nome," + "cli_endereco," + "cli_bairro," + "cli_cidade,"
                    + "cli_uf," + "cli_cep," + "cli_telefone" + " FROM" + " tbl_cliente" + ";");

            while (this.getResultSet().next()) {
                modelCliente = new ModelCliente();
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setCliNome(this.getResultSet().getString(2));
                modelCliente.setCliEndereco(this.getResultSet().getString(3));
                modelCliente.setCliBairro(this.getResultSet().getString(4));
                modelCliente.setCliCidade(this.getResultSet().getString(5));
                modelCliente.setCliUf(this.getResultSet().getString(6));
                modelCliente.setCliCep(this.getResultSet().getString(7));
                modelCliente.setCliTelefone(this.getResultSet().getString(8));
                listamodelCliente.add(modelCliente);
            }
        } catch (SQLException e) {
            // Tratamento de exceções
        } finally {
            this.fecharConexao();
        }
        return listamodelCliente;
    }

    /**
     * Atualiza um cliente na base de dados.
     * 
     * @param pModelCliente O modelo de cliente a ser atualizado
     * @return boolean Retorna verdadeiro se a atualização for bem-sucedida, caso contrário, falso
     */
    public boolean atualizarClienteDAO(ModelCliente pModelCliente) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_cliente SET " + "pk_id_cliente = '"
                    + pModelCliente.getIdCliente() + "'," + "cli_nome = '" + pModelCliente.getCliNome() + "',"
                    + "cli_endereco = '" + pModelCliente.getCliEndereco() + "'," + "cli_bairro = '"
                    + pModelCliente.getCliBairro() + "'," + "cli_cidade = '" + pModelCliente.getCliCidade() + "',"
                    + "cli_uf = '" + pModelCliente.getCliUf() + "'," + "cli_cep = '" + pModelCliente.getCliCep() + "',"
                    + "cli_telefone = '" + pModelCliente.getCliTelefone() + "'" + " WHERE " + "pk_id_cliente = '"
                    + pModelCliente.getIdCliente() + "'" + ";");
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Exclui um cliente da base de dados.
     * 
     * @param pIdCliente O ID do cliente a ser excluído
     * @return boolean Retorna verdadeiro se a exclusão for bem-sucedida, caso contrário, falso
     */
    public boolean excluirClienteDAO(int pIdCliente) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_cliente " + " WHERE " + "pk_id_cliente = '" + pIdCliente + "'" + ";");
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
