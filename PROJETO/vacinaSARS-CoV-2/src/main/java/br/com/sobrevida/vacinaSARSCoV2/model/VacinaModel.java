package br.com.sobrevida.vacinaSARSCoV2.model;

/**
 *
 * @author WERIKE
 */
public class VacinaModel{

    private int id;
    private String desenvolvedora;
    private String produtora;
    private String parceira;
    private int qtd_Dose;
    private String periodo;
    private String descicao;
    
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
     * @return the desenvolvedora
     */
    public String getDesenvolvedora() {
        return desenvolvedora;
    }
    /**
     * @param desenvolvedora the desenvolvedora to set
     */
    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }
    /**
     * @return the produtora
     */
    public String getProdutora() {
        return produtora;
    }
    /**
     * @param produtora the produtora to set
     */
    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }
    /**
     * @return the parceira
     */
    public String getParceira() {
        return parceira;
    }
    /**
     * @param parceira the parceira to set
     */
    public void setParceira(String parceira) {
        this.parceira = parceira;
    }
    /**
     * @return the qtd_Dose
     */
    public int getQtd_Dose() {
        return qtd_Dose;
    }
    /**
     * @param qtd_Dose the qtd_Dose to set
     */
    public void setQtd_Dose(int qtd_Dose) {
        this.qtd_Dose = qtd_Dose;
    }
    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }
    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    /**
     * @return the descicao
     */
    public String getDescicao() {
        return descicao;
    }
    /**
     * @param descicao the descicao to set
     */
    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }
}
