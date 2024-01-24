package a.vendasy2.dao;

import a.vendasy2.model.ModelUsuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe responsável por acessar e manipular dados de usuários no banco de dados.
 */
public class DAOUsuario extends ConexaoDAO {

    /**
     * Construtor padrão.
     * Este é o construtor padrão da classe DAOUsuario.
     */
    public DAOUsuario() {}

    /**
     * Grava um novo usuário no banco de dados.
     *
     * @param pModelUsuario O usuário a ser salvo
     * @return int Retorna o ID do usuário gravado
     */
    public int salvarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_usuario ("
                    + "usu_nome,"
                    + "usu_login,"
                    + "usu_senha"
                    + ") VALUES ("
                    + "'" + pModelUsuario.getUsuNome() + "',"
                    + "'" + pModelUsuario.getUsuLogin() + "',"
                    + "'" + pModelUsuario.getUsuSenha() + "'"
                    + ");"
            );
        } catch (Exception e) {
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Recupera um usuário pelo ID.
     *
     * @param pIdUsuario O ID do usuário a ser recuperado
     * @return ModelUsuario
     */
    public ModelUsuario getUsuarioDAO(int pIdUsuario) {
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_usuario,"
                    + "usu_nome,"
                    + "usu_login,"
                    + "usu_senha"
                    + " FROM"
                    + " tbl_usuario"
                    + " WHERE"
                    + " pk_id_usuario = '" + pIdUsuario + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuario.setUsuNome(this.getResultSet().getString(2));
                modelUsuario.setUsuLogin(this.getResultSet().getString(3));
                modelUsuario.setUsuSenha(this.getResultSet().getString(4));
            }
        } catch (SQLException e) {
        } finally {
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /**
     * Recupera uma lista de todos os usuários.
     *
     * @return ArrayList ModelUsuario
     */
    public ArrayList<ModelUsuario> getListaUsuarioDAO() {
        ArrayList<ModelUsuario> listamodelUsuario = new ArrayList();
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_usuario,"
                    + "usu_nome,"
                    + "usu_login,"
                    + "usu_senha"
                    + " FROM"
                    + " tbl_usuario"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuario.setUsuNome(this.getResultSet().getString(2));
                modelUsuario.setUsuLogin(this.getResultSet().getString(3));
                modelUsuario.setUsuSenha(this.getResultSet().getString(4));
                listamodelUsuario.add(modelUsuario);
            }
        } catch (SQLException e) {
        } finally {
            this.fecharConexao();
        }
        return listamodelUsuario;
    }

    /**
     * Atualiza informações de um usuário existente.
     *
     * @param pModelUsuario O usuário com as informações atualizadas
     * @return boolean
     */
    public boolean atualizarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_usuario SET "
                    + "pk_id_usuario = '" + pModelUsuario.getIdUsuario() + "',"
                    + "usu_nome = '" + pModelUsuario.getUsuNome() + "',"
                    + "usu_login = '" + pModelUsuario.getUsuLogin() + "',"
                    + "usu_senha = '" + pModelUsuario.getUsuSenha() + "'"
                    + " WHERE "
                    + "pk_id_usuario = '" + pModelUsuario.getIdUsuario() + "'"
                    + ";"
            );
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Exclui um usuário do banco de dados.
     *
     * @param pIdUsuario O ID do usuário a ser excluído
     * @return boolean
     */
    public boolean excluirUsuarioDAO(int pIdUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_usuario "
                    + " WHERE "
                    + "pk_id_usuario = '" + pIdUsuario + "'"
                    + ";"
            );
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Valida as credenciais de login do usuário.
     *
     * @param pModelUsuario O usuário com login e senha a serem validados
     * @return boolean
     */
    public boolean getValidarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_id_usuario,"
                    + "usu_nome,"
                    + "usu_login,"
                    + "usu_senha"
                    + " FROM"
                    + " tbl_usuario"
                    + " WHERE"
                    + " usu_login = '" + pModelUsuario.getUsuLogin() + "'AND usu_senha ='" + pModelUsuario.getUsuSenha() + "'"
                    + ";"
            );
            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
