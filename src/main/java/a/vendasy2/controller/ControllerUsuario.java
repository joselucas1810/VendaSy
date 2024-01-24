package a.vendasy2.controller;

import a.vendasy2.model.ModelUsuario;
import java.util.ArrayList;
import a.vendasy2.dao.DAOUsuario;

/**
 * Controlador dos usuários.
 * Esta classe controla as operações relacionadas aos usuários, como salvar, recuperar, atualizar e excluir informações sobre os usuários.
 */
public class ControllerUsuario {

    /**
     * Instância da classe DAOUsuario para realizar operações no banco de dados relacionadas aos usuários.
     */
    public DAOUsuario daoUsuario = new DAOUsuario();

    /**
     * Construtor padrão.
     * Este é o construtor padrão da classe ControllerUsuario.
     */
    public ControllerUsuario(){}

    /**
     * Salva um usuário.
     *
     * @param pModelUsuario O modelo do usuário a ser salvo
     * @return int O ID do usuário salvo
     */
    public int salvarUsuarioController(ModelUsuario pModelUsuario){
        return this.daoUsuario.salvarUsuarioDAO(pModelUsuario);
    }

    /**
     * Recupera um usuário pelo ID.
     *
     * @param pIdUsuario O ID do usuário a ser recuperado
     * @return ModelUsuario O usuário recuperado pelo ID
     */
    public ModelUsuario getUsuarioController(int pIdUsuario){
        return this.daoUsuario.getUsuarioDAO(pIdUsuario);
    }

    /**
     * Recupera uma lista de usuários.
     *
     * @return ArrayList ModelUsuario Lista de todos os usuários
     */
    public ArrayList<ModelUsuario> getListaUsuarioController(){
        return this.daoUsuario.getListaUsuarioDAO();
    }

    /**
     * Atualiza um usuário.
     *
     * @param pModelUsuario O modelo do usuário a ser atualizado
     * @return boolean Retorna verdadeiro se a atualização for bem-sucedida, caso contrário, falso
     */
    public boolean atualizarUsuarioController(ModelUsuario pModelUsuario){
        return this.daoUsuario.atualizarUsuarioDAO(pModelUsuario);
    }

    /**
     * Exclui um usuário pelo ID.
     *
     * @param pIdUsuario O ID do usuário a ser excluído
     * @return boolean Retorna verdadeiro se a exclusão for bem-sucedida, caso contrário, falso
     */
    public boolean excluirUsuarioController(int pIdUsuario){
        return this.daoUsuario.excluirUsuarioDAO(pIdUsuario);
    }

    /**
     * Valida o login e senha do usuário.
     *
     * @param pModelUsuario O modelo do usuário para validação
     * @return boolean Retorna verdadeiro se a validação for bem-sucedida, caso contrário, falso
     */
    public boolean getValidarUsuarioController(ModelUsuario pModelUsuario) {
        return this.daoUsuario.getValidarUsuarioDAO(pModelUsuario);
    }
}
