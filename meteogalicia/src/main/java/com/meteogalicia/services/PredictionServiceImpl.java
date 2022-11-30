package com.meteogalicia.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meteogalicia.rest.dtos.PredictionDTO;
import com.meteogalicia.rest.dtos.PredictionsDTO;
import com.meteogalicia.rest.dtos.RainProbabilityDTO;
import com.meteogalicia.rest.dtos.SkySituationDTO;

@Service
public class PredictionServiceImpl implements PredictionService {

    private final ObjectMapper mapper;

    public PredictionServiceImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }
    
    public List<PredictionsDTO> peticionHttpGet(String petition) throws Exception {
        
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaPManhana = fechaActual.plusDays(2);

        URL url = new URL(petition);

        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");    
        List<PredictionDTO> dailyPredictionList = parseConexionResult(conexion.getInputStream());

        List<PredictionsDTO> dailyPredictionResult = new ArrayList<>();

        for(PredictionDTO s: dailyPredictionList) {

            LocalDate dataPrediction = s.getDataPredicion().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            if (!dataPrediction.isAfter(fechaPManhana) && !dataPrediction.isBefore(fechaActual)) {
                PredictionsDTO prediction = new PredictionsDTO();
                RainProbabilityDTO rainProbability = new RainProbabilityDTO();
                SkySituationDTO wind = new SkySituationDTO();
                rainProbability.setManha(s.getPchoiva().getManha());
                rainProbability.setTarde(s.getPchoiva().getTarde());
                rainProbability.setNoite(s.getPchoiva().getNoite());
                wind.setManha(getMorningSkyState(s.getCeo().getManha()));
                wind.setTarde(getMorningSkyState(s.getCeo().getTarde()));
                wind.setNoite(getNightSkyState(s.getCeo().getNoite()));
                prediction.setTMax(s.gettMax());
                prediction.setTMin(s.gettMin());
                prediction.setPchoiva(rainProbability);
                prediction.setCeo(wind);
                dailyPredictionResult.add(prediction);
            }
        }

        return dailyPredictionResult;
    }

    private List<PredictionDTO> parseConexionResult(InputStream is) throws IOException {
        StringBuilder result = new StringBuilder();
        String line = "";

        Map<String, Object> predictions = new HashMap<>();
        Map<String, Object>  predConcello;
        String listaPredDiaConcello;

        // Búferes para leer
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));

        while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		// Cerrar el BufferedReader
		rd.close();

        predictions = mapper.readValue(result.toString(), Map.class);
        predConcello = mapper.readValue(mapper.writeValueAsString(predictions.get("predConcello")), Map.class);
        listaPredDiaConcello = mapper.writeValueAsString(predConcello.get("listaPredDiaConcello"));
        return mapper.readValue(listaPredDiaConcello, new TypeReference<List<PredictionDTO> >() {});
    }

    private String getMorningSkyState(Integer sky) {
        switch(sky) {
            case 101:
                return "Despejado";
            case 102:
                return "Nubes altas";
            case 103:
                return "Nubes y claros";
            case 104:
                return "Nublado 75%";
            case 105:
                return "Cubierto";
            case 106:
                return "Nieblas";
            case 107:
                return "Chubasco";
            case 108:
                return "Chubasco (75%)";
            case 109:
                return "Chubasco nieve";
            case 110:
                return "Llovizna";
            case 111:
                return "Lluvia";
            case 112:
                return "Nieve";
            case 113:
                return "Tormenta";
            case 114:
                return "Bruma";
            case 115:
                return "Bancos de niebla";
            case 116:
                return "Nubes medias";
            case 117:
                return "Lluvia débil";
            case 118:
                return "Chubascos débiles";
            case 119:
                return "Tormenta con pocas nubes";
            case 120:
                return "Agua nieve";
            case 121:
                return "Granizo";
            default:
               return "No Disponible";
          }
    }

    private String getNightSkyState(Integer sky) {
        switch(sky) {
            case 201:
                return "Despejado";
            case 202:
                return "Nubes altas";
            case 203:
                return "Nubes y claros";
            case 204:
                return "Nublado 75%";
            case 205:
                return "Cubierto";
            case 206:
                return "Nieblas";
            case 207:
                return "Chubasco";
            case 208:
                return "Chubasco (75%)";
            case 209:
                return "Chubasco nieve";
            case 210:
                return "Llovizna";
            case 211:
                return "Lluvia";
            case 212:
                return "Nieve";
            case 213:
                return "Tormenta";
            case 214:
                return "Bruma";
            case 215:
                return "Bancos de niebla";
            case 216:
                return "Nubes medias";
            case 217:
                return "Lluvia débil";
            case 218:
                return "Chubascos débiles";
            case 219:
                return "Tormenta con pocas nubes";
            case 220:
                return "Agua nieve";
            case 221:
                return "Granizo";
            default:
               return "No Disponible";
          }
    }
}
