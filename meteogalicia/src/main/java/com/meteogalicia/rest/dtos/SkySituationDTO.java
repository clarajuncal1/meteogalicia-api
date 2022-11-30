package com.meteogalicia.rest.dtos;

public class SkySituationDTO {

    private String manha;
    private String tarde;
    private String noite;

    public SkySituationDTO() {
	}

    public String getManha() {
        return this.manha;
    }

    public void setManha(String manha) {
        this.manha = manha;
    }

    public String getTarde() {
        return this.tarde;
    }

    public void setTarde(String tarde) {
        this.tarde = tarde;
    }

    public String getNoite() {
        return this.noite;
    }

    public void setNoite(String noite) {
        this.noite = noite;
    }
  

}
