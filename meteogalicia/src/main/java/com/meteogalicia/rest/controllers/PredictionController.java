package com.meteogalicia.rest.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meteogalicia.rest.dtos.PredictionsDTO;
import com.meteogalicia.services.PredictionService;

@RestController
@RequestMapping("/prediction")
public class PredictionController {

    private static String METEOGALICIA_URL = "https://servizos.meteogalicia.gal/mgrss/predicion/jsonPredConcellos.action?idConc=";

    private final PredictionService service;

    public PredictionController(PredictionService service) {
        this.service = service;
    }


    @GetMapping("/api/observacion/{municipio}")
    private List<PredictionsDTO> obtainPredictions(@PathVariable("municipio") String municipio) throws IOException{
        
        String url = METEOGALICIA_URL.concat(municipio);

        List<PredictionsDTO> dailyPredictions = new ArrayList<>();


		try {
			dailyPredictions = service.peticionHttpGet(url);
        } catch (Exception e) {
            // Manejar excepción
            e.printStackTrace();
        }

        return dailyPredictions;
    }

    
}
