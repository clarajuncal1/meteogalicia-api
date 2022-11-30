package com.meteogalicia.rest.dtos;

public class RainProbabilityDTO {

    private Integer manha;
    private Integer tarde;
    private Integer noite;

	public RainProbabilityDTO() {
	}

    public Integer getManha() {
        return this.manha;
    }

    public void setManha(Integer manha) {
        this.manha = manha;
    }

    public Integer getTarde() {
        return this.tarde;
    }

    public void setTarde(Integer tarde) {
        this.tarde = tarde;
    }

    public Integer getNoite() {
        return this.noite;
    }

    public void setNoite(Integer noite) {
        this.noite = noite;
    }

}
