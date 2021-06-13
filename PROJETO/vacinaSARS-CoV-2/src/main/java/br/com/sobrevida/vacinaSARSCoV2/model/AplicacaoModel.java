package br.com.sobrevida.vacinaSARSCoV2.model;

import java.sql.Date;

/**
 *
 * @author WERIKE
 */
public class AplicacaoModel extends VacinaModel{
    
    private int id;
    private int idCidadao;
    private int idVacina ;
    private int doseAplicada;
    private String dataAplicacao;
    private String previsao;

    /**
     * @return the id
     */
    @Override
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    @Override
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
    public int getDoseAplicada() {
        return doseAplicada;
    }
    /**
     * @param doseAplicada the dose to set
     */
    public void setDoseAplicada(int doseAplicada) {
        this.doseAplicada = doseAplicada;
    }
    /**
     * @return the unica
     */
    public String getDataAplicacao() {
        return dataAplicacao;
    }
    /**
     * @param dataAplicacao the unica to set
     */
    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
    /**
     * @return the primeira
     */
    public String getPrevisao() {
        return previsao;
    }
    /**
     * @param previsao the primeira to set
     */
    public void setPrevisao(String previsao) {
        this.previsao = previsao;
    }
}
