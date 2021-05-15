package br.com.sobrevida.vacinaSARSCoV2.model;

/**
 *
 * @author WERIKE
 */
public class AplicacaoModel{
    
    private int id;
    private int idCidadao;
    private int idVacina ;
    private int dose;
    private String unica;
    private String primeira;
    private String segunda;
    
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
     * @return the idCidadao
     */
    public int getIdCidadao() {
        return idCidadao;
    }
    /**
     * @param idCidadao the idCidadao to set
     */
    public void setIdCidadao(int idCidadao) {
        this.idCidadao = idCidadao;
    }
    /**
     * @return the idVacina
     */
    public int getIdVacina() {
        return idVacina;
    }
    /**
     * @param idVacina the idVacina to set
     */
    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
    }
    /**
     * @return the dose
     */
    public int getDose() {
        return dose;
    }
    /**
     * @param dose the dose to set
     */
    public void setDose(int dose) {
        this.dose = dose;
    }
    /**
     * @return the unica
     */
    public String getUnica() {
        return unica;
    }
    /**
     * @param unica the unica to set
     */
    public void setUnica(String unica) {
        this.unica = unica;
    }
    /**
     * @return the primeira
     */
    public String getPrimeira() {
        return primeira;
    }
    /**
     * @param primeira the primeira to set
     */
    public void setPrimeira(String primeira) {
        this.primeira = primeira;
    }
    /**
     * @return the segunda
     */
    public String getSegunda() {
        return segunda;
    }
    /**
     * @param segunda the segunda to set
     */
    public void setSegunda(String segunda) {
        this.segunda = segunda;
    }
}
