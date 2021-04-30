package br.com.sobrevida.vacinaSARSCoV2.model;

/**
 *
 * @author WERIKE
 */
public class CidadaoModel {

    private int id;
    private String nome;
    private String nascimento;
    private String celular;
    private String cpf;
    private String endereco;
    private String numero;
    private String email;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * @return the nascimento
     */
    public String getNascimento() {
        return nascimento;
    }
    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }
    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }
    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }
    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }
    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
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
}