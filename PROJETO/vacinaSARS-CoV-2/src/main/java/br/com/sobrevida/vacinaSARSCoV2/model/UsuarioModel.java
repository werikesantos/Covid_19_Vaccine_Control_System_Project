package br.com.sobrevida.vacinaSARSCoV2.model;

/**
 *
 * @author WERIKE
 */
public class UsuarioModel{
    
    private int id;
    private int idPerfil;
    private String nomeCompleto;
    private String apelido;
    private String cpfUsuario;
    private String email;
    private String senha;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @return the idPerfil
     */
    public int getIdPerfil() {
        return idPerfil;
    }
    /**
     * @param idPerfil the idPerfil to set
     */
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
    /**
     * @return the nome
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    /**
     * @param nomeCompleto the nome to set
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    /**
     * @return the apelido
     */
    public String getApelido() {
        return apelido;
    }
    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    /**
     * @return the cpf
     */
    public String getCpfUsuario() {
        return cpfUsuario;
    }
    /**
     * @param cpfUsuario the cpf to set
     */
    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }
    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }     
}
