package com.meteogalicia.rest.dtos;

public class PredictionsDTO {
    private RainProbabilityDTO pchoiva;
	private SkySituationDTO ceo;
    private Integer tMax;
    private Integer tMin;

    public PredictionsDTO() {
	}


	public RainProbabilityDTO getPchoiva() {
		return this.pchoiva;
	}

	public void setPchoiva(RainProbabilityDTO pchoiva) {
		this.pchoiva = pchoiva;
	}

	public SkySituationDTO getCeo() {
		return this.ceo;
	}

	public void setCeo(SkySituationDTO ceo) {
		this.ceo = ceo;
	}

	public Integer getTMax() {
		return this.tMax;
	}

	public void setTMax(Integer tMax) {
		this.tMax = tMax;
	}

	public Integer getTMin() {
		return this.tMin;
	}

	public void setTMin(Integer tMin) {
		this.tMin = tMin;
	}


}
