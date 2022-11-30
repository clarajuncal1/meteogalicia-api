package com.meteogalicia.services;

import java.util.List;
import com.meteogalicia.rest.dtos.PredictionsDTO;

public interface PredictionService {
    
    List<PredictionsDTO> peticionHttpGet(String petition) throws Exception;

}
