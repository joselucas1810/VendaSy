package a.vendasy2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Classe para gerenciar a conexão com o banco de dados.
 */
public class ConexaoDAO {

    private boolean status = false;
    private String mensagem = "";
    private Connection con = null;
    private Statement statement;
    private ResultSet resultSet;

    private String servidor = "localhost";
    private String nomeDoBanco = "dbvendasy";
    private String usuario = "root";
    private String senha = "";

    /**
     * Construtor padrão da classe ConexaoDAO.
     */
    public ConexaoDAO() {}

    /**
     * Construtor que recebe parâmetros para a conexão com o banco de dados.
     * 
     * @param pServidor  Nome do servidor.
     * @param pNomeDoBanco  Nome do banco de dados.
     * @param pUsuario  Nome do usuário do banco de dados.
     * @param pSenha  Senha do usuário do banco de dados.
     */
    public ConexaoDAO(String pServidor, String pNomeDoBanco, String pUsuario, String pSenha){
        this.servidor = pServidor;
        this.nomeDoBanco = pNomeDoBanco;
        this.usuario = pUsuario;
        this.senha = pSenha;
    }

    /**
     * Método para estabelecer a conexão com o banco de dados.
     * 
     * @return Connection
     */
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + servidor + "/" + nomeDoBanco;
            this.setCon((Connection) DriverManager.getConnection(url, usuario, senha));
            this.status = true;
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this.getCon();
    }

    /**
     * Executa consultas SQL.
     * 
     * @param pSQL  Consulta SQL a ser executada.
     * @return boolean
     */
    public boolean executarSQL(String pSQL){
        try {
            this.setStatement(getCon().createStatement());
            this.setResultSet(getStatement().executeQuery(pSQL));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Executa operações de atualização ou exclusão no banco de dados.
     * 
     * @param pSQL  Consulta SQL a ser executada.
     * @return boolean
     */
    public boolean executarUpdateDeleteSQL(String pSQL){
        try {
            this.setStatement(getCon().createStatement());
            getStatement().executeUpdate(pSQL);
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    /**
     * Executa uma consulta SQL para inserção de dados.
     * 
     * @param pSQL  Consulta SQL de inserção.
     * @return int
     */
    public int insertSQL(String pSQL){
        int status = 0;
        try {
            this.setStatement(getCon().createStatement());
            this.getStatement().executeUpdate(pSQL);
            this.setResultSet(this.getStatement().executeQuery("SELECT last_insert_id();"));
            
            while(this.resultSet.next()){
                status = this.resultSet.getInt(1);
            }
            
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return status;
        }
    }

    /**
     * Fecha a conexão com o banco de dados.
     * 
     * @return boolean
     */
    public boolean fecharConexao(){
       try {
           if((this.getResultSet() != null) && (this.statement != null)){
               this.getResultSet().close();
               this.statement.close();
           }
           this.getCon().close();
           return true;
       } catch(SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       return false;
    }


    // Métodos getters e setters para os atributos da classe

  /**
 * Retorna o status da conexão.
 * 
 * @return o status da conexão
 */
public boolean isStatus() {
    return this.status;
}

/**
 * Retorna a mensagem da conexão.
 * 
 * @return a mensagem da conexão
 */
public String getMensagem() {
    return mensagem;
}

/**
 * Retorna o Statement.
 * 
 * @return o Statement
 */
public Statement getStatement() {
    return statement;
}

/**
 * Retorna o ResultSet.
 * 
 * @return o ResultSet
 */
public ResultSet getResultSet() {
    return resultSet;
}

/**
 * Define a mensagem da conexão.
 * 
 * @param mensagem a mensagem da conexão a ser definida
 */
public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
}

/**
 * Retorna a conexão.
 * 
 * @return a conexão
 */
public Connection getCon() {
    return con;
}

/**
 * Define a conexão.
 * 
 * @param con a conexão a ser definida
 */
public void setCon(Connection con) {
    this.con = con;
}

/**
 * Define o Statement.
 * 
 * @param statement o Statement a ser definido
 */
public void setStatement(Statement statement) {
    this.statement = statement;
}

/**
 * Define o ResultSet.
 * 
 * @param resultSet o ResultSet a ser definido
 */
public void setResultSet(ResultSet resultSet) {
    this.resultSet = resultSet;
}

/**
 * Retorna o nome do servidor.
 * 
 * @return o nome do servidor
 */
public String getServidor() {
    return servidor;
}

/**
 * Define o nome do servidor.
 * 
 * @param servidor o nome do servidor a ser definido
 */
public void setServidor(String servidor) {
    this.servidor = servidor;
}

/**
 * Retorna o nome do banco de dados.
 * 
 * @return o nome do banco de dados
 */
public String getNomeDoBanco() {
    return nomeDoBanco;
}

/**
 * Define o nome do banco de dados.
 * 
 * @param nomeDoBanco o nome do banco de dados a ser definido
 */
public void setNomeDoBanco(String nomeDoBanco) {
    this.nomeDoBanco = nomeDoBanco;
}

/**
 * Retorna o nome do usuário.
 * 
 * @return o nome do usuário
 */
public String getUsuario() {
    return usuario;
}

/**
 * Define o nome do usuário.
 * 
 * @param usuario o nome do usuário a ser definido
 */
public void setUsuario(String usuario) {
    this.usuario = usuario;
}

/**
 * Retorna a senha do usuário.
 * 
 * @return a senha do usuário
 */
public String getSenha() {
    return senha;
}

/**
 * Define a senha do usuário.
 * 
 * @param senha a senha do usuário a ser definida
 */
public void setSenha(String senha) {
    this.senha = senha;
}
}
