package a.vendasy2.model;

public class ModelUsuario {

    private int idUsuario;
    private String usuNome;
    private String usuLogin;
    private String usuSenha;

    /**
     * Construtor padrão da classe ModelUsuario.
     */
    public ModelUsuario(){}

    /**
     * Define o valor do ID do usuário.
     * @param pIdUsuario O ID do usuário a ser definido.
     */
    public void setIdUsuario(int pIdUsuario){
        this.idUsuario = pIdUsuario;
    }
    
    /**
     * Obtém o ID do usuário.
     * @return O ID do usuário.
     */
    public int getIdUsuario(){
        return this.idUsuario;
    }

    /**
     * Define o nome do usuário.
     * @param pUsuNome O nome do usuário a ser definido.
     */
    public void setUsuNome(String pUsuNome){
        this.usuNome = pUsuNome;
    }
    
    /**
     * Obtém o nome do usuário.
     * @return O nome do usuário.
     */
    public String getUsuNome(){
        return this.usuNome;
    }

    /**
     * Define o login do usuário.
     * @param pUsuLogin O login do usuário a ser definido.
     */
    public void setUsuLogin(String pUsuLogin){
        this.usuLogin = pUsuLogin;
    }
    
    /**
     * Obtém o login do usuário.
     * @return O login do usuário.
     */
    public String getUsuLogin(){
        return this.usuLogin;
    }

    /**
     * Define a senha do usuário.
     * @param pUsuSenha A senha do usuário a ser definida.
     */
    public void setUsuSenha(String pUsuSenha){
        this.usuSenha = pUsuSenha;
    }
    
    /**
     * Obtém a senha do usuário.
     * @return A senha do usuário.
     */
    public String getUsuSenha(){
        return this.usuSenha;
    }

}
