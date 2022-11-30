package com.meteogalicia.rest.dtos;

import java.util.Date;

public class PredictionDTO {
    
    private RainProbabilityDTO ceo;
    private Date dataPredicion;
    private Integer nivelAviso;
    private RainProbabilityDTO pchoiva;
    private Integer tMax;
    private Integer tMin;
    private Integer tmaxFranxa;
    private Integer tminFranxa;
    private Integer uvMax;
    private RainProbabilityDTO vento;


    public PredictionDTO() {
    }

    public RainProbabilityDTO getCeo() {
        return this.ceo;
    }

    public void setCeo(RainProbabilityDTO ceo) {
        this.ceo = ceo;
    }

    public Date getDataPredicion() {
        return this.dataPredicion;
    }

    public void setDataPredicion(Date dataPredicion) {
        this.dataPredicion = dataPredicion;
    }

    public Integer getNivelAviso() {
        return this.nivelAviso;
    }

    public void setNivelAviso(Integer nivelAviso) {
        this.nivelAviso = nivelAviso;
    }

    public RainProbabilityDTO getPchoiva() {
        return this.pchoiva;
    }

    public void setPchoiva(RainProbabilityDTO pchoiva) {
        this.pchoiva = pchoiva;
    }

    public Integer gettMax() {
        return this.tMax;
    }

    public void settMax(Integer tMax) {
        this.tMax = tMax;
    }

    public Integer gettMin() {
        return this.tMin;
    }

    public void settMin(Integer tMin) {
        this.tMin = tMin;
    }

    public Integer getTmaxFranxa() {
        return this.tmaxFranxa;
    }

    public void setTmaxFranxa(Integer tmaxFranxa) {
        this.tmaxFranxa = tmaxFranxa;
    }

    public Integer getTminFranxa() {
        return this.tminFranxa;
    }

    public void setTminFranxa(Integer tminFranxa) {
        this.tminFranxa = tminFranxa;
    }

    public Integer getUvMax() {
        return this.uvMax;
    }

    public void setUvMax(Integer uvMax) {
        this.uvMax = uvMax;
    }

    public RainProbabilityDTO getVento() {
        return this.vento;
    }

    public void setVento(RainProbabilityDTO vento) {
        this.vento = vento;
    }


    @Override
    public String toString() {
        return "{" +
            " ceo='" + getCeo() + "'" +
            ", dataPredicion='" + getDataPredicion() + "'" +
            ", nivelAviso='" + getNivelAviso() + "'" +
            ", pchoiva='" + getPchoiva() + "'" +
            ", tMax='" + gettMax() + "'" +
            ", tMin='" + gettMin() + "'" +
            ", tmaxFranxa='" + getTmaxFranxa() + "'" +
            ", tminFranxa='" + getTminFranxa() + "'" +
            ", uvMax='" + getUvMax() + "'" +
            ", vento='" + getVento() + "'" +
            "}";
    }

}
